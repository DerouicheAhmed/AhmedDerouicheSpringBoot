package com.example.ahmedderouichespringboot.services;

import com.example.ahmedderouichespringboot.entity.Produit;
import com.example.ahmedderouichespringboot.entity.Stock;
import com.example.ahmedderouichespringboot.repository.ProduitRepository;
import com.example.ahmedderouichespringboot.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProduitServImpl implements IProduitService{
    @Autowired
    ProduitRepository produitRepository;
    StockRepository stockRepository;
    @Override
    public List<Produit> retrieveAllProduits() {
        return produitRepository.findAll();
    }

    @Override
    public Produit addProduit(Produit p, Long idCategorieProduit, Long idStock) {
        try {
            return produitRepository.save(p);
        } catch (Exception E) {
            System.out.println("Erreur  : " + E);
        }
        return p;
    }

    @Override
    public Produit updateProduit(Produit p, Long idCategorieProduit, Long idStock) {
        try {
            Produit produit=produitRepository.findById(p.getIdProduit()).get();
            return produitRepository.save(p);
        } catch (Exception E) {
            System.out.println("Erreur : " + E);
        }
        return p;
    }

    @Override
    public Produit retrieveProduit(Long id) {
        try {
            return produitRepository.findById(id).get();
        } catch (Exception E) {
            System.out.println("Erreur : " + E);
        }
        return null;
    }

    @Override
    public void assignProduitToStock(Long idProduit, Long idStock) {
        Produit produit=produitRepository.findById(idProduit).orElse(null);
        Stock stock=stockRepository.findById(idStock).orElse(null);
        if(produit!=null && stock!=null){
            produit.setStock(stock);
            produitRepository.save(produit);
        }
    }
}
