package com.pe.sh.microservicelearning.dto;

import java.util.Set;

/**
 *
 * @author shmen
 */
public class OrdenDto {
    
    private String codigood;
    private String num_orden;
    private Set<Orden_detalleResponseDto> orden_Detalle;

    public OrdenDto() {
    }

    public OrdenDto(String codigood, String num_orden, Set<Orden_detalleResponseDto> orden_Detalle) {
        this.codigood = codigood;
        this.num_orden = num_orden;
        this.orden_Detalle = orden_Detalle;
    }

    public String getCodigood() {
        return codigood;
    }

    public void setCodigood(String codigood) {
        this.codigood = codigood;
    }

    public String getNum_orden() {
        return num_orden;
    }

    public void setNum_orden(String num_orden) {
        this.num_orden = num_orden;
    }

    public Set<Orden_detalleResponseDto> getOrden_Detalle() {
        return orden_Detalle;
    }

}
