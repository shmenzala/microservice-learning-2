package com.pe.sh.microservicelearning.service;

import com.pe.sh.microservicelearning.dto.ProductosDto;
import java.util.List;

/**
 *
 * @author shmen
 */
public interface ProductosService {
    
    public ProductosDto create(ProductosDto productosDto);
    
    public List<ProductosDto> findAll();
    
    public ProductosDto findById(String id);
    
    public ProductosDto update( ProductosDto productosDto, String id);
    
    public void delete(String id);
    
}
