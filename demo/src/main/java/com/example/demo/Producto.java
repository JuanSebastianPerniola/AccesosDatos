package com.example.demo;

// Paquetes importados para cada herramienta utilizada

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// Declaramos especificamos el nombre del producto
@Entity
@Table(name = "Producto")
public class Producto {

    // ID, no puede ser nulo y auto incrementa
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    // No puede ser nullo
    private String nombre;

    // No puede ser nullo
    private String description;

    // No puede ser nullo
    private Integer precio;

    // No puede ser nullo
    private Integer cantidad;

    // Getters y Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getdescription() {
        return description;
    }

    public void setdescription(String description) {
        this.description = description;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
}