package com.informatorio.ecommerce.repository;

import com.informatorio.ecommerce.domain.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

    @Query("SELECT p FROM producto p WHERE p.nombre LIKE %:comienzaCon%")
    List<Producto> buscarPorNombreQueComienza(@Param("comienzaCon") String comienzaCon);
}
