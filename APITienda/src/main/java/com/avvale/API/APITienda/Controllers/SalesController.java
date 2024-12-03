package com.avvale.API.APITienda.Controllers;

import com.avvale.API.APITienda.DTO.ReturnsDTO;
import com.avvale.API.APITienda.DTO.SalesDTO;
import com.avvale.API.APITienda.Models.SalesModel;
import com.avvale.API.APITienda.Services.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/Sell")
public class SalesController {
    @Autowired
    SalesService salesService;

    @GetMapping
    public ResponseEntity<List<ReturnsDTO>> Test(@RequestParam("shop") Long shopId, @RequestParam("Day") String Day, @RequestParam("Hour") Integer Hour, @RequestParam("Minute") Integer Minute) {
        List<ReturnsDTO> sales = salesService.getAllSalesByDayAndHour(shopId, Day, Hour, Minute);

        return ResponseEntity.ok()
                .header("Content-Type", "application/json")
                .body(sales);
    }

    @PostMapping
    public ResponseEntity<?> sell(@RequestBody SalesDTO sales) {
        return salesService.SellProduct(sales);
    }
}
