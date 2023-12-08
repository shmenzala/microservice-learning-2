package com.pe.sh.microservicelearning.controller;

import com.pe.sh.microservicelearning.dto.InventarioDto;
import com.pe.sh.microservicelearning.service.InventarioService;
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
@RequestMapping("/api/v1/inventario")
public class InventarioController {
    
    public final InventarioService inventarioService;

    public InventarioController(InventarioService inventarioService) {
        this.inventarioService = inventarioService;
    }

    @PostMapping
    public ResponseEntity<InventarioDto> crearInventario(
            @RequestBody InventarioDto invDto) {
        return new ResponseEntity(inventarioService.create(invDto), HttpStatus.OK);
    }

    @GetMapping
    public List<InventarioDto> listarInventarios() {
        return inventarioService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<InventarioDto> buscarInventarioPorId(
            @PathVariable(value = "id") String id) {
        return ResponseEntity.ok(inventarioService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<InventarioDto> actualizarInventario(
            @RequestBody InventarioDto invDto,
            @PathVariable(value = "id") String id) {
        return new ResponseEntity<>(inventarioService.update(invDto, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarInventario(
            @PathVariable(value = "id") String id) {
        inventarioService.delete(id);
        return new ResponseEntity<>("Inventario eliminado con éxito", HttpStatus.OK);
    }
    
}
