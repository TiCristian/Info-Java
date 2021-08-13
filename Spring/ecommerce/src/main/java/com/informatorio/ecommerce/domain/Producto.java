package com.informatorio.ecommerce.domain;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @NotBlank
    private String nombre;
    private String descripcion;
    private String codigo;
    private String categoria;
    @Positive
    private BigDecimal precio;

    @CreationTimestamp
    private LocalDateTime fechaDeCreacion;
    @UpdateTimestamp
    private LocalDateTime fechaUltimaModificacion;

    public Long getId() {return id;}
    public String getNombre() {return nombre;}
    public String getDescripcion() {return descripcion;}
    public BigDecimal getPrecio() {return precio;}
    public String getCodigo() {return codigo;}
    public String getCategoria() {return categoria;}

    public void setId(Long id) {this.id = id;}
    public void setNombre(String nombre) {this.nombre = nombre;}
    public void setDescripcion(String descripcion) {this.descripcion = descripcion;}
    public void setPrecio(BigDecimal precio) {this.precio = precio;}
    public void setCodigo(String codigo) {this.codigo = codigo;}
    public void setCategoria(String categoria) {this.categoria = categoria;}
}
