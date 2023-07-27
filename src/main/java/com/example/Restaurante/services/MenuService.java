package com.example.Restaurante.services;

import com.example.Restaurante.dtos.MenuResponseDTO;
import com.example.Restaurante.entities.Menu;
import com.example.Restaurante.maps.MenuMap;
import com.example.Restaurante.repositories.MenuRepository;
import com.example.Restaurante.validations.MenuValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MenuService {
    @Autowired
    MenuValidation validation;
    @Autowired
    MenuRepository repository;
    @Autowired
    MenuMap map;

    public MenuResponseDTO createMenu(Menu registerMenuData)throws Exception{
        try {
            if(!registerMenuData.getRole().equals('A')){
                throw new Exception("You don´t have access");
            }if(validation.validatePrice(registerMenuData.getPrice())){
                throw new Exception("Invalid Price");
            }if(validation.LocalValidate(registerMenuData.getLocal())){
                throw new Exception("You must add a local first");
            }

            return map.TransformMenu(repository.save(registerMenuData));

    }catch(Exception error){
        throw new Exception(error.getMessage());
        }
    }

    public MenuResponseDTO updateStatus(Menu editMenuData,Integer idMenuEdit)throws Exception{try {
        if(!editMenuData.getRole().equals('A')){
            throw new Exception("You can´t do that");
        }

        Optional<Menu> menuOptional=repository.findById(idMenuEdit);
        if(!menuOptional.isPresent()){
            throw new Exception("not found");
        }

        Menu menuFound=menuOptional.get();
        menuFound.setState(editMenuData.getState());

        Menu menuUpdate=repository.save(menuFound);

        return  map.TransformMenu(repository.save(menuUpdate));


    }catch(Exception error){
        throw new Exception(error.getMessage());
    }


}
public Page<MenuResponseDTO> obtainMenuLocalCategory(String category, String local,Integer registernumbers) throws Exception{
        try{

            Pageable Pagerli= PageRequest.of(0, registernumbers);

            Page<Menu> menuPagerFinded=repository.findByCategoryAndLocal(category,local,Pagerli);

            return null;

        }catch(Exception error){
            throw new Exception(error.getMessage());
        }
}

}
