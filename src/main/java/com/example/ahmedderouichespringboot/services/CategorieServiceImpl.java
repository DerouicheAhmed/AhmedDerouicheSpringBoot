package com.example.ahmedderouichespringboot.services;

import com.example.ahmedderouichespringboot.entity.CategorieProduit;
import com.example.ahmedderouichespringboot.repository.CategorieProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategorieServiceImpl implements ICategorieService{
    @Autowired
    CategorieProduitRepository categorieProduitRepository;
    @Override
    public List<CategorieProduit> retrieveAllCategorieProduits() {

        return categorieProduitRepository.findAll();
    }

    @Override
    public CategorieProduit addCategorieProduit(CategorieProduit cp) {
        try {
            return categorieProduitRepository.save(cp);
        } catch (Exception E) {
            System.out.println("Erreur  : " + E);
        }
        return cp;

    }

    @Override
    public CategorieProduit updateCategorieProduit(CategorieProduit cp) {
        try {
            CategorieProduit categorieProduit=categorieProduitRepository.findById(cp.getIdCategorieProduit()).get();
            return categorieProduitRepository.save(cp);
        } catch (Exception E) {
            System.out.println("Erreur : " + E);
        }
        return cp;

    }

    @Override
    public CategorieProduit retrieveCategorieProduit(Long id) {
        try {
            return categorieProduitRepository.findById(id).get();
        } catch (Exception E) {
            System.out.println("Erreur : " + E);
        }
        return null;

    }

    @Override
    public void removeCategorieProduit(Long id) {
        try {
            CategorieProduit categorieProduit=categorieProduitRepository.findById(id).orElseThrow(ChangeSetPersister.NotFoundException::new);
            categorieProduitRepository.delete(categorieProduit);
        } catch (Exception err) {
            System.out.println("Erreur : " + err);
        }

    }
}
