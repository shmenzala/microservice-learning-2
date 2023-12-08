package com.pe.sh.microservicelearning.controller;

import com.pe.sh.microservicelearning.dto.ProductosDto;
import com.pe.sh.microservicelearning.service.ProductosService;
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
@RequestMapping("/api/v1/productos")
public class ProductosController {

    public final ProductosService productosService;

    public ProductosController(ProductosService productosService) {
        this.productosService = productosService;
    }

    @PostMapping
    public ResponseEntity<ProductosDto> crearProducto(
            @RequestBody ProductosDto proDto) {
        return new ResponseEntity(productosService.create(proDto), HttpStatus.OK);
    }

    @GetMapping
    public List<ProductosDto> listarProductos() {
        return productosService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductosDto> buscarProductoPorId(
            @PathVariable(value = "id") String id) {
        return ResponseEntity.ok(productosService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductosDto> actualizarProducto(
            @RequestBody ProductosDto proDto,
            @PathVariable(value = "id") String id) {
        return new ResponseEntity<>(productosService.update(proDto, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarProducto(
            @PathVariable(value = "id") String id) {
        productosService.delete(id);
        return new ResponseEntity<>("Producto eliminado con éxito", HttpStatus.OK);
    }

}
