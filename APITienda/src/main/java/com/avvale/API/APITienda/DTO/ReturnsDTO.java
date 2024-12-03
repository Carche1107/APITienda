package com.avvale.API.APITienda.DTO;

import com.avvale.API.APITienda.Enums.DayType;
import com.avvale.API.APITienda.Enums.IncrementType;
import com.avvale.API.APITienda.Models.ColorModel;
import com.avvale.API.APITienda.Models.ProductoModel;
import com.avvale.API.APITienda.Models.TiendaModel;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ReturnsDTO {

    private Long saleId;
    private String shopName;
    private String productName;
    private String colorName;
    //@JsonFormat(pattern = "yyyy-mm-dd HH:mm:ss")
    private String time;
    private String dayType;
    private BigDecimal price;
    private Integer totalProducts;

    public ReturnsDTO(Long SaleId, String ShopName, String ProductName, String ColorName, String Time, String DayType, BigDecimal Price, Integer TotalProducts) {
        this.saleId = SaleId;
        this.shopName = ShopName;
        this.productName = ProductName;
        this.colorName = ColorName;
        this.time = Time;
        this.dayType = DayType;
        this.price = Price;
        this.totalProducts = TotalProducts;
    }

    public Long getSaleId() {
        return saleId;
    }

    public void setSaleId(Long saleId) {
        this.saleId = saleId;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDayType() {
        return dayType;
    }

    public void setDayType(String dayType) {
        this.dayType = dayType;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getTotalProducts() {
        return totalProducts;
    }

    public void setTotalProducts(Integer totalProducts) {
        this.totalProducts = totalProducts;
    }
}
