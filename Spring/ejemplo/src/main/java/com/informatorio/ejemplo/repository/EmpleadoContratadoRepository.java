package com.informatorio.ejemplo.repository;

import com.informatorio.ejemplo.entity.EmpleadoContratado;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoContratadoRepository extends CrudRepository<EmpleadoContratado, Long> {
}
