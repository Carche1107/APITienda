package com.avvale.API.APITienda.Respositories;

import com.avvale.API.APITienda.DTO.DiscountPriceDTO;
import com.avvale.API.APITienda.Models.DiscountModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public interface DiscountRepository extends CrudRepository<DiscountModel, Long> {

    @Query(value = "SELECT\n" +
            "CASE \n" +
            "\tWHEN increment_type = 'P' THEN (:Precio * discount)\n" +
            "\tWHEN increment_type = 'M' THEN discount\n" +
            "END AS DISCOUNT_APPLIED\n" +
            ",CASE \n" +
            "\tWHEN increment_type = 'P' THEN (:Precio - (:Precio * discount))\n" +
            "\tWHEN increment_type = 'M' THEN (:Precio - discount)\n" +
            "END AS DISCOUNT_PRICE\n" +
            "FROM discounts \n" +
            "WHERE day_type = :Day OR (day_type = 'ALL' AND :time >= initial_hour AND :time < final_hour)\n" +
            "ORDER BY DISCOUNT_PRICE ASC\n" +
            "LIMIT 1", nativeQuery = true)
    List<Object[]> discountsByDayAndTime(@Param("Day") String day, @Param("time") int time, @Param("Precio") BigDecimal precio);
}
