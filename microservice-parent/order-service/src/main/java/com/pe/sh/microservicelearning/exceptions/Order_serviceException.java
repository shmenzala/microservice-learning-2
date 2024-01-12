/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pe.sh.microservicelearning.exceptions;

import org.springframework.http.HttpStatus;

/**
 *
 * @author shmen
 */
public class Order_serviceException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private HttpStatus estado;
    private String mensaje;

    public Order_serviceException() {
    }

    public Order_serviceException(HttpStatus estado, String mensaje) {
        super(mensaje);
        this.estado = estado;
        this.mensaje = mensaje;
    }

    public HttpStatus getEstado() {
        return estado;
    }

    public void setEstado(HttpStatus estado) {
        this.estado = estado;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
}
