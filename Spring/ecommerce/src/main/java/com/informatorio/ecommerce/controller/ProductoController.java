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

    private final ProductoRepository productoRepository;

    public ProductoController(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @GetMapping
    public ResponseEntity<?> searchProductos(@RequestParam(name = "nombre", required = false) String nombre,
                                             @RequestParam(name = "publicado", required = false) String publicado){
        if (nombre != null) {
            return new ResponseEntity<>(productoRepository.findByNombreContaining(nombre), HttpStatus.OK);
        }
        else if (publicado != null) {
            return new ResponseEntity<>(productoRepository.findByPublicadoContaining(publicado), HttpStatus.OK);
        }
        return new ResponseEntity<>(productoRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createProducto(@Valid @RequestBody Producto producto){
        return new ResponseEntity<>(productoRepository.save(producto), HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}/")
    public Producto modifyProducto(@PathVariable("id") Long id, @RequestBody Producto producto){
        Producto productoModificado = productoRepository.getById(id);
        productoModificado.setNombre(producto.getNombre());
        productoModificado.setDescripcion(producto.getDescripcion());
        productoModificado.setContenido(producto.getContenido());
        productoModificado.setPublicado(producto.getPublicado());
        return productoRepository.save(productoModificado);
    }

    @DeleteMapping("/{id}/")
        public void deleteProducto(@PathVariable("id") Long id) {
        Producto producto = productoRepository.getById(id);
        productoRepository.delete(producto);
    }
}