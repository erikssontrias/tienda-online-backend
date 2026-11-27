package com.kultstudio.backend.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "detalle_pedido")
@IdClass(DetallePedido.DetallePedidoId.class)
public class DetallePedido {

    @Id
    @ManyToOne
    @JoinColumn(name = "id_pedido")
    @JsonBackReference
    private Pedido pedido;

    @Id
    @Column(name = "id_variante")
    private Integer idVariante;

    @ManyToOne
    @JoinColumn(name = "id_producto")
    private Producto producto;

    @Column(name = "cantidad")
    private Integer cantidad;

    @Column(name = "precio_unitario")
    private BigDecimal precioUnitario;

    @Column(name = "subtotal")
    private BigDecimal subtotal;

    public DetallePedido() {
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Integer getIdVariante() {
        return idVariante;
    }

    public void setIdVariante(Integer idVariante) {
        this.idVariante = idVariante;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(BigDecimal precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public static class DetallePedidoId implements Serializable {
        private Pedido pedido;
        private Integer idVariante;

        public DetallePedidoId() {
        }

        public DetallePedidoId(Pedido pedido, Integer idVariante) {
            this.pedido = pedido;
            this.idVariante = idVariante;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            DetallePedidoId that = (DetallePedidoId) o;
            return Objects.equals(pedido, that.pedido) && Objects.equals(idVariante, that.idVariante);
        }

        @Override
        public int hashCode() {
            return Objects.hash(pedido, idVariante);
        }
    }
}