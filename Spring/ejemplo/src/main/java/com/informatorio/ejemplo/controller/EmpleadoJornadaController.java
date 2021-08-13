package com.informatorio.ejemplo.controller;

import com.informatorio.ejemplo.entity.EmpleadoJornada;
import com.informatorio.ejemplo.repository.EmpleadoJornadaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmpleadoJornadaController {

    @Autowired
    private EmpleadoJornadaRepository repository;

    @GetMapping(value = "/empleados-jornada")
    public @ResponseBody
    Iterable<EmpleadoJornada> findEmpleadosJornada() {
        return repository.findAll();
    }
}
