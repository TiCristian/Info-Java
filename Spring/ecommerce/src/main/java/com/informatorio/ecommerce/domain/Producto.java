package com.informatorio.ecommerce.domain;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @NotBlank
    private String nombre;
    private String descripcion;
    private String contenido;
    private String publicado;

    @CreationTimestamp
    private LocalDateTime alta;

    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Carrito> productos = new ArrayList<>();

    public Long getId() {return id;}
    public String getNombre() {return nombre;}
    public String getDescripcion() {return descripcion;}
    public String getContenido() {return contenido;}
    public String getPublicado() {return publicado;}
    public LocalDateTime getAlta() {return alta;}

    public void setId(Long id) {this.id = id;}
    public void setNombre(String nombre) {this.nombre = nombre;}
    public void setDescripcion(String descripcion) {this.descripcion = descripcion;}
    public void setContenido(String contenido) {this.contenido = contenido;}
    public void setPublicado(String publicado) {this.publicado = publicado;}
    public void setAlta(LocalDateTime alta) {this.alta = alta;}

}
