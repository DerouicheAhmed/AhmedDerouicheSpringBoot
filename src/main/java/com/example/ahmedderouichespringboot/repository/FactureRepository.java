package com.example.ahmedderouichespringboot.repository;

import com.example.ahmedderouichespringboot.entity.Facture;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FactureRepository extends JpaRepository<Facture,Long> {
    public List<Facture> findByFournisseur_IdFournisseur(Long id);
}
