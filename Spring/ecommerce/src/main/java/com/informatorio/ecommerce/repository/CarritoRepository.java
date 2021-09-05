package com.informatorio.ecommerce.repository;

import com.informatorio.ecommerce.domain.Carrito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface CarritoRepository extends JpaRepository<Carrito, Long> {
    List<Carrito> findByActivoTrue();
    Optional<Carrito> findById(Long id);
}
