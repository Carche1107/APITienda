package com.avvale.API.APITienda.Controllers;

import com.avvale.API.APITienda.DTO.ProductListDTO;
import com.avvale.API.APITienda.Services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductoController {

    @Autowired
    ProductoService productoService;
    //obtener Listado de Id y Nombre de Producto
    @GetMapping
    public ResponseEntity<List<ProductListDTO>> getAll() {
        List<ProductListDTO> shops = productoService.getProducts();
        return ResponseEntity.ok()
                .header("Content-Type", "application/json")
                .body(shops);
    }
}
