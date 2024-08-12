package com.app.valeron.Model;

import android.graphics.Bitmap;

import java.io.Serializable;

/**
 * Created by Ahmet on 27.04.2017.
 */

public class Product implements Serializable {

    private String productId;
    private String productSKU;
    private String productName;
    private String productColor;
    private String productSizeDetail;
    private Double productPrice;
    private String productImgUrl;
    private Bitmap productImage;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductSKU() {
        return productSKU;
    }

    public void setProductSKU(String productSKU) {
        this.productSKU = productSKU;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductColor() {
        return productColor;
    }

    public void setProductColor(String productColor) {
        this.productColor = productColor;
    }

    public String getProductSizeDetail() {
        return productSizeDetail;
    }

    public void setProductSizeDetail(String productSizeDetail) {
        this.productSizeDetail = productSizeDetail;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductImgUrl() {
        return productImgUrl;
    }

    public void setProductImgUrl(String productImgUrl) {
        this.productImgUrl = productImgUrl;
    }

    public Bitmap getProductImage() {
        return productImage;
    }

    public void setProductImage(Bitmap productImage) {
        this.productImage = productImage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        return productId == product.productId;

    }

    @Override
    public int hashCode() {
        int result = productId != null ? productId.hashCode() : 0;
        result = 31 * result + (productSKU != null ? productSKU.hashCode() : 0);
        result = 31 * result + (productName != null ? productName.hashCode() : 0);
        result = 31 * result + (productColor != null ? productColor.hashCode() : 0);
        result = 31 * result + (productSizeDetail != null ? productSizeDetail.hashCode() : 0);
        result = 31 * result + (productPrice != null ? productPrice.hashCode() : 0);
        result = 31 * result + (productImgUrl != null ? productImgUrl.hashCode() : 0);
        result = 31 * result + (productImage != null ? productImage.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productSKU=" + productSKU +
                ", productName='" + productName + '\'' +
                ", productColor='" + productColor + '\'' +
                ", productSizeDetail='" + productSizeDetail + '\'' +
                ", productPrice=" + productPrice +
                ", productImgUrl='" + productImgUrl + '\'' +
                '}';
    }
}
