package com.avvale.API.APITienda.DTO;

import java.math.BigDecimal;

public class DiscountPriceDTO {

    private double DiscountApplied;
    private BigDecimal DiscountPrice;

    public DiscountPriceDTO(double Discount, BigDecimal DiscountPrice) {
        this.DiscountApplied = Discount;
        this.DiscountPrice = DiscountPrice;

    }

    public double getDiscount() {
        return DiscountApplied;
    }

    public void setDiscount(double discount) {
        DiscountApplied = discount;
    }

    public BigDecimal getDiscountPrice() {
        return DiscountPrice;
    }

    public void setDiscountPrice(BigDecimal discountPrice) {
        DiscountPrice = discountPrice;
    }

}
