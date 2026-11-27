package com.kultstudio.backend.services;

import com.kultstudio.backend.dto.ProductoDTO;
import com.kultstudio.backend.models.Producto;
import com.kultstudio.backend.repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    private ProductoDTO convertirADTO(Producto producto) {
        Integer idCat = producto.getCategoria() != null ? producto.getCategoria().getIdCategoria() : null;
        String nombreCat = producto.getCategoria() != null ? producto.getCategoria().getNombre() : "Sin categoría";

        return new ProductoDTO(
                producto.getIdProducto(),
                producto.getSku(),
                producto.getNombre(),
                producto.getDescripcion(),
                producto.getPrecio(),
                producto.getImagen(),
                idCat,
                nombreCat
        );
    }

    public List<ProductoDTO> obtenerTodosDTO() {
        return productoRepository.findAll()
                .stream()
                .map(this::convertirADTO)
                .collect(Collectors.toList());
    }

    public Optional<ProductoDTO> obtenerPorIdDTO(Integer id) {
        return productoRepository.findById(id).map(this::convertirADTO);
    }

    public List<ProductoDTO> obtenerPorCategoriaDTO(Integer idCategoria) {
        return productoRepository.findByCategoriaIdCategoria(idCategoria)
                .stream()
                .map(this::convertirADTO)
                .collect(Collectors.toList());
    }

    public Optional<Producto> obtenerEntidadPorId(Integer id) {
        return productoRepository.findById(id);
    }

    public ProductoDTO guardarYConvertir(Producto producto) {
        Producto guardado = productoRepository.save(producto);
        return convertirADTO(guardado);
    }

    public void eliminar(Integer id) {
        productoRepository.deleteById(id);
    }
}