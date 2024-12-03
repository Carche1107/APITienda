package com.avvale.API.APITienda.Controllers;

import com.avvale.API.APITienda.DTO.DiscountPriceDTO;
import com.avvale.API.APITienda.Models.DiscountModel;
import com.avvale.API.APITienda.Services.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/discounts")
public class DiscountController {

    @Autowired
    DiscountService discountService;

    @GetMapping
    public List<DiscountPriceDTO> getDiscountsByDayAndHour(@RequestParam("Day") String day, @RequestParam("Hour") int hour, @RequestParam("price") BigDecimal price) {

        return discountService.findDiscountsByDayAndTime(day, hour, price);
    }
}
