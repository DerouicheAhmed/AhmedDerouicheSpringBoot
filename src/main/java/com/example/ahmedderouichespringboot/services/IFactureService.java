package com.example.ahmedderouichespringboot.services;

import com.example.ahmedderouichespringboot.entity.Facture;

import java.util.List;

public interface IFactureService {
    List<Facture> retrieveAllFactures();
    void cancelFacture(Long id);
    Facture add(Facture f);
    Facture retrieveFacture(Long id);
    List<Facture> getFacturesByFournisseur(Long idFournisseur);

}
