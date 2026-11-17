package com.kultstudio.backend.controllers;

import com.kultstudio.backend.models.Categoria;
import com.kultstudio.backend.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/categorias")
@CrossOrigin(origins = "*") // Permite conectar el frontend (React, etc.) sin bloqueos de CORS
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    // 1. Endpoint para listar todas las categorías: GET http://localhost:8080/api/categorias
    @GetMapping
    public List<Categoria> obtenerCategorias() {
        return categoriaService.obtenerCategorias();
    }

    // 2. Endpoint para buscar por ID: GET http://localhost:8080/api/categorias/1
    @GetMapping("/{id}")
    public Optional<Categoria> obtenerCategoriaPorId(@PathVariable Integer id) {
        return categoriaService.obtenerCategoriaPorId(id);
    }

    // 3. Endpoint para guardar una nueva categoría: POST http://localhost:8080/api/categorias
    @PostMapping
    public Categoria guardarCategoria(@RequestBody Categoria categoria) {
        return categoriaService.guardarCategoria(categoria);
    }

    // 4. Endpoint para eliminar: DELETE http://localhost:8080/api/categorias/1
    @DeleteMapping("/{id}")
    public void eliminarCategoria(@PathVariable Integer id) {
        categoriaService.eliminarCategoria(id);
    }
}