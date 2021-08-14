package com.informatorio.ecommerce.controller;

import com.informatorio.ecommerce.dto.OperacionCarrito;
import com.informatorio.ecommerce.domain.Carrito;
import com.informatorio.ecommerce.domain.LineaDeCarrito;
import com.informatorio.ecommerce.domain.Producto;
import com.informatorio.ecommerce.domain.Usuario;
import com.informatorio.ecommerce.repository.CarritoRepository;
import com.informatorio.ecommerce.repository.ProductoRepository;
import com.informatorio.ecommerce.repository.UsuarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
@RequestMapping("/carrito")
public class CarritoController {

    private final UsuarioRepository usuarioRepository;
    private final CarritoRepository carritoRepository;
    private final ProductoRepository productoRepository;

    public CarritoController(UsuarioRepository usuarioRepository, CarritoRepository carritoRepository,
                             ProductoRepository productoRepository) {
        this.usuarioRepository = usuarioRepository;
        this.carritoRepository = carritoRepository;
        this.productoRepository = productoRepository;
    }

    @PostMapping("/{id}/usuario")
    public ResponseEntity<?> createCarrito(@PathVariable("id") Long userId,
                                           @Valid @RequestBody Carrito carrito){
        Usuario usuario = usuarioRepository.getById(userId);
        carrito.setUsuario(usuario);
        return new ResponseEntity<>(carritoRepository.save(carrito), HttpStatus.CREATED);
    }
    @PutMapping("/{id}/usuario/{idCarrito}")
    public ResponseEntity<?> agregarProducto(@PathVariable("id") Long userId,
                                             @PathVariable("idCarrito") Long idCarrito,
                                             @Valid @RequestBody OperacionCarrito operacionCarrito){
        Carrito carrito = carritoRepository.getById(idCarrito);
        Producto producto = productoRepository.getById(operacionCarrito.getProductoId());
        LineaDeCarrito lineaDeCarrito = new LineaDeCarrito();
        lineaDeCarrito.setCarrito(carrito);
        lineaDeCarrito.setProducto(producto);
        lineaDeCarrito.setCantidad(operacionCarrito.getCantidad());
        carrito.agregarLineDeCarrito(lineaDeCarrito);
        return new ResponseEntity<>(carritoRepository.save(carrito), HttpStatus.CREATED);
    }
    @DeleteMapping("/{idCarrito}/usuario/{id}/linea/{idLinea}}")
    public ResponseEntity<?> borrarProducto(@PathVariable("id") Long userId,
                                            @PathVariable("idCarrito") Long idCarrito,
                                            @Valid @RequestBody OperacionCarrito operacionCarrito)
    {return null;}
}

