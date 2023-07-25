package com.example.Restaurante.repositories;


import com.example.Restaurante.entities.Claim;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ClaimRepository extends JpaRepository<Claim, Integer> {

}
