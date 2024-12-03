package com.avvale.API.APITienda.Services;

import com.avvale.API.APITienda.DTO.DiscountPriceDTO;
import com.avvale.API.APITienda.DTO.ReturnsDTO;
import com.avvale.API.APITienda.DTO.SalesDTO;
import com.avvale.API.APITienda.Enums.DayType;
import com.avvale.API.APITienda.Models.*;
import com.avvale.API.APITienda.Respositories.SalesRepository;
import com.avvale.API.APITienda.Respositories.StockRepository;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SalesService {

    @Autowired
    SalesRepository salesRepository;
    @Autowired
    ProductoService productoService;
    @Autowired
    ColorService colorService;
    @Autowired
    TiendaService tiendaService;
    @Autowired
    DiscountService discountService;
    @Autowired
    private StockRepository stockRepository;
    @Autowired
    private StockService stockService;

    public ArrayList<SalesModel> Test(){
        return (ArrayList<SalesModel>) salesRepository.findAll();
    }

    public SalesModel mapDTO(SalesDTO salesDTO, ProductoModel producto, TiendaModel tienda, ColorModel color){
        if (salesDTO == null) {
            throw new IllegalArgumentException("El DTO no puede ser nulo");
        }
        SalesModel salesModel = new SalesModel();
        if (salesDTO.getIdProduct() == null || salesDTO.getIdColor() == null || salesDTO.getIdShop() == null) {
            throw new RuntimeException("No se ha podido completar la venta, falta color, tienda o producto");
        }

        salesModel.setIdShop(tienda);
        salesModel.setIdProduct(producto);
        salesModel.setIdColor(color);
        salesModel.setInitialPrice(salesDTO.getInitialPrice());
        salesModel.setTotalProducts(salesDTO.getTotalProducts());
        salesModel.setTotalPrice(salesDTO.getTotalPrice());
        salesModel.setDiscountApplied(salesDTO.getDiscountApplied());
        salesModel.setIncrementApplied(salesDTO.getIncrementApplied());
        salesModel.setTime(salesDTO.getTime());
        salesModel.setReturned(false);
        return salesModel;

    }
//Cambiar a SalesModel
    public ResponseEntity<String> SellProduct(SalesDTO sale) {

        if (sale == null) {
            throw new RuntimeException("No se ha podido completar la venta, no existe una compra asociada");
        }
        if (sale.getIdProduct() == null || sale.getIdColor() == null || sale.getIdShop() == null) {
            throw new RuntimeException("No se ha podido completar la venta, falta color, tienda o producto");
        }

        TiendaModel tienda = tiendaService.findById(sale.getIdShop());
        ProductoModel producto = productoService.findById(sale.getIdProduct());
        ColorModel color = colorService.findById(sale.getIdColor());
        sale.setInitialPrice(producto.getInitialPrice().setScale(2, RoundingMode.HALF_UP));
        sale.setTotalPrice(sale.getInitialPrice().setScale(2, RoundingMode.HALF_UP).multiply(((BigDecimal.valueOf(tienda.getIncrement())).add(BigDecimal.ONE))));
        //sale.setTime(LocalDateTime.now());


        switch (color.getIncrement_Type()){
            case M -> {
                sale.setTotalPrice(sale.getTotalPrice().setScale(2, RoundingMode.HALF_UP).add(BigDecimal.valueOf(color.getIncrement()).setScale(2, RoundingMode.HALF_UP)));
            }
            case P -> {
                sale.setTotalPrice(sale.getTotalPrice().multiply((BigDecimal.valueOf(color.getIncrement()).setScale(2, RoundingMode.HALF_UP).add(BigDecimal.ONE))));
            }
        }

        sale.setIncrementApplied(sale.getTotalPrice().subtract(sale.getInitialPrice()).doubleValue());

        List<DiscountPriceDTO> discounts = discountService.findDiscountsByDayAndTime(sale.getTime().getDayOfWeek().toString(), sale.getTime().getHour(), sale.getTotalPrice());

        sale.setTotalPrice(discounts.getFirst().getDiscountPrice().setScale(2, RoundingMode.HALF_UP));
        sale.setDiscountApplied(discounts.getFirst().getDiscount());

        sale.setTotalPrice(sale.getTotalPrice().multiply(new BigDecimal(sale.getTotalProducts().toString())));

        stockService.updateStockAmount(sale.getIdProduct(), sale.getIdColor(), sale.getIdShop(), sale.getTotalProducts());
        tiendaService.updateCashAdd(tienda, sale.getTotalPrice());


        SalesModel salesModel = mapDTO(sale, producto, tienda, color);

        //salesModel.setTime(LocalDateTime.now());

        salesRepository.save(salesModel);
        return ResponseEntity.ok("Compra realizada con éxito");
        //return salesModel;
    }

    public List<ReturnsDTO>getAllSalesByDayAndHour(Long ShopId, String Day, Integer Hour, Integer Minute) {

        List<Object[]> sales = salesRepository.findSalesByDayAndHour(ShopId, Day, Hour, Minute);
        if (sales == null || sales.isEmpty()) {
            return new ArrayList<>();
        }
        return sales.stream().map(row -> new ReturnsDTO((Long) row[0], (String) row[1], (String) row[2], (String) row[3], (String) row[4], (String) row[5], new BigDecimal(row[6].toString()), (Integer) row[7])).collect(Collectors.toList());
    }
}
