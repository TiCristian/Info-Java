package com.informatorio.ecommerce.controller;

import com.informatorio.ecommerce.domain.Producto;
import com.informatorio.ecommerce.repository.ProductoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/producto")
public class ProductoController {

    private ProductoRepository productoRepository;

    public ProductoController(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @PostMapping
    public ResponseEntity<?> createProducto(@Valid @RequestBody Producto producto){
        return new ResponseEntity<>(productoRepository.save(producto), HttpStatus.CREATED);
    }
}
