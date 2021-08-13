package com.informatorio.ejemplo.config;

import com.informatorio.ejemplo.entity.EmpleadoContratado;
import com.informatorio.ejemplo.repository.EmpleadoContratadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;

@Component
public class EmpleadoContratadoRunner implements CommandLineRunner {

    @Autowired
    private EmpleadoContratadoRepository empleadoRepository;

    @Override
    public void run(String... args) throws Exception {
        EmpleadoContratado empleado2 = new EmpleadoContratado();
        empleado2.setApellido("Simpson");
        empleado2.setNombre("Homero");
        empleado2.setFechaDeNacimiento(LocalDate.now().minusYears(40));
        empleado2.setVencimiento(LocalDate.now().plusYears(1));
        empleado2.setEspecialidad("vendedor de grasa");
        empleado2.setMonto(new BigDecimal(4200));
        empleadoRepository.save(empleado2);
    }
}
