package com.pe.sh.microservicelearning.model;

import java.math.BigDecimal;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 *
 * @author shmen
 */
@Document(collection = "productos")
public class Productos {
   
    @Id
    private String id;
    
    @Field(name = "NOMBRE")
    private String nombre;
    
    @Field(name = "DESCRIPCION")
    private String descripcion;
    
    @Field(name = "PRECIO")
    private BigDecimal precio;

    public Productos() {
    }

    public Productos(String id, String nombre, String descripcion, BigDecimal precio) {
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
