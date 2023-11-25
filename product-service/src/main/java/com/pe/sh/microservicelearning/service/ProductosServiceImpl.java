package com.pe.sh.microservicelearning.service;

import com.pe.sh.microservicelearning.dto.ProductosDto;
import com.pe.sh.microservicelearning.model.Productos;
import com.pe.sh.microservicelearning.repository.ProductosRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

/**
 *
 * @author shmen
 */
@Service
public class ProductosServiceImpl implements ProductosService {

    private final ProductosRepository productosRepository;

    private final ModelMapper modelMapper;

    public ProductosServiceImpl(ProductosRepository productosRepository, ModelMapper modelMapper) {
        this.productosRepository = productosRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ProductosDto create(ProductosDto productosDto) {
        Productos productos = toEntity(productosDto);
        Productos nuevoProducto = productosRepository.save(productos);

        return toDto(nuevoProducto);
    }

    @Override
    public List<ProductosDto> findAll() {
        List<Productos> productos = productosRepository.findAll();
        return productos.stream().map(producto -> toDto(producto)).collect(Collectors.toList());
    }

    @Override
    public ProductosDto findById(String id) {
        Productos productos = productosRepository.findById(id).orElseThrow(null);
        return toDto(productos);
    }

    @Override
    public ProductosDto update(ProductosDto productosDto, String id) {
        Productos productos = productosRepository.findById(id)
                .orElseThrow(null);
        
        productos.setNombre(productosDto.getNombre());
        productos.setDescripcion(productosDto.getDescripcion());
        productos.setPrecio(productosDto.getPrecio());
        
        Productos actualizarProducto = productosRepository.save(productos);
        
        return toDto(actualizarProducto);
    }

    @Override
    public void delete(String id) {
        Productos productos = productosRepository.findById(id)
                .orElseThrow(null);
        productosRepository.delete(productos);
    }

    //Configuracion de ModelMapper
    protected Productos toEntity(ProductosDto productosDto) {
        Productos entity = modelMapper.map(productosDto, Productos.class);
        return entity;
    }

    protected ProductosDto toDto(Productos productos) {
        ProductosDto dto = modelMapper.map(productos, ProductosDto.class);
        return dto;
    }

}
