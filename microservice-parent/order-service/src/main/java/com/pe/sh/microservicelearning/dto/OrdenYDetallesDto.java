/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pe.sh.microservicelearning.dto;

import java.util.List;

/**
 *
 * @author shmen
 */
public class OrdenYDetallesDto {
    private OrdenDto dto;
    private List<Orden_detalleDto> odto;

    public OrdenYDetallesDto() {
    }

    public OrdenYDetallesDto(OrdenDto dto, List<Orden_detalleDto> odto) {
        this.dto = dto;
        this.odto = odto;
    }

    public OrdenDto getDto() {
        return dto;
    }

    public void setDto(OrdenDto dto) {
        this.dto = dto;
    }

    public List<Orden_detalleDto> getOdto() {
        return odto;
    }

    public void setOdto(List<Orden_detalleDto> odto) {
        this.odto = odto;
    }

    
    
    
}
