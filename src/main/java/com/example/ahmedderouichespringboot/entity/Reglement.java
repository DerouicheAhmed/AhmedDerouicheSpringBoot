package com.example.ahmedderouichespringboot.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Reglement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private  Long idReglement;
    private float montantPaye;
    private float montantRestant;
    private boolean payee;
    private Date dateReglement;
    @ManyToOne
    @JsonIgnoreProperties("reglements")
    private Facture facture;
}
