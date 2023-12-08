package com.pe.sh.microservicelearning.service;

import com.pe.sh.microservicelearning.dto.OrdenDto;
import java.util.List;

/**
 *
 * @author shmen
 */
public interface OrdenService {
    
    public OrdenDto create(OrdenDto dto);
    
    public List<OrdenDto> findAll();
    
    public OrdenDto findById(String id);
    
    public OrdenDto update(OrdenDto dto, String id);
    
    public void delete(String id);
    
}
