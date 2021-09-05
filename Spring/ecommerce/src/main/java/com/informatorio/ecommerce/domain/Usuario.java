package com.informatorio.ecommerce.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;
import javax.persistence.*;
import javax.validation.constraints.Email;
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
    private String apellido;
    private String ciudad;
    private String provincia;
    private String pais;
    private String password;

    @Column(nullable = false,unique = true)
    @Email
    private String email;

    @CreationTimestamp
    private LocalDateTime fechaDeCreacion;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Carrito> usuarios = new ArrayList<>();

    public Long getId() {return id;}
    public String getNombre() {return nombre;}
    public String getApellido() {return apellido;}
    public LocalDateTime getFechaDeCreacion() {return fechaDeCreacion;}
    public String getEmail() {return email;}
    public String getCiudad() {return ciudad;}
    public String getProvincia() {return provincia;}
    public String getPais() {return pais;}

    public void setId(Long id) {this.id = id;}
    public void setNombre(String nombre) {this.nombre = nombre;}
    public void setApellido(String apellido) {this.apellido = apellido;}
    public void setFechaDeCreacion(LocalDateTime fechaDeCreacion) {this.fechaDeCreacion = fechaDeCreacion;}
    public void setPassword(String password) {this.password = password;}
    public void setEmail(String email) {this.email = email;}
    public void setCiudad(String ciudad) {this.ciudad = ciudad;}
    public void setProvincia(String provincia) {this.provincia = provincia;}
    public void setPais(String pais) {this.pais = pais;}
}
