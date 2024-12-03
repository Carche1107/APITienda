package com.avvale.API.APITienda.Services;

import com.avvale.API.APITienda.DTO.DiscountPriceDTO;
import com.avvale.API.APITienda.Models.DiscountModel;
import com.avvale.API.APITienda.Respositories.DiscountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DiscountService {
    @Autowired
    DiscountRepository discountRepository;

    public List<DiscountPriceDTO> findDiscountsByDayAndTime(String Day, int time, BigDecimal Price) {

        List<Object[]> discounts = discountRepository.discountsByDayAndTime(Day, time, Price);

        return discounts.stream().map(row -> new DiscountPriceDTO((double) row[0], new BigDecimal(row[1].toString()))).collect(Collectors.toList());

    }
}
