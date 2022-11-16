package com.example.ahmedderouichespringboot.controller;

import com.example.ahmedderouichespringboot.entity.CategorieProduit;
import com.example.ahmedderouichespringboot.entity.Operateur;
import com.example.ahmedderouichespringboot.services.ICategorieService;
import com.example.ahmedderouichespringboot.services.IOperateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/operateur")
@RestController
public class OperateurController {
    @Autowired
    IOperateurService iOperateurService;
    @GetMapping()
    public List<Operateur> retrieveAllOperateurs() {
        return iOperateurService.retrieveAllOperateurs();
    }
    @PostMapping("/add")
    public  Operateur addOperateur  (@RequestBody Operateur op ){
        return iOperateurService.addOperateur(op);
    }
    @PutMapping("/edit")
    public Operateur updateOperateur (Operateur o){
        return iOperateurService.updateOperateur(o);
    }
    @GetMapping("/{idOperateur}")
    public Operateur retrieveOperateur (@PathVariable Long idOperateur){
        return iOperateurService.retrieveOperateur(idOperateur);
    }
    @DeleteMapping("/delete/{idOperateur}")
    public void removeOperateur(@PathVariable Long idOperateur){
        iOperateurService.removeOperateur(idOperateur);
    }
}
