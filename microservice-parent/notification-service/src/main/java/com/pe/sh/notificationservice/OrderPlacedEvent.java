package com.pe.sh.notificationservice;

/**
 *
 * @author shmen
 */
public class OrderPlacedEvent {

    private String num_orden;

    public OrderPlacedEvent() {
    }

    public OrderPlacedEvent(String num_orden) {
        this.num_orden = num_orden;
    }

    public String getNum_orden() {
        return num_orden;
    }

    public void setNum_orden(String num_orden) {
        this.num_orden = num_orden;
    }
}
