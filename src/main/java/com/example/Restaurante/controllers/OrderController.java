package com.example.Restaurante.controllers;

import com.example.Restaurante.dtos.OrderDTO;
import com.example.Restaurante.dtos.OrderErrorDTO;
import com.example.Restaurante.dtos.OrderResponseDTO;
import com.example.Restaurante.entities.Order;
import com.example.Restaurante.services.OrderService;
import com.example.Restaurante.util.OrderState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("restauranteAPI/pedido")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping
    public ResponseEntity<OrderDTO> registrar(@RequestBody Order order){
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(orderService.crearPedido(order));
        }catch(Exception error){
            OrderErrorDTO respuestaError = new OrderErrorDTO();
            respuestaError.setErrorMsg(error.getMessage());
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(respuestaError);
        }
    }

    @GetMapping
    public ResponseEntity <List<OrderResponseDTO>> obtenerPlatosPaginadosYFiltrados(
            @RequestParam() Character role,
            @RequestParam() OrderState category,
            @RequestParam() String local,
            @RequestParam() int numerodeRegistros
    ){
        try {
            Page<OrderResponseDTO> edidosPaginados = orderService.obtenerListaPedidosPorEstadoYSede(role, local, category, numerodeRegistros);
            List<OrderResponseDTO> listapedidos = edidosPaginados.getContent();
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(listapedidos);
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(null);
        }
    }

    @PutMapping("/estado/{id}")
    public ResponseEntity<OrderDTO> actualizarEstadoPreparando(@PathVariable Integer id,  @RequestBody Order datosPedido){
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(orderService.actualizarPedidoAEnPreparacion(id,datosPedido));
        }catch(Exception error){
            OrderErrorDTO respuestaError= new OrderErrorDTO();
            respuestaError.setErrorMsg(error.getMessage());
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(respuestaError);
        }
    }




}
