package com.example.ahmedderouichespringboot.repository;

import com.example.ahmedderouichespringboot.entity.Reglement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReglementRepository extends JpaRepository<Reglement,Long> {
    public List<Reglement> retrieveReglementByFacture(Long idFacture);
}
