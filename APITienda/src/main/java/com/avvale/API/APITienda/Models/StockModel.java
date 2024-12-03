package com.avvale.API.APITienda.Models;


import jakarta.persistence.*;

@Entity
@Table(name = "Stock")
public class StockModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long Id;

    @ManyToOne
    @JoinColumn( name = "tienda_id", foreignKey = @ForeignKey(name = "stock_shop_FK"), nullable = false)
    private TiendaModel tienda;

    @ManyToOne
    @JoinColumn( name = "producto_id", foreignKey = @ForeignKey(name = "stock_product_FK"), nullable = false)
    private ProductoModel producto;

    @ManyToOne
    @JoinColumn( name = "color_id", foreignKey = @ForeignKey(name = "stock_color_FK"), nullable = false)
    private ColorModel color;

    @Column(nullable = false)
    private Integer Amount;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        this.Id = id;
    }

    public TiendaModel getTienda() {
        return tienda;
    }

    public void setTienda(TiendaModel tienda) {
        this.tienda = tienda;
    }

    public ProductoModel getProducto() {
        return producto;
    }

    public void setProducto(ProductoModel producto) {
        this.producto = producto;
    }

    public ColorModel getColor() {
        return color;
    }

    public void setColor(ColorModel color) {
        this.color = color;
    }

    public Integer getAmount() {
        return Amount;
    }

    public void setAmount(Integer amount) {
        this.Amount = amount;
    }

    @PrePersist
    public void setAmount() {
        if (getAmount() == null) {
            setAmount(10);
        }
    }
}
