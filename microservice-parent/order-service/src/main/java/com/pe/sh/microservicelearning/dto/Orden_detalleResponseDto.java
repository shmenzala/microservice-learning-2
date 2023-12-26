/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pe.sh.microservicelearning.dto;

import java.math.BigDecimal;

/**
 *
 * @author shmen
 */
public class Orden_detalleResponseDto {
    
    private String codigoordet;
    private String skuCode;
    private BigDecimal precio;
    private Integer cantidad;

    public Orden_detalleResponseDto() {
    }

    public Orden_detalleResponseDto(String codigoordet, String skuCode, BigDecimal precio, Integer cantidad) {
        this.codigoordet = codigoordet;
        this.skuCode = skuCode;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public String getCodigoordet() {
        return codigoordet;
    }

    public void setCodigoordet(String codigoordet) {
        this.codigoordet = codigoordet;
    }

    public String getSkuCode() {
        return skuCode;
    }

    public void setSkuCode(String skuCode) {
        this.skuCode = skuCode;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
    
}
