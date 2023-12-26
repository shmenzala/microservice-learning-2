package com.pe.sh.microservicelearning.controller;

import com.pe.sh.microservicelearning.dto.OrdenDto;
import com.pe.sh.microservicelearning.dto.OrdenYDetallesDto;
import com.pe.sh.microservicelearning.dto.Orden_detalleDto;
import com.pe.sh.microservicelearning.service.OrdenService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author shmen
 */
@RestController
@RequestMapping("/api/v1/orden")
public class OrdenController {

    private final OrdenService ordenService;

    public OrdenController(OrdenService ordenService) {
        this.ordenService = ordenService;
    }

    @PostMapping
    public ResponseEntity<OrdenDto> crearOrden(
            @RequestBody OrdenDto dto) {
        return new ResponseEntity<>(ordenService.create(dto), HttpStatus.OK);
    }

    @GetMapping
    public List<OrdenDto> listarOrdenes() {
        return ordenService.findAll();
    }

    @GetMapping("/{codigood}")
    public ResponseEntity<OrdenDto> buscarOrdenesPorId(
            @PathVariable(value = "codigood") String codigood) {
        return ResponseEntity.ok(ordenService.findById(codigood));
    }

    @PutMapping("/{codigood}")
    public ResponseEntity<OrdenDto> actualizarOrden(
            @RequestBody OrdenDto dto,
            @PathVariable(value = "codigood") String codigood) {
        return ResponseEntity.ok(ordenService.update(dto, codigood));
    }

    @DeleteMapping
    public ResponseEntity<String> eliminarOrden(
    @PathVariable(value = "codigood") String codigood){
        ordenService.delete(codigood);
        return ResponseEntity.ok("Orden eliminada con éxito.");
    }
    
    @PostMapping("/orderAndDetails")
    public ResponseEntity<OrdenDto> crearOrdenYDetalles(
            @RequestBody OrdenYDetallesDto odtdto) {
        return new ResponseEntity<>(ordenService.crearOrdenYDetalles(odtdto), HttpStatus.OK);
    }
    
}
