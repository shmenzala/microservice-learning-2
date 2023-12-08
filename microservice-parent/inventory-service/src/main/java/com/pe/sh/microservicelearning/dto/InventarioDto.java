package com.pe.sh.microservicelearning.dto;

/**
 *
 * @author shmen
 */
public class InventarioDto {
    
    private String codigoinv;
    private String skuCode;
    private Integer cantidad;

    public InventarioDto() {
    }

    public InventarioDto(String codigoinv, String skuCode, Integer cantidad) {
        this.codigoinv = codigoinv;
        this.skuCode = skuCode;
        this.cantidad = cantidad;
    }

    public String getCodigoinv() {
        return codigoinv;
    }

    public void setCodigoinv(String codigoinv) {
        this.codigoinv = codigoinv;
    }

    public String getSkuCode() {
        return skuCode;
    }

    public void setSkuCode(String skuCode) {
        this.skuCode = skuCode;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    
    
    
    
}
