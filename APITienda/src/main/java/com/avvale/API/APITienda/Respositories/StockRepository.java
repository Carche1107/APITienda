package com.avvale.API.APITienda.Respositories;

import com.avvale.API.APITienda.Models.StockModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockRepository extends CrudRepository<StockModel, Long> {

    @Query(value = "SELECT t.name, p.`type`, c.color, s.amount FROM stock AS s INNER JOIN shop AS t ON s.tienda_id = t.id INNER JOIN product AS p ON s.producto_id = p.id " +
            "INNER JOIN color AS c ON s.color_id = c.id WHERE s.producto_id = :product AND s.color_id = :color", nativeQuery = true)
    List<Object[]> findByProductAndColor(@Param("product") Long product, @Param("color") Long color);

    @Query(value = "SELECT * FROM stock WHERE producto_id = :product AND color_id = :color AND tienda_id = :shop", nativeQuery = true)
    StockModel findStock(@Param("product") Long product, @Param("color") Long color, @Param("shop") Long id);

    @Query(value = "SELECT amount FROM stock WHERE producto_id = :product AND color_id = :color AND tienda_id = :shop", nativeQuery = true)
    Integer getAmountByShopProductAndColor(@Param("product") Long productId, @Param("color") Long colorId, @Param("shop") Long shopId);


    @Query(value = "SELECT t.name, p.`type`, c.color , s.amount, p.initial_price FROM stock s INNER JOIN shop t on s.tienda_id = t.id INNER JOIN product p ON s.producto_id = p.id \n" +
            "INNER JOIN color c ON s.color_id = c.id ", nativeQuery = true)
    List<Object[]> ListStocks();


}
