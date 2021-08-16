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
@RequestMapping("/usuario/")
public class UsuarioController {

    private final UsuarioRepository usuarioRepository;

    public UsuarioController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping
    public ResponseEntity<?> obtenerTodosLosUsuarios(
            @RequestParam(name = "fechaDeCreacion", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaDeCreacion,
            @RequestParam(name = "nombre", required = false) String nombre,
            @RequestParam(name = "apellido", required = false) String apellido,
            @RequestParam(name = "direccion", required = false) String direccion) {
        if (fechaDeCreacion != null) {
            return new ResponseEntity<>(usuarioRepository.findByFechaDeCreacionAfter(fechaDeCreacion.atStartOfDay()), HttpStatus.OK);
        } else if (Objects.nonNull(nombre) && Objects.nonNull(apellido) && Objects.nonNull(direccion)) {
            return new ResponseEntity<>(usuarioRepository.findByNombreContainingAndApellidoContainingAndDireccionContaining(
                    nombre, apellido, direccion), HttpStatus.OK);
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

