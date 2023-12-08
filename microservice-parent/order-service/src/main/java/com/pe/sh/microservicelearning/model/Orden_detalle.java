package com.pe.sh.microservicelearning.model;

import com.pe.sh.microservicelearning.configuration.StringKeyGenerator;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 *
 * @author shmen
 */
@Entity
@Table(name = "ORDEN_DETALLE")
public class Orden_detalle {
    
    @Id
    @Column(name = "codigoordet")
    @GeneratedValue(generator = "inc_seqOdt")
    @GenericGenerator(name = "inc_seqOdt", type = StringKeyGenerator.class,
            parameters = {@Parameter(name = "sqcName", value = "ORDEN_DETALLE_SEQ"),
                          @Parameter(name = "identificator_id", value = "ODT")})
    @SequenceGenerator(name = "inc_seqOdt", sequenceName = "ORDEN_DETALLE_SEQ", initialValue = 1, allocationSize = 1)
    private String id;
    
    @Column(name = "skuCode")
    private String skuCode;
    
    @Column(name = "precio")
    private BigDecimal precio;
    
    @Column(name = "cantidad")
    private Integer cantidad;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "codigood", nullable = false)
    private Orden orden;

    public Orden_detalle() {
    }

    public Orden_detalle(String id, String skuCode, BigDecimal precio, Integer cantidad, Orden orden) {
        this.id = id;
        this.skuCode = skuCode;
        this.precio = precio;
        this.cantidad = cantidad;
        this.orden = orden;
    }

    public String getCodigoordet() {
        return id;
    }

    public void setCodigoordet(String id) {
        this.id = id;
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

    public Orden getOrden() {
        return orden;
    }

    public void setOrden(Orden orden) {
        this.orden = orden;
    }
    
    
}
