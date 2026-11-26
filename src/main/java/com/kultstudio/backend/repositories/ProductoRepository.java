package com.kultstudio.backend.repositories;

import com.kultstudio.backend.models.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {
    List<Producto> findByCategoriaIdCategoria(Integer idCategoria);
}
