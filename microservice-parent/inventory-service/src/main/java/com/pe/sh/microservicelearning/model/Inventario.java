package com.pe.sh.microservicelearning.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 *
 * @author shmen
 */
@Entity
@Table(name = "INVENTARIO")
public class Inventario {
    
    @Id
    @Column(name = "codigoinv")
    private String id;
    
    @Column(name = "skucode")
    private String skuCode;
    
    @Column(name = "cantidad")
    private String cantidad;

    public Inventario() {
    }

    public Inventario(String id, String skuCode, String cantidad) {
        this.id = id;
        this.skuCode = skuCode;
        this.cantidad = cantidad;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSkuCode() {
        return skuCode;
    }

    public void setSkuCode(String skuCode) {
        this.skuCode = skuCode;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }
    
}
