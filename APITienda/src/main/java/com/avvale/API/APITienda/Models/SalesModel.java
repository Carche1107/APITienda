package com.avvale.API.APITienda.Models;


import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "Ventas")
public class SalesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long Id;

    @ManyToOne
    @JoinColumn( name = "id_shop", foreignKey = @ForeignKey(name = "Ventas_shop_FK"), nullable = false)
    private TiendaModel IdShop;

    @ManyToOne
    @JoinColumn( name = "id_product", foreignKey = @ForeignKey(name = "Ventas_product_FK"), nullable = false)
    private ProductoModel IdProduct;

    @ManyToOne
    @JoinColumn( name = "id_color", foreignKey = @ForeignKey(name = "Ventas_product_FK"), nullable = false)
    private ColorModel IdColor;

    @Column(nullable = false)
    private LocalDateTime Time;

    @Column(nullable = false)
    private Integer TotalProducts;

    @Column(nullable = false)
    private BigDecimal InitialPrice;

    @Column(nullable = false)
    private double IncrementApplied;

    @Column(nullable = false)
    private double DiscountApplied;

    @Column(nullable = false)
    private BigDecimal TotalPrice;

    @Column(nullable = false)
    private Boolean Returned;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        this.Id = id;
    }

    public TiendaModel getIdShop() {
        return IdShop;
    }

    public void setIdShop(TiendaModel idShop) {
        this.IdShop = idShop;
    }

    public ProductoModel getIdProduct() {
        return IdProduct;
    }

    public void setIdProduct(ProductoModel idProduct) {
        this.IdProduct = idProduct;
    }

    public ColorModel getIdColor() {
        return IdColor;
    }

    public void setIdColor(ColorModel idColor) {
        this.IdColor = idColor;
    }

    public LocalDateTime getTime() {
        return Time;
    }

    public void setTime(LocalDateTime time) {
        this.Time = time;
    }

    public Integer getTotalProducts() {
        return TotalProducts;
    }

    public void setTotalProducts(Integer totalProducts) {
        this.TotalProducts = totalProducts;
    }

    public BigDecimal getInitialPrice() {
        return InitialPrice;
    }

    public void setInitialPrice(BigDecimal initialPrice) {
        this.InitialPrice = initialPrice;
    }

    public Double getIncrementApplied() {
        return IncrementApplied;
    }

    public void setIncrementApplied(Double incrementApplied) {
        this.IncrementApplied = incrementApplied;
    }

    public Double getDiscountApplied() {
        return DiscountApplied;
    }

    public void setDiscountApplied(Double discountApplied) {
        this.DiscountApplied = discountApplied;
    }

    public BigDecimal getTotalPrice() {
        return TotalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.TotalPrice = totalPrice;
    }

    public Boolean getReturned() {
        return Returned;
    }

    public void setReturned(Boolean returned) {
        Returned = returned;
    }
}
