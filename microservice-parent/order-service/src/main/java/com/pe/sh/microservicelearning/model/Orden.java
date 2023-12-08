package com.pe.sh.microservicelearning.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.pe.sh.microservicelearning.configuration.StringKeyGenerator;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.util.HashSet;
import java.util.Set;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 *
 * @author shmen
 */
@Entity
@Table(name = "ORDEN")
public class Orden {
    
    @Id
    @Column(name = "codigood")
    @GeneratedValue(generator = "inc_seqOrd")
    @GenericGenerator(name = "inc_seqOrd", type = StringKeyGenerator.class,
            parameters = {@Parameter(name = "sqcName", value = "ORDEN_SEQ"),
                          @Parameter(name = "identificator_id", value = "OD")})
    @SequenceGenerator(name = "inc_seqOrd", sequenceName = "ORDEN_SEQ", initialValue = 1, allocationSize = 1)
    private String id;
    
    @Column(name = "num_orden")
    private String num_orden;

    @JsonBackReference
    @OneToMany(mappedBy = "orden", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Orden_detalle> orden_Detalle = new HashSet<>();

    public Orden() {
    }

    public Orden(String id, String num_orden) {
        this.id = id;
        this.num_orden = num_orden;
    }

    public String getCodigood() {
        return id;
    }

    public void setCodigood(String id) {
        this.id = id;
    }

    public String getNum_orden() {
        return num_orden;
    }

    public void setNum_orden(String num_orden) {
        this.num_orden = num_orden;
    }

    public Set<Orden_detalle> getOrden_Detalle() {
        return orden_Detalle;
    }

    public void setOrden_Detalle(Set<Orden_detalle> orden_Detalle) {
        this.orden_Detalle = orden_Detalle;
    }
    
    
    
    
}
