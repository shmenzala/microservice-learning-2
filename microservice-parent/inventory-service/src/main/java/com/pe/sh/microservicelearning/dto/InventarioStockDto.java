package com.pe.sh.microservicelearning.dto;

/**
 *
 * @author shmen
 */
public class InventarioStockDto {
    
    private String skuCode;
    private boolean isInStock;

    public InventarioStockDto() {
    }

    public InventarioStockDto(String skuCode, boolean isInStock) {
        this.skuCode = skuCode;
        this.isInStock = isInStock;
    }

    public String getSkuCode() {
        return skuCode;
    }

    public void setSkuCode(String skuCode) {
        this.skuCode = skuCode;
    }

    public boolean isIsInStock() {
        return isInStock;
    }

    public void setIsInStock(boolean isInStock) {
        this.isInStock = isInStock;
    }
    
    
    
}
