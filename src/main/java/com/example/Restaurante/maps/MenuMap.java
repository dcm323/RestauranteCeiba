package com.example.Restaurante.maps;


import com.example.Restaurante.dtos.MenuResponseDTO;
import com.example.Restaurante.entities.Menu;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MenuMap {
    @Mappings ({
            @Mapping(source = "name", target="name"),
            @Mapping(source = "price", target="price"),
            @Mapping(source = "url", target = "url"),
            @Mapping(source = "description", target = "description")
    })
    public MenuResponseDTO TransformMenu (Menu menu);
    public List<MenuResponseDTO> TransformMenuList(List<Menu> menuList);
}
