package com.avvale.API.APITienda.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;
import java.util.List;

public class ShopDetailsWithTimeDTO {

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime time;
    private List<ShopCurrentCashDTO> shopCurrentCashDTOList;

    public ShopDetailsWithTimeDTO(List<ShopCurrentCashDTO> shopCurrentCashDTOList) {
        this.time = LocalDateTime.now();
        this.shopCurrentCashDTOList = shopCurrentCashDTOList;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public List<ShopCurrentCashDTO> getShopCurrentCashDTOList() {
        return shopCurrentCashDTOList;
    }

    public void setShopCurrentCashDTOList(List<ShopCurrentCashDTO> shopCurrentCashDTOList) {
        this.shopCurrentCashDTOList = shopCurrentCashDTOList;
    }
}
