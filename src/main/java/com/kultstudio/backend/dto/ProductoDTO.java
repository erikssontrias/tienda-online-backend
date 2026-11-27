package com.kultstudio.backend.dto;

import java.math.BigDecimal;

public class ProductoDTO {

    private Integer idProducto;
    private String sku;
    private String nombre;
    private String descripcion;
    private BigDecimal precio;
    private String imagen;
    private Integer idCategoria;
    private String categoriaNombre;

    public ProductoDTO() {
    }

    public ProductoDTO(Integer idProducto, String sku, String nombre, String descripcion,
                       BigDecimal precio, String imagen, Integer idCategoria, String categoriaNombre) {
        this.idProducto = idProducto;
        this.sku = sku;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.imagen = imagen;
        this.idCategoria = idCategoria;
        this.categoriaNombre = categoriaNombre;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getCategoriaNombre() {
        return categoriaNombre;
    }

    public void setCategoriaNombre(String categoriaNombre) {
        this.categoriaNombre = categoriaNombre;
    }
}