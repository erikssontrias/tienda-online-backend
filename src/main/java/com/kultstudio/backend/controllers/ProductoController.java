package com.kultstudio.backend.controllers;

import com.kultstudio.backend.dto.ProductoDTO;
import com.kultstudio.backend.models.Producto;
import com.kultstudio.backend.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
@CrossOrigin(origins = "*")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping
    public List<ProductoDTO> listarProductos() {
        return productoService.obtenerTodosDTO();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductoDTO> obtenerProducto(@PathVariable Integer id) {
        return productoService.obtenerPorIdDTO(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/categoria/{idCategoria}")
    public List<ProductoDTO> listarPorCategoria(@PathVariable Integer idCategoria) {
        return productoService.obtenerPorCategoriaDTO(idCategoria);
    }

    @PostMapping
    public ProductoDTO crearProducto(@RequestBody Producto producto) {
        return productoService.guardarYConvertir(producto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductoDTO> actualizarProducto(@PathVariable Integer id, @RequestBody Producto productoActualizado) {
        return productoService.obtenerEntidadPorId(id)
                .map(producto -> {
                    producto.setSku(productoActualizado.getSku());
                    producto.setNombre(productoActualizado.getNombre());
                    producto.setDescripcion(productoActualizado.getDescripcion());
                    producto.setPrecio(productoActualizado.getPrecio());
                    producto.setImagen(productoActualizado.getImagen());
                    producto.setCategoria(productoActualizado.getCategoria());
                    return ResponseEntity.ok(productoService.guardarYConvertir(producto));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable Integer id) {
        if (productoService.obtenerEntidadPorId(id).isPresent()) {
            productoService.eliminar(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}