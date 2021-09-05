package com.informatorio.ecommerce.controller;

import com.informatorio.ecommerce.domain.Carrito;
import com.informatorio.ecommerce.domain.Producto;
import com.informatorio.ecommerce.domain.Usuario;
import com.informatorio.ecommerce.repository.CarritoRepository;
import com.informatorio.ecommerce.repository.ProductoRepository;
import com.informatorio.ecommerce.repository.UsuarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.math.BigDecimal;


@RestController
public class CarritoController{

    private final CarritoRepository carritoRepository;
    private final UsuarioRepository usuarioRepository;
    private final ProductoRepository productoRepository;

    public CarritoController(CarritoRepository carritoRepository,
                             UsuarioRepository usuarioRepository,
                             ProductoRepository productoRepository) {
        this.carritoRepository = carritoRepository;
        this.productoRepository = productoRepository;
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping("/carrito")
    public ResponseEntity<?> searchCarritos(@RequestParam(value = "activo",required = false) Boolean activo,
                                            @RequestParam(value = "id",required = false) Long id){
        if(activo != null) {
            return new ResponseEntity<>(carritoRepository.findByActivoTrue(), HttpStatus.OK);
            }
        else if (id != null){
            return new ResponseEntity<>(carritoRepository.findById(id), HttpStatus.OK);
            }
        return new ResponseEntity<>(carritoRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping("/usuario/{userId}/producto/{productId}/")
    public ResponseEntity<?> createCarrito(@PathVariable("userId") Long userId, @PathVariable("productId") Long productId,
                                           @Valid @RequestBody Carrito carrito){
        Usuario usuario = usuarioRepository.getById(userId);
        Producto producto = productoRepository.getById(productId);
        BigDecimal subtotal = carrito.getPrecioUnitario().multiply(BigDecimal.valueOf(carrito.getCantidad()));
        carrito.setUsuario(usuario);
        carrito.setProducto(producto);
        carrito.setSubtotal(subtotal);
        carrito.setTotal(subtotal.multiply(BigDecimal.valueOf(1.38)));
        return new ResponseEntity<>(carritoRepository.save(carrito), HttpStatus.CREATED);
    }

    @PutMapping("/carrito/{id}/")
        public Carrito modifyCarrito(@PathVariable("id") Long id, @RequestBody Carrito carrito) {
            Carrito carritoModificado = carritoRepository.getById(id);
            BigDecimal subtotal = carrito.getPrecioUnitario().multiply(BigDecimal.valueOf(carrito.getCantidad()));
            carritoModificado.setGeneradoPor(carrito.getGeneradoPor());
            carritoModificado.setCantidad(carrito.getCantidad());
            carritoModificado.setPrecioUnitario(carrito.getPrecioUnitario());
            carritoModificado.setSubtotal(subtotal);
            carritoModificado.setTotal(subtotal.multiply(BigDecimal.valueOf(1.38)));
            carritoModificado.setActivo(carrito.getActivo());
            return carritoRepository.save(carritoModificado);
    }
    @DeleteMapping("/carrito/{id}/")
        public void deleteCarrito(@PathVariable("id") Long id) {
            Carrito carrito = carritoRepository.getById(id);
            carritoRepository.delete(carrito);
    }
}
