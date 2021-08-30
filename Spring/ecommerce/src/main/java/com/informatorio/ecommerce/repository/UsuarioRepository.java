package com.informatorio.ecommerce.repository;

import com.informatorio.ecommerce.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    List<Usuario> findByFechaDeCreacionAfter(LocalDateTime fechaDeCreacion);
    List<Usuario> findByFechaDeCreacionBetween(LocalDateTime fechaInicio, LocalDateTime fechaFin);
    Object findByNombreContainingAndApellidoContainingAndDireccionContaining(String nombre, String apellido, String direccion);
    List<Usuario> findAllByNombreContaining(String nombre);
    Object findAllByApellidoContaining(String apellido);
}
