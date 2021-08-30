package com.informatorio.ecommerce.controller;

import com.informatorio.ecommerce.domain.Usuario;
import com.informatorio.ecommerce.repository.UsuarioRepository;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.time.LocalDate;
import java.util.Objects;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioRepository usuarioRepository;

    public UsuarioController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping
    public ResponseEntity<?> obtenerUsuarios(
            @RequestParam(name = "fechaDeCreacion", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaDeCreacion,
            @RequestParam(name = "fechaInicio",required = false)  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaInicio,
            @RequestParam(name = "fechaFin",required = false)  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaFin,
            @RequestParam(name = "nombre", required = false) String nombre,
            @RequestParam(name = "apellido", required = false) String apellido,
            @RequestParam(name = "direccion", required = false) String direccion) {
        if (fechaDeCreacion != null) {
            return new ResponseEntity<>(usuarioRepository.findByFechaDeCreacionAfter(fechaDeCreacion.atStartOfDay()), HttpStatus.OK);
        }
        else if (Objects.nonNull(nombre) && Objects.nonNull(apellido) && Objects.nonNull(direccion)) {
            return new ResponseEntity<>(usuarioRepository.findByNombreContainingAndApellidoContainingAndDireccionContaining(
                    nombre, apellido, direccion), HttpStatus.OK);
        }
        else if (fechaInicio != null && fechaFin != null) {
            return new ResponseEntity<>(usuarioRepository.findByFechaDeCreacionBetween(fechaInicio.atTime(00,00,00),
                    fechaFin.atTime(23,59,59)), HttpStatus.OK);
        }
        else if (nombre != null){
            return new ResponseEntity<>(usuarioRepository.findAllByNombreContaining(nombre),HttpStatus.OK);
        }
        else if (apellido != null){
            return new ResponseEntity<>(usuarioRepository.findAllByApellidoContaining(apellido),HttpStatus.OK);
        }
        return new ResponseEntity<>(usuarioRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping("/nuevo")
    public ResponseEntity<?> createUsuario(@Valid @RequestBody Usuario usuario){
        return new ResponseEntity<>(usuarioRepository.save(usuario), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}/")
    public void borrarUsuario(@PathVariable("id") Long id) {
        Usuario usuario =  usuarioRepository.getById(id);
        usuarioRepository.delete(usuario);
    }
}

