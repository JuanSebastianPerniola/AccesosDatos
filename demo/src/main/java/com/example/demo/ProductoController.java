package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/producto")
public class ProductoController {
    @Autowired
    private ProductoService productoService;   

    @GetMapping
    public List<Producto> ListarTodosLosProductos(){
        return productoService.ListarTodosLosProducots();
    }
    
    @PostMapping("/{id}")
    public ResponseEntity<Producto> GetProductById(@RequestParam Integer id){
        return ResponseEntity.ok(productoService.GetProductById(id));
    }

    @PostMapping("path")
    public Producto GuardarProducio(@RequestBody Producto producte) {
        return productoService.GuardarProducio(producte);
    }
     @PutMapping("/{id}")
    public ResponseEntity<Producto> UpdateProducto(@PathVariable Integer id, @RequestBody Producto ProductoDetails) {
        Producto updatedProducto = productoService.UpdateProducto(id, ProductoDetails);
        return updatedProducto != null ? ResponseEntity.ok(updatedProducto) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProducto(@PathVariable Integer id) {
        return productoService.EliminarProducto(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
