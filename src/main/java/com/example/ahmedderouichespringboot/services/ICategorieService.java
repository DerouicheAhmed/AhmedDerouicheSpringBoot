package com.example.ahmedderouichespringboot.services;

import com.example.ahmedderouichespringboot.entity.CategorieProduit;

import java.util.List;

public interface ICategorieService {
    List<CategorieProduit> retrieveAllCategorieProduits();

    CategorieProduit addCategorieProduit(CategorieProduit cp);

    CategorieProduit updateCategorieProduit(CategorieProduit cp);

    CategorieProduit retrieveCategorieProduit(Long id);

    void removeCategorieProduit(Long id);
}
