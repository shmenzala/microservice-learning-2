package com.pe.sh.microservicelearning.model;

import com.pe.sh.microservicelearning.configuration.StringKeyGenerator;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 *
 * @author shmen
 */
@Entity
@Table(name = "INVENTARIO")
public class Inventario {
    
    @Id
    @Column(name = "codigoinv")
    @GeneratedValue(generator = "inc_seqInv")
    @GenericGenerator(name = "inc_seqInv", type = StringKeyGenerator.class,
            parameters = {@Parameter(name = "sqcName", value = "INVENTARIO_SEQ"),
                          @Parameter(name = "identificator_id", value = "IV")})
    @SequenceGenerator(name = "inc_seqInv", sequenceName = "INVENTARIO_SEQ", initialValue = 1, allocationSize = 1)
    private String id;
    
    @Column(name = "skucode")
    private String skuCode;
    
    @Column(name = "cantidad")
    private Integer cantidad;

    public Inventario() {
    }

    public Inventario(String id, String skuCode, Integer cantidad) {
        this.id = id;
        this.skuCode = skuCode;
        this.cantidad = cantidad;
    }

    public String getCodigoinv() {
        return id;
    }

    public void setCodigoinv(String id) {
        this.id = id;
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
