package ROKU.tienda_backend.controller;

import ROKU.tienda_backend.entity.Categoria;
import ROKU.tienda_backend.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    // GET: Listar todas las categorías (http://localhost:8080/api/categorias)
    @GetMapping
    public List<Categoria> listar() {
        return categoriaService.listarCategorias();
    }

    // POST: Crear una categoría nueva
    @PostMapping
    public Categoria guardar(@RequestBody Categoria categoria) {
        return categoriaService.guardarCategoria(categoria);
    }

    // GET: Buscar categoría por ID (http://localhost:8080/api/categorias/1)
    @GetMapping("/{id}")
    public Optional<Categoria> obtenerPorId(@PathVariable Long id) {
        return categoriaService.obtenerCategoriaPorId(id);
    }

    // DELETE: Eliminar una categoría por ID (http://localhost:8080/api/categorias/1)
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        categoriaService.eliminarCategoria(id);
    }
}