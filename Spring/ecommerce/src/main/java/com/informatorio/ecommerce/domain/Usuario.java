package com.informatorio.ecommerce.domain;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Usuario {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nombre;
    @NotBlank
    private String apellido;
    @NotBlank
    private String direccion;

    private String nombreDeUsuario;

    @CreationTimestamp
    private LocalDateTime fechaDeCreacion;
    @UpdateTimestamp
    private LocalDateTime fechaUltimaModificacion;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Carrito> carritos = new ArrayList<>();

    public Long getId() {return id;}
    public String getNombre() {return nombre;}
    public String getApellido() {return apellido;}
    public String getDireccion() {return direccion;}
    public LocalDateTime getFechaDeCreacion() {return fechaDeCreacion;}
    public LocalDateTime getFechaUltimaModificacion() {return fechaUltimaModificacion;}
    public String getNombreDeUsuario() {return nombreDeUsuario;}

    public void setId(Long id) {this.id = id;}
    public void setNombre(String nombre) {this.nombre = nombre;}
    public void setApellido(String apellido) {this.apellido = apellido;}
    public void setDireccion(String direccion) {this.direccion = direccion;}
    public void setFechaDeCreacion(LocalDateTime fechaDeCreacion) {
        this.fechaDeCreacion = fechaDeCreacion;
    }
    public void setFechaUltimaModificacion(LocalDateTime fechaUltimaModificacion) {
        this.fechaUltimaModificacion = fechaUltimaModificacion;
    }
    public void setNombreDeUsuario(String nombreDeUsuario) {this.nombreDeUsuario = nombreDeUsuario;}

    public void agregarCarrito(Carrito carrito){
        carritos.add(carrito);
        carrito.setUsuario(this);
    }
    public void removerCarrito(Carrito carrito){
        carritos.remove(carrito);
        carrito.setUsuario(null);
    }
}
