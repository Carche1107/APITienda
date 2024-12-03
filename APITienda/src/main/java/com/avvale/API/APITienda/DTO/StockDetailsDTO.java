package com.avvale.API.APITienda.DTO;

public class StockDetailsDTO {

    private String nombreTienda;
    private String nombreProducto;
    private String nombreColor;
    private Integer cantidadStock;

    public StockDetailsDTO(String nombreTienda, String nombreProducto, String nombreColor, Integer cantidadStock) {
        this.nombreTienda = nombreTienda;
        this.nombreProducto = nombreProducto;
        this.nombreColor = nombreColor;
        this.cantidadStock = cantidadStock;
    }

    public String getNombreTienda() {
        return nombreTienda;
    }

    public void setNombreTienda(String nombreTienda) {
        this.nombreTienda = nombreTienda;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getNombreColor() {
        return nombreColor;
    }

    public void setNombreColor(String nombreColor) {
        this.nombreColor = nombreColor;
    }

    public Integer getCantidadStock() {
        return cantidadStock;
    }

    public void setCantidadStock(Integer cantidadStock) {
        this.cantidadStock = cantidadStock;
    }
}
