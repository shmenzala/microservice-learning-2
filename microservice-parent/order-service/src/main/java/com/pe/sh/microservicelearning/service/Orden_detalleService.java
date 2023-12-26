package com.pe.sh.microservicelearning.service;

import com.pe.sh.microservicelearning.dto.Orden_detalleDto;
import java.util.List;

/**
 *
 * @author shmen
 */
public interface Orden_detalleService {
    
    public Orden_detalleDto create(Orden_detalleDto dto, String id_orden);
    
    public List<Orden_detalleDto> findAll();
    
    public Orden_detalleDto findById(String id);
    
    public Orden_detalleDto update(Orden_detalleDto dto, String id, String id_orden);
    
    public void delete(String id);
    
    public List<Orden_detalleDto> buscarPorCodigoOrden(String id_orden);
    
}
