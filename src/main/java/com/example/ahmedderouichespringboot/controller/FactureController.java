package com.example.ahmedderouichespringboot.controller;

import com.example.ahmedderouichespringboot.entity.Facture;
import com.example.ahmedderouichespringboot.services.IFactureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping ("/facture")
@RestController
public class FactureController {
    @Autowired
    IFactureService iFactureService;
    @GetMapping()
    public List<Facture> retrieveAllFactures(){
        return iFactureService.retrieveAllFactures();
    }
    @DeleteMapping("/delete/{id}")
    public void cancelFacture(@PathVariable Long id){
        iFactureService.cancelFacture(id);
    }
    @GetMapping("/{id}")
    public Facture retrieveFacture(Long id){
        return iFactureService.retrieveFacture(id);
    }
    @PostMapping("/add")
    public Facture add(@RequestBody Facture facture){
        return iFactureService.add(facture);
    }
    @GetMapping("/findbyfournisseur/{idFournisseur}")
    List<Facture> getFacturesByFournisseur(@PathVariable Long idFournisseur){
        return iFactureService.getFacturesByFournisseur(idFournisseur);
    }
}
