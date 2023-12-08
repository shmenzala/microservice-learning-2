package com.pe.sh.microservicelearning.service;

import com.pe.sh.microservicelearning.dto.InventarioDto;
import java.util.List;

/**
 *
 * @author shmen
 */
public interface InventarioService {
    
    public InventarioDto create(InventarioDto dto);
    
    public List<InventarioDto> findAll();
    
    public InventarioDto findById(String id);
    
    public InventarioDto update(InventarioDto dto, String id);
    
    public void delete(String id);
    
}
