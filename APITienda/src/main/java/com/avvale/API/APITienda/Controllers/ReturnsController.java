package com.avvale.API.APITienda.Controllers;

import com.avvale.API.APITienda.DTO.ReturnsDTO;
import com.avvale.API.APITienda.Models.ReturnsModel;
import com.avvale.API.APITienda.Services.ReturnsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Return")
public class ReturnsController {

    @Autowired
    ReturnsServices returnsServices;

    @PostMapping
    public ResponseEntity<?> returns(@RequestParam("saleId") Long saleId) {
        return returnsServices.CreateReturn(saleId);
    }
}
