package com.example.ahmedderouichespringboot.controller;

import com.example.ahmedderouichespringboot.entity.CategorieProduit;
import com.example.ahmedderouichespringboot.entity.Produit;
import com.example.ahmedderouichespringboot.services.ICategorieService;
import com.example.ahmedderouichespringboot.services.IProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/cat")
@RestController
public class CategorieProduitController {
    @Autowired
    ICategorieService iCategorieService;
    @GetMapping()
    public List<CategorieProduit> retrieveAllCategorieProduits() {
        return iCategorieService.retrieveAllCategorieProduits();
    }
    @PostMapping ("/add")
    public CategorieProduit  addCategorieProduit (@RequestBody CategorieProduit cp ){
        return iCategorieService.addCategorieProduit(cp);
    }
    @PutMapping("/edit")
    public CategorieProduit updateCategorieProduit(@RequestBody CategorieProduit cp ){
        return iCategorieService.updateCategorieProduit(cp);
    }
    @GetMapping("/{idCategorieProduit}")
    public CategorieProduit retrieveCategorieProduit (@PathVariable Long idCategorieProduit){
        return iCategorieService.retrieveCategorieProduit(idCategorieProduit);
    }
    @DeleteMapping("/delete/{idCategorieProduit}")
    public void removeCategorieProduit(@PathVariable Long idCategorieProduit){
        iCategorieService.removeCategorieProduit(idCategorieProduit);
    }
}
