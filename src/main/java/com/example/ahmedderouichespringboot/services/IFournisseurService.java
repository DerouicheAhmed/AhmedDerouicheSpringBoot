package com.example.ahmedderouichespringboot.services;

import com.example.ahmedderouichespringboot.entity.Fournisseur;

import java.util.List;

public interface IFournisseurService {
    List<Fournisseur> retrieveAllFournisseurs();
    Fournisseur addFournisseur (Fournisseur f);
    Fournisseur updateFournisseur (Fournisseur f);
    Fournisseur retrieveFournisseur (Long id);
}
