package com.avvale.API.APITienda.Models;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "Shop")
public class TiendaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long Id;

    @Column(nullable = false)
    private String Name;

    @Column(nullable = false)
    private double Increment;

    @Column(nullable = false)
    private BigDecimal CurrentCash;

    /*@OneToMany(mappedBy = "tienda", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<StockModel> stocks;

    @OneToMany(mappedBy = "IdShop", cascade = CascadeType.PERSIST)
    private List<SalesModel> sales;*/

    public BigDecimal getCurrentCash() {
        return CurrentCash;
    }

    public void setCurrentCash(BigDecimal currentCash) {
        this.CurrentCash = currentCash;
    }

    public void setIncrement(Double increment) {
        Increment = increment;
    }

    public void setId(Long id) {
        this.Id = id;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public Long getId() {
        return Id;
    }

    public String getName() {
        return Name;
    }

    public Double getIncrement() {
        return Increment;
    }

    /*public List<StockModel> getStocks() {
        return stocks;
    }

    public void setStocks(List<StockModel> stocks) {
        this.stocks = stocks;
    }

    public List<SalesModel> getSales() {
        return sales;
    }

    public void setSales(List<SalesModel> sales) {
        this.sales = sales;
    }*/

    @PrePersist
    public void setInitialCash() {
        if (getCurrentCash() == null) {
            setCurrentCash(BigDecimal.ZERO);
        }
    }
}
