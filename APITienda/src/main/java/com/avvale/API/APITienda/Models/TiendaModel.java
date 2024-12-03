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

    @PrePersist
    public void setInitialCash() {
        if (getCurrentCash() == null) {
            setCurrentCash(BigDecimal.ZERO);
        }
    }
}
