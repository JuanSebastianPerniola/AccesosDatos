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
    public List<Producto> ListarTodosLosProductos() {
        return productoManagement.findAll();
    }

    /*
     * Metodo de la clase ProductoService que llama al servicio CRUD (Read) pero por id
     */
    public Producto GetProductById(Integer id) {
        if (productoManagement.existsById(id)) {
            return productoManagement.findById(id).get();
        }
        throw new IllegalArgumentException("Alguno de los valores esta nulo comprueba la request");
    }
    /*
     * Guardar productos y comprobar cada posibilidad de valores nulos
     */

    public Producto GuardarProducto(Producto producto) {
        // si viene vacio devolver que venga vacio
        if (producto.getNombre() == null ||
                producto.getCantidad() == null ||
                producto.getdescription() == null ||
                producto.getPrecio() == null) {
            throw new IllegalArgumentException("Alguno de los valores esta nulo comprueba la request");
        }
        return productoManagement.save(producto);
    }

    /*
     * Updatear producto en base al id,
     * sino se llevare un valor nulo sino es valido alguno de lo valores
     */
    public Producto UpdateProducto(Integer id, Producto producto) {
        if (!productoManagement.existsById(id)) {
            throw new IllegalArgumentException("Alguno de los valores esta nulo comprueba la request");
        }
        System.out.println("Producto modificado " + id);
        return productoManagement.findById(id).map(newProducto -> {
            newProducto.setNombre(producto.getNombre());
            newProducto.setPrecio(producto.getPrecio());
            newProducto.setCantidad(producto.getCantidad());
            newProducto.setdescription(producto.getdescription());
            return productoManagement.save(newProducto);
        }).orElse(null);
    }

    /*
     * Eliminar producto producto
     * en base a la id.
     *
     * Control de errores por sino existe el id que se esta pidiendo elimninar
     * */
    public boolean EliminarProducto(Integer id) {
        try {
            if (productoManagement.existsById(id)) {
                productoManagement.deleteById(id);
                System.out.println("Producto eliminado " + id);
                return true;
            }
            System.out.println("No se encontro el producto");
            return false;
        } catch (Exception e) {
            System.out.println("Algo a ido mal" + e);
        }
        System.out.println("No se encontro el producto");
        return false;
    }
}
