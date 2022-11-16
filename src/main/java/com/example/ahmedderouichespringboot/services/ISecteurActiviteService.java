package com.example.ahmedderouichespringboot.services;

import com.example.ahmedderouichespringboot.entity.SecteurActivite;

import java.util.List;

public interface ISecteurActiviteService {
    List<SecteurActivite> retrieveAllSecteurActivites();

    SecteurActivite addSecteurActivite (SecteurActivite sa);

    SecteurActivite updateSecteurActivite (SecteurActivite sa);

    SecteurActivite retrieveSecteurActivite (Long id);

    void removeSecteurActivite (Long id);
}
