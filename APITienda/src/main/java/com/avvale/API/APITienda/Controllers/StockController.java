package com.avvale.API.APITienda.Controllers;

import com.avvale.API.APITienda.DTO.StockDetailsDTO;
import com.avvale.API.APITienda.DTO.StockListWithPrice;
import com.avvale.API.APITienda.Services.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Stock")
public class StockController {

    @Autowired
    StockService stockService;

    //DEVOLVER EL STOCK DE UN PRODUCTO Y COLOR DADO DE CADA TIENDA
    @GetMapping
    public List<StockListWithPrice> getStockListWithPrice(){
        return stockService.getPrices();
    }

    //Para obtener el listado de todos los stocks en función del producto y el color
    @GetMapping(path = "/product")
    public ResponseEntity<List<StockDetailsDTO>> getStockDetails(@RequestParam("product") Long productId, @RequestParam("color") Long colorId){

        List<StockDetailsDTO> stocks = stockService.findStockByProductAndColor(productId, colorId);
        return ResponseEntity.ok()
                .header("Content-Type", "application/json")
                .body(stocks);
    }
    @PostMapping
    public Integer findStock(@RequestParam("p") Long productName, @RequestParam("c") Long colorName, @RequestParam("s") Long shopName ){
        return stockService.findStocksByShopProductAndColor(productName, colorName, shopName);
    }

    @PutMapping
    public void updateStock(@RequestParam("p") Long productName, @RequestParam("c") Long colorName, @RequestParam("s") Long shopName, @RequestParam("a") Integer Amount){
        stockService.updateStockAmount(productName, colorName, shopName, Amount);
    }
}
