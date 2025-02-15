package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService {
    @Autowired
    private ProductoManagement productoManagement;

    /*
     * Metodo de la clase ProductoService que llama al metodo findAll de la clase
     * ProductoManagement
     * findAll es un metodo que retorna una lista de todos los productos
     * 
     * @return List<Producto> lista de productos
     */
    public List<Producto> ListarTodosLosProducots() {
        return productoManagement.findAll();
    }

    /*
     * Metodo de la clase ProductoService que llama al servicio CRUD (Read) pero por id 
     */
    public Producto GetProductById(Integer id) {
        return productoManagement.findById(id).get();
    }

    /*
     * 
     */
    public Producto GuardarProducio(Producto producto){
        return productoManagement.save(producto);
    }

    /*
     * 
     */
    public Producto UpdateProducto(Integer id,Producto producto){
        return productoManagement.findById(id).map(newProducto -> {
            newProducto.setNombre(producto.getNombre());
            newProducto.setPrecio(producto.getPrecio());
            newProducto.setCantidad(producto.getCantidad());
            newProducto.setDescripcion(producto.getDescripcion());
            return productoManagement.save(newProducto);
        }).orElse(null);
    }

    // Eliminar producto
    public boolean EliminarProducto(Integer id){
        if(productoManagement.existsById(id)){
            productoManagement.deleteById(id);
            System.out.println("Producto eliminado " + id);
            return true;
        }
        System.out.println("No se encontro el producto");
        return false;
    }
}
