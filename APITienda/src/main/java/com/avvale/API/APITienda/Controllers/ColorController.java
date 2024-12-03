package com.avvale.API.APITienda.Controllers;

import com.avvale.API.APITienda.DTO.ColorListDTO;
import com.avvale.API.APITienda.Services.ColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/color")
public class ColorController {

    @Autowired
    ColorService colorService;
    //obtener Listado de Id y Nombre de Color
    @GetMapping
    public ResponseEntity<List<ColorListDTO>> getAll() {
        List<ColorListDTO> shops = colorService.getColors();
        return ResponseEntity.ok()
                .header("Content-Type", "application/json")
                .body(shops);
    }
}
