package com.example.ahmedderouichespringboot.services;

import com.example.ahmedderouichespringboot.entity.Produit;
import com.example.ahmedderouichespringboot.entity.SecteurActivite;
import com.example.ahmedderouichespringboot.entity.Stock;
import com.example.ahmedderouichespringboot.repository.SecteurAcitiviteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SecteurActiviteServiceImpl implements ISecteurActiviteService {
    @Autowired
    SecteurAcitiviteRepository secteurAcitiviteRepository;
    @Override
    public List<SecteurActivite> retrieveAllSecteurActivites() {
        return secteurAcitiviteRepository.findAll();
    }

    @Override
    public SecteurActivite addSecteurActivite(SecteurActivite sa) {
        try {
            return secteurAcitiviteRepository.save(sa);
        } catch (Exception E) {
            System.out.println("Erreur  : " + E);
        }
        return sa;
    }

    @Override
    public SecteurActivite updateSecteurActivite(SecteurActivite sa) {
        try {
            SecteurActivite secteurActivite=secteurAcitiviteRepository.findById(sa.getIdSecteurActivite()).get();
            return secteurAcitiviteRepository.save(sa);
        } catch (Exception E) {
            System.out.println("Erreur : " + E);
        }
        return sa;
    }

    @Override
    public SecteurActivite retrieveSecteurActivite(Long id) {
        try {
            return secteurAcitiviteRepository.findById(id).get();
        } catch (Exception E) {
            System.out.println("Erreur : " + E);
        }
        return null;
    }

    @Override
    public void removeSecteurActivite(Long id) {
        try {
            SecteurActivite secteurActivite=secteurAcitiviteRepository.findById(id).orElseThrow(ChangeSetPersister.NotFoundException::new);
            secteurAcitiviteRepository.delete(secteurActivite);
        } catch (Exception err) {
            System.out.println("Erreur : " + err);
        }

    }
}
