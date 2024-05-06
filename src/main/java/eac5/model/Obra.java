/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eac5.model;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * Obra d'art
 * @author joan
 */

@Entity   
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="tipus_obra")
// TODO afegir les anotacions Lombok
@Data
@AllArgsConstructor
@NoArgsConstructor

public abstract class Obra implements Serializable {

    public static final String PERFECTE = "Perfecte";
    @Id
    private int id;
    private String nom;
    private String autor;
    private double valor;
    private LocalDate dataRestauracio;
    private String estat;
    private LocalDate dataRevisio;
    private double amplada;
    private double alcada;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn        
    private Museu museu;


   @Override
   public int hashCode() {
        int hash = 7;
        hash = 47 * hash + this.id;
        hash = 47 * hash + Objects.hashCode(this.nom);
        hash = 47 * hash + Objects.hashCode(this.autor);
        hash = 47 * hash + (int) (Double.doubleToLongBits(this.valor) ^ (Double.doubleToLongBits(this.valor) >>> 32));
        hash = 47 * hash + Objects.hashCode(this.dataRestauracio);
        hash = 47 * hash + Objects.hashCode(this.estat);
        hash = 47 * hash + Objects.hashCode(this.dataRevisio);
        hash = 47 * hash + (int) (Double.doubleToLongBits(this.amplada) ^ (Double.doubleToLongBits(this.amplada) >>> 32));
        hash = 47 * hash + (int) (Double.doubleToLongBits(this.alcada) ^ (Double.doubleToLongBits(this.alcada) >>> 32));
        hash = 47 * hash + Objects.hashCode(this.museu);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Obra other = (Obra) obj;
        if (this.id != other.id) {
            return false;
        }
        if (Double.doubleToLongBits(this.valor) != Double.doubleToLongBits(other.valor)) {
            return false;
        }
        if (Double.doubleToLongBits(this.amplada) != Double.doubleToLongBits(other.amplada)) {
            return false;
        }
        if (Double.doubleToLongBits(this.alcada) != Double.doubleToLongBits(other.alcada)) {
            return false;
        }
        if (!Objects.equals(this.nom, other.nom)) {
            return false;
        }
        if (!Objects.equals(this.autor, other.autor)) {
            return false;
        }
        if (!Objects.equals(this.estat, other.estat)) {
            return false;
        }
        if (!Objects.equals(this.dataRestauracio, other.dataRestauracio)) {
            return false;
        }
        if (!Objects.equals(this.dataRevisio, other.dataRevisio)) {
            return false;
        }
        return Objects.equals(this.museu.getId(), other.museu.getId());
    }

}
