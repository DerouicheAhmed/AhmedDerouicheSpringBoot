package com.example.ahmedderouichespringboot.controller;

import com.example.ahmedderouichespringboot.entity.Operateur;
import com.example.ahmedderouichespringboot.entity.SecteurActivite;
import com.example.ahmedderouichespringboot.services.ISecteurActiviteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/sect")
@RestController
public class SecteurActiviteController {
    @Autowired
    ISecteurActiviteService iSecteurActiviteService;
    @GetMapping()
    public List<SecteurActivite> retrieveAllSecteurActivites() {
        return iSecteurActiviteService.retrieveAllSecteurActivites();
    }
    @PostMapping("/add")
    public SecteurActivite addSecteurActivite  (@RequestBody SecteurActivite sa ){
        return iSecteurActiviteService.addSecteurActivite(sa);
    }
    @PutMapping("/edit")
    public   SecteurActivite updateSecteurActivite (@RequestBody SecteurActivite sa){
        return iSecteurActiviteService.updateSecteurActivite(sa);
    }
    @GetMapping("/{idSecteur}")
    public SecteurActivite retrieveSecteurActivite (@PathVariable Long idSecteur){
        return iSecteurActiviteService.retrieveSecteurActivite(idSecteur);
    }
    @DeleteMapping("/delete/{idSecteur}")
    public void removeSecteurActivite(@PathVariable Long idSecteur){
        iSecteurActiviteService.removeSecteurActivite(idSecteur);
    }
}
