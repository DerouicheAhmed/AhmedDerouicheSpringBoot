package com.example.ahmedderouichespringboot.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Facture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long idFacture;
    private float montantRemise;
    private float montantFacture;
    private Date dateCreactionFacture;
    private Date dateDerniereModification;
    private boolean archive;
    @OneToMany(mappedBy="facture",cascade = CascadeType.ALL)
    @JsonIgnoreProperties("facture")
    private Set<DetailFacture> detailFactures;
    @OneToMany(mappedBy="facture")
    @JsonIgnoreProperties("facture")
    private Set<Reglement> reglements;
    @ManyToOne
    @JsonIgnoreProperties("factures")
    private Fournisseur fournisseur;




}
