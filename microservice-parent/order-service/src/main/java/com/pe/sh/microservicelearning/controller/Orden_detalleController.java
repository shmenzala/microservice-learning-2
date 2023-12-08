package com.pe.sh.microservicelearning.controller;

import com.pe.sh.microservicelearning.dto.OrdenDto;
import com.pe.sh.microservicelearning.dto.Orden_detalleDto;
import com.pe.sh.microservicelearning.service.Orden_detalleService;
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
@RequestMapping("/api/v1/ordendt")
public class Orden_detalleController {
    
    private final Orden_detalleService orden_detalleService;

    public Orden_detalleController(Orden_detalleService orden_detalleService) {
        this.orden_detalleService = orden_detalleService;
    }
    
    @PostMapping("/{id_orden}")
    public ResponseEntity<Orden_detalleDto> crearOrden_detalle(
            @RequestBody Orden_detalleDto dto,
            @PathVariable(value = "id_orden") String id_orden) {
        return new ResponseEntity<>(orden_detalleService.create(dto, id_orden), HttpStatus.OK);
    }

    @GetMapping
    public List<Orden_detalleDto> listarOrdenes_detalle() {
        return orden_detalleService.findAll();
    }

    @GetMapping("/{codigoordet}")
    public ResponseEntity<Orden_detalleDto> buscarOrdenes_detallePorId(
            @PathVariable(value = "codigoordet") String codigoordet) {
        return ResponseEntity.ok(orden_detalleService.findById(codigoordet));
    }

    @PutMapping("/{codigoordet}/{id_orden}")
    public ResponseEntity<Orden_detalleDto> actualizarOrden_detalle(
            @RequestBody Orden_detalleDto dto,
            @PathVariable(value = "codigoordet") String codigoordet,
            @PathVariable(value = "id_orden") String id_orden) {
        return ResponseEntity.ok(orden_detalleService.update(dto, codigoordet, id_orden));
    }

    @DeleteMapping
    public ResponseEntity<String> eliminarOrden_detalle(
    @PathVariable(value = "codigoordet") String codigoordet){
        orden_detalleService.delete(codigoordet);
        return ResponseEntity.ok("Orden eliminada con éxito.");
    }
    
}
