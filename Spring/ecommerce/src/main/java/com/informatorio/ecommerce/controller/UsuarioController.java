package com.informatorio.ecommerce.controller;

import com.informatorio.ecommerce.domain.Usuario;
import com.informatorio.ecommerce.repository.UsuarioRepository;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.time.LocalDate;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioRepository usuarioRepository;

    public UsuarioController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping
    public ResponseEntity<?> searchUsuarios(@RequestParam(name = "fechaDeCreacion", required = false)
                                            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaDeCreacion,
                                            @RequestParam(name = "ciudad", required = false) String ciudad){
        if (ciudad != null) {
            return new ResponseEntity<>(usuarioRepository.findByCiudadContaining(ciudad), HttpStatus.OK);
        }
        else if (fechaDeCreacion != null){
            return new ResponseEntity<>(usuarioRepository.findByFechaDeCreacionAfter(fechaDeCreacion.atTime(00,00,00)), HttpStatus.OK);
        }
        return new ResponseEntity<>(usuarioRepository.findAll(),HttpStatus.OK);
    }

    @PostMapping("/new")
    public ResponseEntity<?> createUsuario(@Valid @RequestBody Usuario usuario){
        return new ResponseEntity<>(usuarioRepository.save(usuario), HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}/")
    public Usuario modifyUsuario(@PathVariable("id") Long id, @RequestBody Usuario usuario){
        Usuario usuarioModificado = usuarioRepository.getById(id);
        usuarioModificado.setNombre(usuario.getNombre());
        usuarioModificado.setApellido(usuario.getApellido());
        usuarioModificado.setEmail(usuario.getEmail());
        usuarioModificado.setProvincia(usuario.getProvincia());
        usuarioModificado.setCiudad(usuario.getCiudad());
        usuarioModificado.setPais(usuario.getPais());
        return usuarioRepository.save(usuarioModificado);
    }

    @DeleteMapping("/{id}/")
    public void deleteUsuario(@PathVariable("id") Long id) {
        Usuario usuario =  usuarioRepository.getById(id);
        usuarioRepository.delete(usuario);
    }
}

