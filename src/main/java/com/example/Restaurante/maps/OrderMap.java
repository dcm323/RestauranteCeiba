package com.example.Restaurante.maps;

import com.example.Restaurante.entities.Order;
import com.example.Restaurante.dtos.OrderResponseDTO;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMap {
    @Mappings({
            @Mapping(source = "local", target="local"),
            @Mapping(source = "state", target="state")
    })
    public OrderResponseDTO TransformOrder (Order order);
    public List<OrderResponseDTO> TransformOrderList(List<Order> orderList);

}


