package com.informatorio.ejemplo.repository;

import com.informatorio.ejemplo.entity.EmpleadoJornada;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoJornadaRepository extends CrudRepository<EmpleadoJornada, Long> {
}
