package com.avvale.API.APITienda.Models;

import com.avvale.API.APITienda.Enums.DayType;
import com.avvale.API.APITienda.Enums.IncrementType;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table( name = "Discounts")
public class DiscountModel {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column(unique = true, nullable = false)
    private Long Id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private DayType dayType;

    private Integer InitialHour;

    private Integer FinalHour;

    @Column(nullable = false)
    private double Discount;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private IncrementType Increment_Type;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        this.Id = id;
    }

    public DayType getDayType() {
        return dayType;
    }

    public void setDayType(DayType dayType) {
        this.dayType = dayType;
    }

    public Integer getInitialHour() {
        return InitialHour;
    }

    public void setInitialHour(Integer initialHour) {
        this.InitialHour = initialHour;
    }

    public Integer getFinalHour() {
        return FinalHour;
    }

    public void setFinalHour(Integer finalHour) {
        this.FinalHour = finalHour;
    }

    public double getDiscount() {
        return Discount;
    }

    public void setDiscount(double discount) {
        this.Discount = discount;
    }

    public IncrementType getIncrement_Type() {
        return Increment_Type;
    }

    public void setIncrement_Type(IncrementType increment_Type) {
        this.Increment_Type = increment_Type;
    }
}
