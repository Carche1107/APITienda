package com.avvale.API.APITienda.DTO;

public class ShopListDTO {

    private Long shopId;
    private String shopName;

    public ShopListDTO(Long shopId, String shopName) {
        this.shopId = shopId;
        this.shopName = shopName;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }
}
