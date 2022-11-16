package com.example.ahmedderouichespringboot.controller;

import com.example.ahmedderouichespringboot.entity.Produit;
import com.example.ahmedderouichespringboot.services.IProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/produit")
@RestController
public class ProduitController {
    @Autowired
    IProduitService iProduitService;
    @GetMapping()
    public List<Produit> retrieveAllProduits() {
        return iProduitService.retrieveAllProduits();
    }
    @PostMapping("/add")
    public Produit addProduit (@RequestBody Produit p,@PathVariable  Long idCategorieProduit,@PathVariable Long idStock){
        return iProduitService.addProduit(p, idCategorieProduit,idStock);
    }
    @PutMapping("/edit")
    public Produit updateProduit(@RequestBody Produit p,@PathVariable  Long idCategorieProduit,@PathVariable Long idStock){
        return iProduitService.updateProduit(p,idCategorieProduit,idStock);
    }
    @GetMapping("/{idProduit}")
    public Produit retrieveProduit (@PathVariable Long idProduit){
        return iProduitService.retrieveProduit(idProduit);
    }
}
