package com.avvale.API.APITienda.DTO;

public class ColorListDTO {

    private Long idColor;
    private String color;

    public ColorListDTO(Long id, String color) {
        this.idColor = id;
        this.color = color;
    }

    public Long getId() {
        return idColor;
    }

    public void setId(Long id) {
        this.idColor = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
