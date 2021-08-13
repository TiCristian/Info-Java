package com.informatorio.ecommerce.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Carrito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario usuario;

    @Transient
    private String nombreDeUsuario;

    @NotBlank
    private String dispositivo;

    @CreationTimestamp
    private LocalDateTime fechadecreacion;
    @UpdateTimestamp
    private LocalDateTime fechaultimamodificacion;

    @OneToMany(mappedBy = "carrito", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LineaDeCarrito> lineasDeCarrito = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getDispositivo() {
        return dispositivo;
    }

    public void setDispositivo(String dispositivo) {
        this.dispositivo = dispositivo;
    }

    public LocalDateTime getFechadecreacion() {
        return fechadecreacion;
    }

    public void setFechadecreacion(LocalDateTime fechadecreacion) {
        this.fechadecreacion = fechadecreacion;
    }

    public LocalDateTime getFechaultimamodificacion() {
        return fechaultimamodificacion;
    }

    public void setFechaultimamodificacion(LocalDateTime fechaultimamodificacion) {
        this.fechaultimamodificacion = fechaultimamodificacion;
    }

    public List<LineaDeCarrito> getLineasDeCarrito() {
        return lineasDeCarrito;
    }
    public String getNombreDeUsuario() {
        return nombreDeUsuario;
    }

    public void agregarLineDeCarrito(LineaDeCarrito lineaDeCarrito) {
        lineasDeCarrito.add(lineaDeCarrito);
        lineaDeCarrito.setCarrito(this);
    }

    public void removerLineDeCarrito(LineaDeCarrito lineaDeCarrito) {
        lineasDeCarrito.remove(lineaDeCarrito);
        lineaDeCarrito.setCarrito(null);
    }
}
