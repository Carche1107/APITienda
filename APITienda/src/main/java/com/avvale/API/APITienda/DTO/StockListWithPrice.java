package com.avvale.API.APITienda.DTO;

import java.math.BigDecimal;

public class StockListWithPrice {
    private String shopName;
    private String productName;
    private String color;
    private Integer stockAmount;
    private BigDecimal priceWithTax;
    private BigDecimal priceWithDiscounts;

    public StockListWithPrice(String shopName, String productName, String color, Integer stockAmount, BigDecimal priceWithTax, BigDecimal priceWithDiscounts) {
        this.shopName = shopName;
        this.productName = productName;
        this.color = color;
        this.stockAmount = stockAmount;
        this.priceWithTax = priceWithTax;
        this.priceWithDiscounts = priceWithDiscounts;
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getStockAmount() {
        return stockAmount;
    }

    public void setStockAmount(Integer stockAmount) {
        this.stockAmount = stockAmount;
    }

    public BigDecimal getPriceWithTax() {
        return priceWithTax;
    }

    public void setPriceWithTax(BigDecimal priceWithTax) {
        this.priceWithTax = priceWithTax;
    }

    public BigDecimal getPriceWithDiscounts() {
        return priceWithDiscounts;
    }

    public void setPriceWithDiscounts(BigDecimal priceWithDiscounts) {
        this.priceWithDiscounts = priceWithDiscounts;
    }
}
