package com.avvale.API.APITienda.Respositories;

import com.avvale.API.APITienda.Models.SalesModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalesRepository extends CrudRepository<SalesModel, Long> {

    @Query(value="SELECT v.id, s.name, p.`type`, c.color, DATE_FORMAT(v.`time`, '%d-%m-%y %H:%i') , CASE \n" +
            "\tWHEN WEEKDAY(v.`time`) = 0 THEN 'MONDAY'\n" +
            "\tWHEN WEEKDAY(v.`time`) = 1 THEN 'TUESDAY'\n" +
            "\tWHEN WEEKDAY(v.`time`) = 2 THEN 'WEDNESDAY'\n" +
            "\tWHEN WEEKDAY(v.`time`) = 3 THEN 'THURSDAY'\n" +
            "\tWHEN WEEKDAY(v.`time`) = 4 THEN 'FRIDAY'\n" +
            "\tWHEN WEEKDAY(v.`time`) = 5 THEN 'SATURDAY'\n" +
            "\tWHEN WEEKDAY(v.`time`) = 6 THEN 'SUNDAY'\n" +
            "END AS Day, v.total_price, v.total_products \n" +
            "FROM Ventas v INNER JOIN shop s on v.id_shop = s.id \n" +
            "INNER JOIN product p ON v.id_product = p.id\n" +
            "INNER JOIN color c ON v.id_color = c.id\n" +
            "WHERE id_shop = :shop AND CASE \n" +
            "\tWHEN WEEKDAY(v.`time`) = 0 THEN 'MONDAY'\n" +
            "\tWHEN WEEKDAY(v.`time`) = 1 THEN 'TUESDAY'\n" +
            "\tWHEN WEEKDAY(v.`time`) = 2 THEN 'WEDNESDAY'\n" +
            "\tWHEN WEEKDAY(v.`time`) = 3 THEN 'THURSDAY'\n" +
            "\tWHEN WEEKDAY(v.`time`) = 4 THEN 'FRIDAY'\n" +
            "\tWHEN WEEKDAY(v.`time`) = 5 THEN 'SATURDAY'\n" +
            "\tWHEN WEEKDAY(v.`time`) = 6 THEN 'SUNDAY'\n" +
            "END = :Day AND HOUR(v.`time`) = :Hour AND MINUTE(v.`time`) = :Minute AND v.Returned = false", nativeQuery = true)
    List<Object[]> findSalesByDayAndHour(@Param("shop") Long ShopId, @Param("Day") String day, @Param("Hour") Integer hour, @Param("Minute") Integer minute);
}
