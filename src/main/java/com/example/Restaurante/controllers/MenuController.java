package com.example.Restaurante.controllers;

import com.example.Restaurante.dtos.MenuDTO;
import com.example.Restaurante.dtos.MenuErrorDTO;
import com.example.Restaurante.dtos.MenuResponseDTO;
import com.example.Restaurante.entities.Menu;
import com.example.Restaurante.services.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("restauranteceiba/Menu")
public class MenuController {

    @Autowired
    private MenuService service;
    @PostMapping
    public ResponseEntity<MenuDTO> register(@RequestBody Menu menuDataClient){
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(service.createMenu(menuDataClient));
        }catch(Exception error){
            MenuErrorDTO ErrorMsg= new MenuErrorDTO();
            ErrorMsg.setErrorMsg(error.getMessage());
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(ErrorMsg);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<MenuDTO> updateInfo(@PathVariable Integer id, @RequestBody Menu menuDataClient){
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(service.updateInfo(menuDataClient,id));
        }catch(Exception error){
            MenuErrorDTO ErrorMsg= new MenuErrorDTO();
            ErrorMsg.setErrorMsg(error.getMessage());
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(ErrorMsg);
        }
    }

    @PutMapping("/estado/{id}")
    public ResponseEntity<MenuDTO> updateStatus(@PathVariable Integer id, @RequestBody Menu menuDataClient){
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(service.updateStatus(menuDataClient,id));
        }catch(Exception error){
            MenuErrorDTO ErrorMsg= new MenuErrorDTO();
            ErrorMsg.setErrorMsg(error.getMessage());
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(ErrorMsg);
        }
    }


    @GetMapping
    public ResponseEntity <List<MenuResponseDTO>> obtenerPlatosPaginadosYFiltrados(
            @RequestParam() String category,
            @RequestParam() String local,
            @RequestParam() int registernumbers
    ){
        try{
            // Llamamos al servicio para obtener la respuesta paginada
            Page<MenuResponseDTO> platosPaginados = service.obtainMenuLocalCategory(category, local, registernumbers);

            // Creamos una instancia de PlatoRespuestaPaginadaDTO y le pasamos la lista de platos obtenida del Page
            List<MenuResponseDTO> listaPlatos = platosPaginados.getContent();
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(listaPlatos);
        }catch(Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(null);
        }
    }


}

