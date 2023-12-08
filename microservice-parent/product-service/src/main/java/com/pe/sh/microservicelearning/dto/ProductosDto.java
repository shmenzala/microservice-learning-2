package com.pe.sh.microservicelearning.dto;

import java.math.BigDecimal;

/**
 *
 * @author shmen
 */
public class ProductosDto {
    
    private String id;
    private String nombre;
    private String descripcion;
    private BigDecimal precio;

    public ProductosDto() {
    }

    public ProductosDto(String id, String nombre, String descripcion, BigDecimal precio) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    
}
