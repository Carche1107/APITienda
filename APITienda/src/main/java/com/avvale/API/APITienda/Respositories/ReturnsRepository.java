package com.avvale.API.APITienda.Respositories;

import com.avvale.API.APITienda.Models.ReturnsModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReturnsRepository extends CrudRepository<ReturnsModel, Long> {

}
