package com.avvale.API.APITienda.Models;


import jakarta.persistence.*;

@Entity
@Table(name = "Returns")
public class ReturnsModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long Id;

    @ManyToOne
    @JoinColumn( name = "sale_id", foreignKey = @ForeignKey(name = "returns_Ventas_FK"), nullable = false)
    private SalesModel sale_id;

    @Column(unique = true, nullable = false)
    private Integer products_left;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public SalesModel getSale() {
        return sale_id;
    }

    public void setSale(SalesModel sale) {
        this.sale_id = sale;
    }

    public Integer getProductsLeft() {
        return products_left;
    }

    public void setProductsLeft(Integer productsLeft) {
        products_left = productsLeft;
    }
}
