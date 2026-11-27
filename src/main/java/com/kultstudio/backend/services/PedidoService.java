package com.kultstudio.backend.services;

import com.kultstudio.backend.dto.PedidoRequestDTO;
import com.kultstudio.backend.models.DetallePedido;
import com.kultstudio.backend.models.Pedido;
import com.kultstudio.backend.models.Producto;
import com.kultstudio.backend.repositories.PedidoRepository;
import com.kultstudio.backend.repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @Transactional
    public Pedido guardarPedido(PedidoRequestDTO request) {
        Pedido pedido = new Pedido();

        pedido.setIdUsuario(1);
        pedido.setIdDireccion(1);
        pedido.setFecha(LocalDateTime.now());

        BigDecimal totalGeneral = request.getTotal() != null ? request.getTotal() : BigDecimal.ZERO;
        pedido.setTotal(totalGeneral);
        pedido.setSubtotal(totalGeneral);
        pedido.setEstado("PENDIENTE");

        if (request.getItems() != null && !request.getItems().isEmpty()) {
            for (var itemDto : request.getItems()) {
                Producto producto = productoRepository.findById(itemDto.getIdProducto())
                        .orElseThrow(() -> new RuntimeException("Producto no encontrado con ID: " + itemDto.getIdProducto()));

                DetallePedido detalle = new DetallePedido();
                detalle.setPedido(pedido);
                detalle.setProducto(producto);
                detalle.setIdVariante(1);

                int cantidad = itemDto.getCantidad() != null ? itemDto.getCantidad() : 1;
                detalle.setCantidad(cantidad);

                BigDecimal precio = itemDto.getPrecioUnitario() != null ? itemDto.getPrecioUnitario() : producto.getPrecio();
                if (precio == null) {
                    precio = BigDecimal.ZERO;
                }
                detalle.setPrecioUnitario(precio);

                BigDecimal subtotalItem = precio.multiply(BigDecimal.valueOf(cantidad));
                detalle.setSubtotal(subtotalItem);

                pedido.getDetalles().add(detalle);
            }
        }

        return pedidoRepository.save(pedido);
    }
}