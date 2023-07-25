package com.example.Restaurante.maps;

import com.example.Restaurante.dtos.ClaimResponseDTO;
import com.example.Restaurante.entities.Claim;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClaimMap {
    @Mappings({
            @Mapping(source = "id", target="id"),
            @Mapping(source = "idorder", target="idorder"),
            @Mapping(source = "local", target="local"),
            @Mapping(source = "reason", target="reason")
    })
    public ClaimResponseDTO TransformClaim (Claim claim);
    public List<ClaimResponseDTO> TransformClaimList(List<Claim> claimList);

}
