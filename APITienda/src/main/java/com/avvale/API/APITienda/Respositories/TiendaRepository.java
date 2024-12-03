package com.avvale.API.APITienda.Respositories;

import com.avvale.API.APITienda.Models.TiendaModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TiendaRepository extends CrudRepository<TiendaModel, Long> {

    @Query(value = "SELECT t.name, t.current_cash FROM shop AS t", nativeQuery = true)
    List<Object[]> findActualCash();

    @Query(value = "SELECT s.`increment` FROM shop s WHERE s.name = :name", nativeQuery = true)
    double incrementCash(@Param("name") String name);

    @Query(value = "SELECT s.id, s.name FROM shop s;", nativeQuery = true)
    List<Object[]> getIdAndName();


}
