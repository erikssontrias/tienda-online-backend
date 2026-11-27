package com.kultstudio.backend.controllers;

import com.kultstudio.backend.dto.PedidoRequestDTO;
import com.kultstudio.backend.models.Pedido;
import com.kultstudio.backend.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/pedidos")
@CrossOrigin(origins = "*")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping
    public ResponseEntity<?> crearPedido(@RequestBody PedidoRequestDTO request) {
        Map<String, Object> response = new HashMap<>();
        try {
            Pedido nuevoPedido = pedidoService.guardarPedido(request);

            response.put("success", true);
            response.put("message", "Pedido registrado exitosamente");
            response.put("pedido", nuevoPedido);

            return ResponseEntity.ok(response);

        } catch (Exception e) {
            e.printStackTrace();

            response.put("success", false);
            response.put("message", "Error al registrar el pedido: " + e.getMessage());

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
}