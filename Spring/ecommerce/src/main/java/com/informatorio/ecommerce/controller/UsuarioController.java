package com.informatorio.ecommerce.controller;

import com.informatorio.ecommerce.domain.Usuario;
import com.informatorio.ecommerce.repository.UsuarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/usuario/")
public class UsuarioController {

    private final UsuarioRepository usuarioRepository;

    public UsuarioController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping("")
    public List<Usuario> getUsuario(){
        return usuarioRepository.findAll();
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
