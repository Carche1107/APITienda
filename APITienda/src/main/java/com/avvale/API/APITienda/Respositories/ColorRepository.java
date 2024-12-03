package com.avvale.API.APITienda.Respositories;


import com.avvale.API.APITienda.Models.ColorModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ColorRepository extends CrudRepository<ColorModel, Long> {

    @Query(value = "SELECT c.increment_type FROM color c WHERE c.color = :color", nativeQuery = true)
    String getColorIncrementType(@Param("color") String color);

    @Query(value = "SELECT c.`increment` FROM color c WHERE c.color = :color", nativeQuery = true)
    double getColorIncrement(@Param("color") String color);

    @Query(value = "SELECT c.id, c.color FROM color c  ", nativeQuery = true)
    List<Object[]> getColors();

}
