package com.informatorio.ejemplo.repository;

import com.informatorio.ejemplo.entity.EmpleadoPlanta;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoPlantaRepository extends CrudRepository<EmpleadoPlanta, Long> {
}
