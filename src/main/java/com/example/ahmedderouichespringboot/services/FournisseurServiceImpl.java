package com.example.ahmedderouichespringboot.services;

import com.example.ahmedderouichespringboot.entity.CategorieProduit;
import com.example.ahmedderouichespringboot.entity.Fournisseur;
import com.example.ahmedderouichespringboot.repository.FournisseurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FournisseurServiceImpl implements IFournisseurService {
    @Autowired
    FournisseurRepository fournisseurRepository;
    @Override
    public List<Fournisseur> retrieveAllFournisseurs() {
        return fournisseurRepository.findAll();
    }

    @Override
    public Fournisseur addFournisseur(Fournisseur f) {
        try {
            return fournisseurRepository.save(f);
        } catch (Exception E) {
            System.out.println("Erreur  : " + E);
        }
        return f;
    }

    @Override
    public Fournisseur updateFournisseur(Fournisseur f) {
        try {
            Fournisseur fournisseur=fournisseurRepository.findById(f.getIdFournisseur()).get();
            return fournisseurRepository.save(f);
        } catch (Exception E) {
            System.out.println("Erreur : " + E);
        }
        return f;
    }

    @Override
    public Fournisseur retrieveFournisseur(Long id) {
        try {
            return fournisseurRepository.findById(id).get();
        } catch (Exception E) {
            System.out.println("Erreur : " + E);
        }
        return null;
    }
}
