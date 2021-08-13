package com.informatorio.ejemplo.config;

import com.informatorio.ejemplo.entity.EmpleadoPlanta;
import com.informatorio.ejemplo.repository.EmpleadoPlantaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;

@Component
public class EmpleadoPlantaRunner implements CommandLineRunner {

    @Autowired
    private EmpleadoPlantaRepository empleadoRepository;

    @Override
    public void run(String... args) throws Exception {
        EmpleadoPlanta empleado1 = new EmpleadoPlanta();
        empleado1.setApellido("Simpson");
        empleado1.setNombre("Homero");
        empleado1.setFechaDeNacimiento(LocalDate.now().minusYears(40));
        empleado1.setFechaDeInicio(LocalDate.now().minusYears(20));
        empleado1.setPuesto("Guardaespaldas");
        empleado1.setSueldoBasico(new BigDecimal(4200));
        empleadoRepository.save(empleado1);
    }
}
