package com.example.Restaurante.services;

import com.example.Restaurante.dtos.OrderResponseDTO;
import com.example.Restaurante.entities.Menu;
import com.example.Restaurante.entities.Order;
import com.example.Restaurante.entities.OrderDetail;
import com.example.Restaurante.maps.OrderMap;
import com.example.Restaurante.repositories.MenuRepository;
import com.example.Restaurante.repositories.OrderRepository;
import com.example.Restaurante.util.OrderState;
import com.example.Restaurante.validations.OrderValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    OrderMap OrderMap;
    @Autowired
    OrderRepository OrderRepository;
    @Autowired
    MenuRepository MenuRepositoriy;

    public OrderResponseDTO crearPedido(Order datosDelPedido) throws Exception{
        try{

            //revisamos campos obligatorios
            if(OrderValidation.validarPresenicaSede(datosDelPedido)){
                throw new Exception("Hay campos obligatorios que no se enviaron, revisar por favor");
            }
            //recorro el detalle del pedido (todos los productos que eligio el cliente)
            for (OrderDetail details : datosDelPedido.getDetails()) {
                Integer idPlate = details.getPlate().getId(); //cada plato en el detalle tiene un id
                Optional<Menu> menuOptional = MenuRepositoriy.findById(idPlate); //buscamos el plato en cuestion
                details.getPlate().setName(menuOptional.get().getName()); //llevamos el nombre del plato a lo que vamos a guardar
            }
            return OrderMap.transformOrder(OrderRepository.save(datosDelPedido)); //guardamos el pedido
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public Page<OrderResponseDTO> obtenerListaPedidosPorEstadoYSede(Character rol, String local, OrderState status, int numerodeRegistros) throws Exception{
        try{


            Pageable pager = PageRequest.of(0, numerodeRegistros);
            Page<Order> ordersPaged= OrderRepository.findByLocalAndStatus(local,status,pager);
            return ordersPaged.map(order -> OrderMap.transformOrder(order));
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public OrderResponseDTO actualizarPedidoAEnPreparacion(Integer idPedido, Order datosPedido) throws Exception{
        try{
            //solo el Admin A puede cambiar el estado

            Optional<Order> pedidoOpcional = OrderRepository.findById(idPedido);
            if (pedidoOpcional.isEmpty()) {
                throw new Exception("El pedido no existe");
            }
            Order pedidoExistente = pedidoOpcional.get();
            pedidoExistente.setStatus(OrderState.IN_PROCESS);
            return OrderMap.transformOrder(OrderRepository.save(pedidoExistente));
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }


}
