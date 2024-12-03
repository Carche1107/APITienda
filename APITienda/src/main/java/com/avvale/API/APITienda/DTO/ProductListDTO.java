package com.avvale.API.APITienda.DTO;

public class ProductListDTO {

    private Long idProduct;
    private String productName;

    public ProductListDTO(Long idProduct, String productName) {
        this.idProduct = idProduct;
        this.productName = productName;

    }

    public Long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Long idProduct) {
        this.idProduct = idProduct;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
