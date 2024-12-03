package com.avvale.API.APITienda.Models;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "Product")
public class ProductoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long Id;

    @Column(nullable = false)
    private String Type;

    @Column(nullable = false)
    private BigDecimal InitialPrice;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        this.Id = id;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        this.Type = type;
    }


    public BigDecimal getInitialPrice() {
        return InitialPrice;
    }

    public void setInitialPrice(BigDecimal initialPrice) {
        InitialPrice = initialPrice;
    }

}
