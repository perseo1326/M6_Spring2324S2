/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eac5.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

/**
 * Museu
 * @author joan
 */

@Entity
// TODO afegir les anotacions Lombok
@Setter
@Getter
@Data
@NoArgsConstructor
public class Museu implements Serializable {
    @Id
    private int id;
    private String nom;  
    private String ciutat;

    @OneToMany(mappedBy="museu", cascade = CascadeType.ALL,fetch = FetchType.LAZY, orphanRemoval=true)
    private List<Obra> obres = new ArrayList<>();

    /**
     * Crea un Museu a partir dels seus identificador, nom i ciutat
     * @param id identificador del museu
     * @param nom nom del museu
     * @param ciutat ciutat on es esl museu
     */
    public Museu(int id, String nom, String ciutat) {
        this.id = id;
        this.nom = nom;
        this.ciutat = ciutat;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + this.id;
        hash = 67 * hash + Objects.hashCode(this.nom);
        hash = 67 * hash + Objects.hashCode(this.ciutat);
        hash = 67 * hash + Objects.hashCode(this.obres);
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
        final Museu other = (Museu) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.nom, other.nom)) {
            return false;
        }
        if (!Objects.equals(this.ciutat, other.ciutat)) {
            return false;
        }
        this.obres.sort(Comparator.comparingLong(Obra::getId));
        other.obres.sort(Comparator.comparingLong(Obra::getId));
        return Objects.equals(this.obres, other.obres);
    }

}