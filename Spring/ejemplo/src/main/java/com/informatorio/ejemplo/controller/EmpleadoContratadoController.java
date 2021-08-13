package com.informatorio.ejemplo.controller;

import com.informatorio.ejemplo.entity.EmpleadoContratado;
import com.informatorio.ejemplo.repository.EmpleadoContratadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmpleadoContratadoController {

    @Autowired
    private EmpleadoContratadoRepository repository;

    @GetMapping(value = "/empleados-contratados")
    public @ResponseBody Iterable<EmpleadoContratado> findEmpleadosContratados() {
        return repository.findAll();
    }
}
