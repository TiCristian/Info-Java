package com.informatorio.ejemplo.config;

import com.informatorio.ejemplo.entity.EmpleadoJornada;
import com.informatorio.ejemplo.repository.EmpleadoJornadaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;

@Component
public class EmpleadoJornadaRunner implements CommandLineRunner {

    @Autowired
    private EmpleadoJornadaRepository empleadoRepository;

    @Override
    public void run(String... args) throws Exception {
        EmpleadoJornada empleado3 = new EmpleadoJornada();
        empleado3.setApellido("Simpson");
        empleado3.setNombre("Homero");
        empleado3.setFechaDeNacimiento(LocalDate.now().minusYears(40));
        empleado3.setPrecioHora(new BigDecimal(35));
        empleadoRepository.save(empleado3);
    }
}

