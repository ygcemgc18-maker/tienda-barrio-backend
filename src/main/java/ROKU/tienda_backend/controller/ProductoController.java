package ROKU.tienda_backend.controller;

import ROKU.tienda_backend.entity.Producto;
import ROKU.tienda_backend.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    @Autowired
    private ProductoRepository productoRepository;

    // GET: Listar todos los productos (http://localhost:8080/api/productos)
    @GetMapping
    public List<Producto> listarProductos() {
        return productoRepository.findAll();
    }

    // POST: Guardar un nuevo producto
    @PostMapping
    public Producto guardarProducto(@RequestBody Producto producto) {
        return productoRepository.save(producto);
    }

    // GET: Buscar producto por ID
    @GetMapping("/{id}")
    public Optional<Producto> obtenerProductoPorId(@PathVariable Long id) {
        return productoRepository.findById(id);
    }

    // DELETE: Eliminar un producto por ID
    @DeleteMapping("/{id}")
    public void eliminarProducto(@PathVariable Long id) {
        productoRepository.deleteById(id);
    }
}