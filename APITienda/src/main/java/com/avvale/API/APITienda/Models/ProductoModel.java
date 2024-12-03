package com.avvale.API.APITienda.Models;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

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

    /*@OneToMany(mappedBy = "stock_product_FK", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<StockModel> stocks;

    @OneToMany(mappedBy = "Ventas_product_FK", cascade = CascadeType.PERSIST)
    private List<StockModel> sales;*/

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

    /*public List<StockModel> getStocks() {
        return stocks;
    }

    public void setStocks(List<StockModel> stocks) {
        this.stocks = stocks;
    }*/

    public BigDecimal getInitialPrice() {
        return InitialPrice;
    }

    public void setInitialPrice(BigDecimal initialPrice) {
        InitialPrice = initialPrice;
    }

    /*public List<StockModel> getSales() {
        return sales;
    }

    public void setSales(List<StockModel> sales) {
        this.sales = sales;
    }*/
}
