package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Interfaz que extiende de JpaRepository para poder realizar operaciones CRUD
// CRUD => Create, Read, Update, Delete
// Interfaces son un conjunto de metodos que una clase debe implementar
@Repository
public interface ProductoManagement extends JpaRepository<Producto, Integer> {

}
