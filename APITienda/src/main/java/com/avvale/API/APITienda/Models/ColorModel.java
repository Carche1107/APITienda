package com.avvale.API.APITienda.Models;


import com.avvale.API.APITienda.Enums.IncrementType;
import jakarta.persistence.*;

@Entity
@Table(name = "Color")
public class ColorModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long Id;

    @Column(nullable = false)
    private String Color;

    @Column(nullable = false)
    private double Increment;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private IncrementType Increment_Type;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        this.Id = id;
    }

    public double getIncrement() {
        return Increment;
    }

    public void setIncrement(double increment) {
        this.Increment = increment;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        this.Color = color;
    }

    /*public List<StockModel> getStocks() {
        return stocks;
    }

    public void setStocks(List<StockModel> stocks) {
        this.stocks = stocks;
    }*/

    public IncrementType getIncrement_Type() {
        return Increment_Type;
    }

    public void setIncrement_Type(IncrementType increment_Type) {
        Increment_Type = increment_Type;
    }

    /*public List<StockModel> getSales() {
        return sales;
    }

    public void setSales(List<StockModel> sales) {
        this.sales = sales;
    }*/
}
