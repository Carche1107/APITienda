package com.avvale.API.APITienda.Services;

import com.avvale.API.APITienda.DTO.ReturnsDTO;
import com.avvale.API.APITienda.Models.ReturnsModel;
import com.avvale.API.APITienda.Models.SalesModel;
import com.avvale.API.APITienda.Models.TiendaModel;
import com.avvale.API.APITienda.Respositories.ReturnsRepository;
import com.avvale.API.APITienda.Respositories.SalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ReturnsServices {

    @Autowired
    ReturnsRepository returnsRepository;
    @Autowired
    SalesRepository salesRepository;
    @Autowired
    StockService stockService;
    @Autowired
    TiendaService tiendaService;

    public ResponseEntity<String> CreateReturn(Long saleId) {

        SalesModel salesModel = salesRepository.findById(saleId).orElseThrow(() ->new RuntimeException("venta no encontrada"));

        ReturnsModel returnsModel = new ReturnsModel();
        returnsModel.setSale(salesModel);
        returnsModel.setProductsLeft(salesModel.getTotalProducts());
        salesModel.setReturned(true);
        returnsRepository.save(returnsModel);
        stockService.updateStockAmountReturns(salesModel.getIdProduct().getId(), salesModel.getIdColor().getId(), salesModel.getIdShop().getId(), salesModel.getTotalProducts());
        tiendaService.updateCashSubstract(salesModel.getIdShop(), salesModel.getTotalPrice());
        return ResponseEntity.ok()
                .body("Se ha devuelto la compra con éxito");

    }
}
