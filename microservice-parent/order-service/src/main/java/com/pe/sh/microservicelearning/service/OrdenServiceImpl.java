package com.pe.sh.microservicelearning.service;

import com.pe.sh.microservicelearning.configuration.Mapper;
import com.pe.sh.microservicelearning.dto.InventarioStockDto;
import com.pe.sh.microservicelearning.dto.OrdenDto;
import com.pe.sh.microservicelearning.dto.OrdenYDetallesDto;
import com.pe.sh.microservicelearning.dto.Orden_detalleDto;
import com.pe.sh.microservicelearning.dto.Orden_detalleResponseDto;
import com.pe.sh.microservicelearning.exceptions.Order_serviceException;
import com.pe.sh.microservicelearning.model.Orden;
import com.pe.sh.microservicelearning.model.Orden_detalle;
import com.pe.sh.microservicelearning.repository.OrdenRepository;
import com.pe.sh.microservicelearning.repository.Orden_detalleRepository;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

/**
 *
 * @author shmen
 */
@Service
public class OrdenServiceImpl extends Mapper<Orden, OrdenDto> implements OrdenService {

    private final OrdenRepository ordenRepository;

    private final Orden_detalleRepository orden_detalleRepository;

    private final WebClient.Builder webClientBuilder;

    public OrdenServiceImpl(OrdenRepository ordenRepository, Orden_detalleRepository orden_detalleRepository, WebClient.Builder webClientBuilder, ModelMapper modelMapper) {
        super(modelMapper);
        this.ordenRepository = ordenRepository;
        this.orden_detalleRepository = orden_detalleRepository;
        this.webClientBuilder = webClientBuilder;
    }

    @Override
    public OrdenDto create(OrdenDto dto) {
        Orden orden = toEntity(dto, Orden.class);

        if (dto.getNum_orden().trim().equals("") || dto.getNum_orden().trim() == null) {
            orden.setNum_orden(UUID.randomUUID().toString());
        }

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

        List<Orden_detalle> orden_detalle = orden_detalleRepository.findAllByOrden(orden);
        Set<Orden_detalleResponseDto> odtro = orden_detalle.stream().map(ordenes_det -> toDtoOrdenDetalle(ordenes_det)).collect(Collectors.toSet());

        OrdenDto ordenDto = new OrdenDto(orden.getCodigood(), orden.getNum_orden(), odtro);

        return ordenDto;
    }

    @Override
    public OrdenDto crearOrdenYDetalles(OrdenYDetallesDto odtdto) {
        //CREAR ORDEN
        OrdenDto dto = odtdto.getDto();
        List<Orden_detalleDto> odto = odtdto.getOdto();
        //VERIFICAR STOCK VÍA SKUCODE
        List<String> skuCodes = odto.stream().map(odtos -> odtos.getSkuCode()).toList();
        //COMUNICACION CON EL MICROSERVICIO INVENTARIO
        InventarioStockDto[] inventarioStockDto = webClientBuilder.build().get()
                .uri("http://inventory-service/api/v1/inventario/stock",
                        uriBuilder -> uriBuilder.queryParam("skucode", skuCodes).build())
                .retrieve()
                .bodyToMono(InventarioStockDto[].class)
                .block();

        Boolean stockResult = Arrays.stream(inventarioStockDto)
                .allMatch(invStock -> invStock.isIsInStock());
        
        if (stockResult) {
            Orden orden = toEntity(dto, Orden.class);

            if (dto.getNum_orden().trim().equals("") || dto.getNum_orden().trim() == null) {
                orden.setNum_orden(UUID.randomUUID().toString());
            }

            Orden nuevaOrden = ordenRepository.save(orden);
            //CREAR ORDEN_DETALLE
            for (int i = 0; i < odto.size(); i++) {
                Orden_detalle orden_detalle = toEntityOrdenDetalle(odto.get(i));
                orden_detalle.setOrden(nuevaOrden);
                orden_detalleRepository.save(orden_detalle);
            }

            //Obtengo todos los detalles de la ultima orden generada
            List<Orden_detalle> orden_detalleArray = orden_detalleRepository.findAllByOrden(nuevaOrden);

            Set<Orden_detalleResponseDto> odtro = orden_detalleArray.stream().map(ordenes_det -> toDtoOrdenDetalle(ordenes_det)).collect(Collectors.toSet());

            OrdenDto ordenDto = new OrdenDto(orden.getCodigood(), orden.getNum_orden(), odtro);

            return ordenDto;
        } else {
            System.out.println("PRODUCTO SIN STOCK, por favor, intentar más tarde.");
            //throw new IllegalArgumentException("PRODUCTO SIN STOCK, por favor, intentar más tarde.");
            throw new Order_serviceException(HttpStatus.BAD_REQUEST, "PRODUCTO SIN STOCK, por favor, intentar más tarde.");
        }

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

    protected Orden_detalle toEntityOrdenDetalle(Orden_detalleDto odetalleDto) {
        Orden_detalle entity = modelMapper.map(odetalleDto, Orden_detalle.class);
        return entity;
    }

    protected Orden_detalleResponseDto toDtoOrdenDetalle(Orden_detalle odetalle) {
        Orden_detalleResponseDto dto = modelMapper.map(odetalle, Orden_detalleResponseDto.class);
        return dto;
    }

}
