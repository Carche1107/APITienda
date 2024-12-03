package com.avvale.API.APITienda.DTO;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ShopCurrentCashDTO {

    private String shopName;
    private BigDecimal currentCash;

    public ShopCurrentCashDTO(String shopName, BigDecimal currentCash) {
        this.shopName = shopName;
        this.currentCash = currentCash;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public BigDecimal getCurrentCash() {
        return currentCash;
    }

    public void setCurrentCash(BigDecimal currentCash) {
        this.currentCash = currentCash;
    }
}
