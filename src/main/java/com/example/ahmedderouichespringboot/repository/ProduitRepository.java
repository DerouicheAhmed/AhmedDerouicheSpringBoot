package com.example.ahmedderouichespringboot.repository;

import com.example.ahmedderouichespringboot.entity.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduitRepository extends JpaRepository<Produit,Long> {
}
