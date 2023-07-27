package com.example.Restaurante.repositories;


import com.example.Restaurante.entities.Menu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository

public interface MenuRepository extends JpaRepository<Menu, Integer> {

    Page<Menu> findByCategoryAndLocal(String category, String local, Pageable Pagerli);

}
