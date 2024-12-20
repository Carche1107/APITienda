package com.avvale.API.APITienda.Services;

import com.avvale.API.APITienda.DTO.ShopCurrentCashDTO;
import com.avvale.API.APITienda.DTO.ShopDetailsWithTimeDTO;
import com.avvale.API.APITienda.DTO.ShopListDTO;
import com.avvale.API.APITienda.Models.TiendaModel;
import com.avvale.API.APITienda.Respositories.TiendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TiendaService {

    @Autowired
    TiendaRepository tiendaRepository;

    public TiendaModel findById(Long Id) { return tiendaRepository.findById(Id).orElse(null);}

    //Listado de las cajas de cada tienda en la hora actual
    public ShopDetailsWithTimeDTO ObtenerCajasActuales() {

        List<Object[]> shops = tiendaRepository.findActualCash();
        List<ShopCurrentCashDTO> AllShops = shops.stream().map(row -> new ShopCurrentCashDTO((String) row[0], new BigDecimal(row[1].toString()))).collect(Collectors.toList());
        return new ShopDetailsWithTimeDTO(AllShops);
    }
    //Sumar precio de compra a la caja
    public void updateCashAdd(TiendaModel tienda, BigDecimal Cash) {
        tienda.setCurrentCash(tienda.getCurrentCash().add(Cash));
        tiendaRepository.save(tienda);
    }
    //Restar devolucion a la caja
    public void updateCashSubstract(TiendaModel tienda, BigDecimal Cash) {
        tienda.setCurrentCash(tienda.getCurrentCash().subtract(Cash));
        tiendaRepository.save(tienda);
    }
    //Listar Id y Nombre de tiendas para mostrarlos en Combo en Front
    public List<ShopListDTO> getShops() {

        List<Object[]> shops = tiendaRepository.getIdAndName();
        return shops.stream().map(row -> new ShopListDTO((Long) row[0], (String) row[1])).collect(Collectors.toList());
    }


}
