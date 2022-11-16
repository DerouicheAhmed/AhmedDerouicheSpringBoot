package com.example.ahmedderouichespringboot.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class DetailFacture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDetailFacture;
    private int qteCommandee;
    private float prixTotatlDetail;
    private int PourcentageRemise;
    private float montantRemise;
    @ManyToOne
    private Facture facture;
    @ManyToOne
    private Produit produit;

}
