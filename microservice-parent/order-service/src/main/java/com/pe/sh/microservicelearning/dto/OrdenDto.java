package com.pe.sh.microservicelearning.dto;

/**
 *
 * @author shmen
 */
public class OrdenDto {
    
    private String codigood;
    private String num_orden;

    public OrdenDto() {
    }

    public OrdenDto(String codigood, String num_orden) {
        this.codigood = codigood;
        this.num_orden = num_orden;
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

    
    
    
    
}
