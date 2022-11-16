package com.example.ahmedderouichespringboot.services;

import com.example.ahmedderouichespringboot.entity.Facture;
import com.example.ahmedderouichespringboot.entity.Operateur;
import com.example.ahmedderouichespringboot.entity.Stock;
import com.example.ahmedderouichespringboot.repository.FactureRepository;
import com.example.ahmedderouichespringboot.repository.OperateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OperateurServiceImpl implements IOperateurService {
    @Autowired
    OperateurRepository operateurRepository;
    FactureRepository factureRepository;

    @Override
    public List<Operateur> retrieveAllOperateurs() {
        return operateurRepository.findAll();

    }

    @Override
    public Operateur addOperateur(Operateur o) {
        try {
            return operateurRepository.save(o);
        } catch (Exception E) {
            System.out.println("Erreur  : " + E);
        }
        return o;
    }

    @Override
    public Operateur updateOperateur(Operateur o) {
        try {
            Operateur operateur=operateurRepository.findById(o.getIdOperateur()).get();
            return operateurRepository.save(o);
        } catch (Exception E) {
            System.out.println("Erreur : " + E);
        }
        return o;
    }

    @Override
    public Operateur retrieveOperateur(Long id) {
        try {
            return operateurRepository.findById(id).get();
        } catch (Exception E) {
            System.out.println("Erreur : " + E);
        }
        return null;
    }

    @Override
    public void removeOperateur(Long id) {
        try {
            Operateur operateur=operateurRepository.findById(id).orElseThrow(ChangeSetPersister.NotFoundException::new);
            operateurRepository.delete(operateur);
        } catch (Exception err) {
            System.out.println("Erreur : " + err);
        }

    }

    @Override
    public void assignOperateurToFacture(Long idOperateur, Long idFacture) {
        Operateur operateur=operateurRepository.findById(idOperateur).orElse(null);
        Facture facture=factureRepository.findById(idFacture).orElse(null);
        if(operateur!=null && facture!=null)
        {
            operateur.getFactures().add(facture);
            operateurRepository.save(operateur);
        }
    }
}
