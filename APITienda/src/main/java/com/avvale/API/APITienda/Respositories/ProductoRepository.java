package com.avvale.API.APITienda.Respositories;

import com.avvale.API.APITienda.Models.ProductoModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends CrudRepository<ProductoModel, Long> {

    @Query(value = "SELECT p.id, p.`type` FROM product p", nativeQuery = true)
    List<Object[]>getProducts();


}
