package com.avvale.API.APITienda.Services;

import com.avvale.API.APITienda.DTO.ProductListDTO;
import com.avvale.API.APITienda.Models.ProductoModel;
import com.avvale.API.APITienda.Respositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductoService {

    @Autowired
    ProductoRepository productoRepository;

    public ProductoModel findById(Long id) {
        return productoRepository.findById(id).orElse(null);
    }
    //Listar Id y Nombre de productos para mostrarlos en Combo en Front
    public List<ProductListDTO> getProducts() {
        List<Object[]> colors = productoRepository.getProducts();
        return colors.stream().map(row -> new ProductListDTO((Long) row[0], (String) row[1])).collect(Collectors.toList());
    }

}
