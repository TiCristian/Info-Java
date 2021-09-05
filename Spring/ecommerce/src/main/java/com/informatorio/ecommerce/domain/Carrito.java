package com.informatorio.ecommerce.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;
import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;


@Entity
public class Carrito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String generadoPor;
    private Integer cantidad;
    private BigDecimal precioUnitario;
    private Boolean activo = true;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario usuario;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Producto producto;

    @CreationTimestamp
    private LocalDateTime alta;

    @Transient
    private BigDecimal total;

    @Transient
    private BigDecimal subtotal;

    public Long getId() {return id;}
    public String getGeneradoPor() {return generadoPor;}
    public Usuario getUsuario() {return usuario;}
    public Producto getProducto() {return producto;}
    public LocalDateTime getAlta() {return alta;}
    public BigDecimal getSubtotal() {return subtotal;}
    public BigDecimal getTotal() {return total;}
    public Integer getCantidad() {return cantidad;}
    public BigDecimal getPrecioUnitario() {return precioUnitario;}
    public Boolean getActivo() {return activo;}

    public void setId(Long id) {this.id = id;}
    public void setGeneradoPor(String generadoPor) {this.generadoPor = generadoPor;}
    public void setAlta(LocalDateTime alta) {this.alta = alta;}
    public void setCantidad(Integer cantidad) {this.cantidad = cantidad;}
    public void setPrecioUnitario(BigDecimal precioUnitario) {this.precioUnitario = precioUnitario;}
    public void setUsuario(Usuario usuario) {this.usuario = usuario;}
    public void setProducto(Producto producto) {this.producto = producto;}
    public void setTotal(BigDecimal total) {this.total = total;}
    public void setSubtotal(BigDecimal subtotal) {this.subtotal = subtotal;}
    public void setActivo(Boolean activo) {this.activo = activo;}
}
