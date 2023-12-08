package com.pe.sh.microservicelearning.service;

import com.pe.sh.microservicelearning.configuration.Mapper;
import com.pe.sh.microservicelearning.dto.OrdenDto;
import com.pe.sh.microservicelearning.model.Orden;
import com.pe.sh.microservicelearning.repository.OrdenRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

/**
 *
 * @author shmen
 */
@Service
public class OrdenServiceImpl extends Mapper<Orden, OrdenDto> implements OrdenService{

    private final OrdenRepository ordenRepository;

    public OrdenServiceImpl(OrdenRepository ordenRepository, ModelMapper modelMapper) {
        super(modelMapper);
        this.ordenRepository = ordenRepository;
    }
    
    @Override
    public OrdenDto create(OrdenDto dto) {
        Orden orden = toEntity(dto, Orden.class);
        Orden nuevaOrden = ordenRepository.save(orden);
        
        return toDto(nuevaOrden, OrdenDto.class);
    }

    @Override
    public List<OrdenDto> findAll() {
        List<Orden> orden = ordenRepository.findAll();
        return orden.stream().map(ordenes -> toDto(ordenes, OrdenDto.class)).collect(Collectors.toList());
    }

    @Override
    public OrdenDto findById(String id) {
        Orden orden = ordenRepository.findById(id).
                orElseThrow(null);
        return toDto(orden, OrdenDto.class);
    }

    @Override
    public OrdenDto update(OrdenDto dto, String id) {
        Orden orden = ordenRepository.findById(id).
                orElseThrow(null);
        
        orden.setNum_orden(dto.getNum_orden());
        
        Orden actualizaOrden = ordenRepository.save(orden);
        
        return toDto(actualizaOrden, OrdenDto.class);
    }

    @Override
    public void delete(String id) {
        Orden orden = ordenRepository.findById(id)
                .orElseThrow(null);
        ordenRepository.delete(orden);
    }
    
}
