package com.example.ahmedderouichespringboot.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduit;
    private String CodeProduit;
    private String liblleProduit;
    private float Prix;
    private Date DateCreation;
    private Date dateDerniereModification;
    @ManyToOne
    private Stock stock;
    @OneToMany(mappedBy = "produit")
    private Set<DetailFacture> detailFactures ;
    @ManyToOne
    private CategorieProduit categorieProduit;

}
