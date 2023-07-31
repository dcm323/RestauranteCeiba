package com.example.Restaurante.maps;

import com.example.Restaurante.dtos.OrderDetailDTO;
import com.example.Restaurante.dtos.OrderResponseDTO;
import com.example.Restaurante.entities.Order;
import com.example.Restaurante.entities.OrderDetail;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface OrderMap {

    //Mapeamos un Pedido para enviar id, sede,estado y
    //detalles(es una lista que tiene que productos y que cantidad de estos esta comprando el cliente)
    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "local", target = "local"),
            @Mapping(source = "status", target = "status"),
            //La entidad Pedido entrega un detalle(que entrega toda la info de un plato y la cantidad)
            //queremos mapear detalle para que solo tenga el nombre y cantidad del plato
            @Mapping(target = "details", qualifiedByName = "transformListOrderDetails")
    })
    OrderResponseDTO transformOrder(Order order);
    List<OrderResponseDTO> transformOrderList(List<Order> ordersList);

    //metodo encargado de recibir cada plato del pedido y mapearlo para solo
    //entregar el nombre de cada plato y la cantidad del mismo
    @Named("transformListOrderDetails")
    default List<OrderDetailDTO> transformListOrderDetails(List<OrderDetail> details) {
        return details.stream()//se descompone la lista
                .map(this::transformOrderDetails) //se convierte cada detalle
                .collect(Collectors.toList()); //se vuelve a armar la lista
    }

    @Mapping(target = "name", source = "id")
    @Mapping(target = "quantity", source = "quantity")
    OrderDetailDTO transformOrderDetails(OrderDetail details);
    }


