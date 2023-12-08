package com.pe.sh.microservicelearning.dto;

import com.pe.sh.microservicelearning.model.Orden;
import java.math.BigDecimal;

/**
 *
 * @author shmen
 */
public class Orden_detalleDto {
    
    private String codigoordet;
    private String skuCode;
    private BigDecimal precio;
    private Integer cantidad;
    private OrdenDto orden;

    public Orden_detalleDto() {
    }

    public Orden_detalleDto(String codigoordet, String skuCode, BigDecimal precio, Integer cantidad, OrdenDto orden) {
        this.codigoordet = codigoordet;
        this.skuCode = skuCode;
        this.precio = precio;
        this.cantidad = cantidad;
        this.orden = orden;
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

    public OrdenDto getOrden() {
        return orden;
    }

    public void setOrden(OrdenDto orden) {
        this.orden = orden;
    }

    
    
    
    
}
