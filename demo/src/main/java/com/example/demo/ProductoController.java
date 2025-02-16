package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/producto")
public class ProductoController {
    @Autowired
    private ProductoService productoService;

    @GetMapping
    public List<Producto> ListarTodosLosProductos() {
        return productoService.ListarTodosLosProductos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> GetProductById(@PathVariable Integer id) {
        return ResponseEntity.ok(productoService.GetProductById(id));
    }

    @PostMapping
    public Producto GuardarProducto(@RequestBody Producto producto) {
        return productoService.GuardarProducto(producto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Producto> UpdateProducto(@PathVariable Integer id, @RequestBody Producto productoDetails) {
        Producto updatedProducto = productoService.UpdateProducto(id, productoDetails);
        return updatedProducto != null ? ResponseEntity.ok(updatedProducto) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProducto(@PathVariable Integer id) {
        return productoService.EliminarProducto(id) ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }
}