package com.avvale.API.APITienda.Controllers;

import com.avvale.API.APITienda.DTO.ShopCurrentCashDTO;
import com.avvale.API.APITienda.DTO.ShopDetailsWithTimeDTO;
import com.avvale.API.APITienda.DTO.ShopListDTO;
import com.avvale.API.APITienda.Services.TiendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/Shop")
public class TiendaController {

    @Autowired
    TiendaService tiendaService;

    @GetMapping
    public ResponseEntity<List<ShopListDTO>> getAll() {
        List<ShopListDTO> shops = tiendaService.getShops();
        return ResponseEntity.ok()
                .header("Content-Type", "application/json")
                .body(shops);
    }
    //PUNTO 4: Listado de las cajas de cada tienda a la hora actual
    @GetMapping(path = "/Cash")
    public ShopDetailsWithTimeDTO getCurrentCashForEachShop(){
        return tiendaService.ObtenerCajasActuales();
    }
}
