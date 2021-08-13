package com.informatorio.ejemplo.controller;

import com.informatorio.ejemplo.entity.EmpleadoPlanta;
import com.informatorio.ejemplo.repository.EmpleadoPlantaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmpleadoPlantaController {

    @Autowired
    private EmpleadoPlantaRepository repository;

    @GetMapping(value = "/empleados-planta")
    public @ResponseBody Iterable<EmpleadoPlanta> findEmpleadosPlanta() {
        return repository.findAll();
    }
}