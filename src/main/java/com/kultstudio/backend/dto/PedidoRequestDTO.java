package com.kultstudio.backend.dto;

import java.math.BigDecimal;
import java.util.List;

public class PedidoRequestDTO {

    private BigDecimal total;
    private List<ItemPedidoDTO> items;

    public PedidoRequestDTO() {
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public List<ItemPedidoDTO> getItems() {
        return items;
    }

    public void setItems(List<ItemPedidoDTO> items) {
        this.items = items;
    }

    // Sub-DTO para los ítems
    public static class ItemPedidoDTO {
        private Integer idProducto;
        private Integer cantidad;
        private BigDecimal precioUnitario;

        public ItemPedidoDTO() {
        }

        public Integer getIdProducto() {
            return idProducto;
        }

        public void setIdProducto(Integer idProducto) {
            this.idProducto = idProducto;
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
    }
}