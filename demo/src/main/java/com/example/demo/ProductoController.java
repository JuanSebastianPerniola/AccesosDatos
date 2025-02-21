package com.example.demo;

import java.util.List;

import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/producto")
public class ProductoController {
    @Autowired
    private ProductoService productoService;

    @GetMapping
    public ResponseEntity<List<Producto>> ListarTodosLosProductos() throws BadRequestException {
        if (productoService == null) {
            throw new BadRequestException("Error interno: El servicio no está disponible.");
        }
        return ResponseEntity.ok(productoService.ListarTodosLosProductos());
    }

    @GetMapping("/Mirar/{id}")
    public ResponseEntity<Producto> GetProductById(@PathVariable Integer id) throws BadRequestException {
        if (productoService == null) {
            throw new BadRequestException("Error interno: Servicio no disponible.");
        }
        Producto producto = productoService.GetProductById(id);
        return producto != null ? ResponseEntity.ok(producto) : ResponseEntity.notFound().build();
    }

    @PostMapping("/guardar")
    public ResponseEntity<Producto> GuardarProducto(@RequestBody Producto producto) throws BadRequestException {
        if (productoService == null) {
            throw new BadRequestException("Error interno: Servicio no disponible.");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(productoService.GuardarProducto(producto));
    }

    @PutMapping("/Update/{id}")
    public ResponseEntity<Producto> UpdateProducto(@PathVariable Integer id, @RequestBody Producto productoDetails) throws BadRequestException {
        if (productoService == null) {
            throw new BadRequestException("Error interno: Servicio no disponible.");
        }
        Producto updatedProducto = productoService.UpdateProducto(id, productoDetails);
        return updatedProducto != null ? ResponseEntity.ok(updatedProducto) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/Delete/{id}")
    public ResponseEntity<Void> deleteProducto(@PathVariable Integer id) throws BadRequestException {
        if (productoService == null) {
            throw new BadRequestException("Error interno: Servicio no disponible.");
        }
        return productoService.EliminarProducto(id) ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }
}
