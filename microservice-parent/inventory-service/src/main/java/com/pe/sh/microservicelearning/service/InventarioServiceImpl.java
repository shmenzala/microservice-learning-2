package com.pe.sh.microservicelearning.service;

import com.pe.sh.microservicelearning.dto.InventarioDto;
import com.pe.sh.microservicelearning.model.Inventario;
import com.pe.sh.microservicelearning.repository.InventarioRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

/**
 *
 * @author shmen
 */
@Service
public class InventarioServiceImpl implements InventarioService{

    private final InventarioRepository inventarioRepository;

    private final ModelMapper modelMapper;

    public InventarioServiceImpl(InventarioRepository inventarioRepository, ModelMapper modelMapper) {
        this.inventarioRepository = inventarioRepository;
        this.modelMapper = modelMapper;
    }
    
    @Override
    public InventarioDto create(InventarioDto dto) {
        Inventario inventario = toEntity(dto);
        Inventario nuevoInventario = inventarioRepository.save(inventario);
    
        return toDto(nuevoInventario);
    }

    @Override
    public List<InventarioDto> findAll() {
        List<Inventario> inventario = inventarioRepository.findAll();
        
        return inventario.stream().map(inv -> toDto(inv)).collect(Collectors.toList());
    }

    @Override
    public InventarioDto findById(String id) {
        Inventario inventario = inventarioRepository.findById(id).
                orElseThrow(null);
        
        return toDto(inventario);
    }

    @Override
    public InventarioDto update(InventarioDto dto, String id) {
        Inventario inventario = inventarioRepository.findById(id).
                orElseThrow(null);
        
        inventario.setSkuCode(dto.getSkuCode());
        inventario.setCantidad(dto.getCantidad());
        
        Inventario actualizaInventario = inventarioRepository.save(inventario);
        
        return toDto(actualizaInventario);        
    }

    @Override
    public void delete(String id) {
        Inventario inventario = inventarioRepository.findById(id).
                orElseThrow(null);
        inventarioRepository.delete(inventario);
    }
    
    //Configuracion de ModelMapper
    protected Inventario toEntity(InventarioDto inventarioDto) {
        Inventario entity = modelMapper.map(inventarioDto, Inventario.class);
        return entity;
    }

    protected InventarioDto toDto(Inventario inventario) {
        InventarioDto dto = modelMapper.map(inventario, InventarioDto.class);
        return dto;
    }
    
}
