package com.avvale.API.APITienda.Services;


import com.avvale.API.APITienda.DTO.ColorListDTO;
import com.avvale.API.APITienda.Models.ColorModel;
import com.avvale.API.APITienda.Respositories.ColorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ColorService {

    @Autowired
    ColorRepository colorRepository;

    public ColorModel findById(Long Id) {
        return colorRepository.findById(Id).orElse(null);
    }
    //Listar Id y Nombre de colores para mostrarlos en Combo en Front
    public List<ColorListDTO> getColors() {
        List<Object[]> colors = colorRepository.getColors();
        return colors.stream().map(row -> new ColorListDTO((Long) row[0], (String) row[1])).collect(Collectors.toList());
    }

}
