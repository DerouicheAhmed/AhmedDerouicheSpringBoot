package com.example.ahmedderouichespringboot.services;

import com.example.ahmedderouichespringboot.entity.Facture;
import com.example.ahmedderouichespringboot.entity.Fournisseur;
import com.example.ahmedderouichespringboot.repository.FactureRepository;
import com.example.ahmedderouichespringboot.repository.FournisseurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FactureServiceImpl implements IFactureService{
    @Autowired
    FactureRepository factureRepository;
    @Autowired
    FournisseurRepository fournisseurRepository;
    @Override
    public List<Facture> retrieveAllFactures() {
        return factureRepository.findAll();
    }

    @Override
    public void cancelFacture(Long id) {
        Facture facture=factureRepository.findById(id).orElse(null);
        if(facture!=null && facture.isArchive())
        {
            factureRepository.delete(facture);
        }

    }

    @Override
    public Facture add(Facture f) {
        return factureRepository.save(f);
    }

    @Override
    public Facture retrieveFacture(Long id) {
        return factureRepository.findById(id).orElse(null);
    }

    @Override
    public List<Facture> getFacturesByFournisseur(Long idFournisseur) {
        return factureRepository.findByFournisseur_IdFournisseur(idFournisseur);
    }


}
