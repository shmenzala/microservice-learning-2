package com.pe.sh.notificationservice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author shmen
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderPlacedEvent {
    private String num_orden;
}
