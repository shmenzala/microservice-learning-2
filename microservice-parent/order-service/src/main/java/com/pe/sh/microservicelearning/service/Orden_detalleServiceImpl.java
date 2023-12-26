package com.pe.sh.microservicelearning.service;

import com.pe.sh.microservicelearning.configuration.Mapper;
import com.pe.sh.microservicelearning.dto.Orden_detalleDto;
import com.pe.sh.microservicelearning.model.Orden;
import com.pe.sh.microservicelearning.model.Orden_detalle;
import com.pe.sh.microservicelearning.repository.OrdenRepository;
import com.pe.sh.microservicelearning.repository.Orden_detalleRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

/**
 *
 * @author shmen
 */
@Service
public class Orden_detalleServiceImpl extends Mapper<Orden_detalle, Orden_detalleDto> implements Orden_detalleService {

    private final Orden_detalleRepository orden_detalleRepository;

    private final OrdenRepository ordenRepository;

    public Orden_detalleServiceImpl(Orden_detalleRepository orden_detalleRepository, OrdenRepository ordenRepository, ModelMapper modelMapper) {
        super(modelMapper);
        this.orden_detalleRepository = orden_detalleRepository;
        this.ordenRepository = ordenRepository;
    }

    @Override
    public Orden_detalleDto create(Orden_detalleDto dto, String id_orden) {
        Orden_detalle orden_detalle = toEntity(dto, Orden_detalle.class);

        Orden orden = ordenRepository.findById(id_orden)
                .orElseThrow(null);

        orden_detalle.setSkuCode(dto.getSkuCode());
        orden_detalle.setPrecio(dto.getPrecio());
        orden_detalle.setCantidad(dto.getCantidad());
        orden_detalle.setOrden(orden);

        Orden_detalle nuevaOrden_detalle = orden_detalleRepository.save(orden_detalle);

        return toDto(nuevaOrden_detalle, Orden_detalleDto.class);
    }

    @Override
    public List<Orden_detalleDto> findAll() {
        List<Orden_detalle> orden_detalle = orden_detalleRepository.findAll();
        return orden_detalle.stream().map(ordenes_det -> toDto(ordenes_det, Orden_detalleDto.class)).collect(Collectors.toList());
    }

    @Override
    public Orden_detalleDto findById(String id) {
        Orden_detalle orden_detalle = orden_detalleRepository.findById(id).
                orElseThrow(null);
        return toDto(orden_detalle, Orden_detalleDto.class);
    }

    @Override
    public Orden_detalleDto update(Orden_detalleDto dto, String id, String id_orden) {
        Orden_detalle orden_detalle = orden_detalleRepository.findById(id).
                orElseThrow(null);

        Orden orden = ordenRepository.findById(id_orden)
                .orElseThrow(null);

        orden_detalle.setSkuCode(dto.getSkuCode());
        orden_detalle.setPrecio(dto.getPrecio());
        orden_detalle.setCantidad(dto.getCantidad());
        orden_detalle.setOrden(orden);

        Orden_detalle actualizaOrden_detalle = orden_detalleRepository.save(orden_detalle);

        return toDto(actualizaOrden_detalle, Orden_detalleDto.class);
    }

    @Override
    public void delete(String id) {
        Orden_detalle orden_detalle = orden_detalleRepository.findById(id).
                orElseThrow(null);
        orden_detalleRepository.delete(orden_detalle);
    }

    @Override
    public List<Orden_detalleDto> buscarPorCodigoOrden(String id_orden) {
        Orden orden = ordenRepository.findById(id_orden)
                .orElseThrow(null);
        
        List<Orden_detalle> orden_detalle = orden_detalleRepository.findAllByOrden(orden);
        
        //return toDto(orden_detalle, Orden_detalleDto.class);
        return orden_detalle.stream().map(ordenes_det -> toDto(ordenes_det, Orden_detalleDto.class)).collect(Collectors.toList());
    }

}
