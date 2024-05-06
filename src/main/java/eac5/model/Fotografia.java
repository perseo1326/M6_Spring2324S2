/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eac5.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * Obra d'art del tipus fotografia
 * @author joan
 */

@Entity
@DiscriminatorValue("F")

// TODO afegir les anotacions Lombok
@Data
@NoArgsConstructor

public class Fotografia extends Obra {

    private boolean color;
    
    /**
     * Crea una fotografia
     * @param id identificador de la fotografia
     * @param nom nom de la fotografia
     * @param autor autor de la fotografia
     * @param valor valor de la fotografia
     * @param dataRestauracio data de la darrera restauracio de la fotografia
     * @param estat estat de conservacio de la fotografia
     * @param dataRevisio data de la darrera revisio de la fotografia
     * @param amplada amplada de la fotografia
     * @param alcada alcada de la fotografia
     * @param museu museu on es la fotografia
     * @param color cert si es una fotografia en color, fals si es una fotografia en blanc i negre
     */
    
    public Fotografia(int id, String nom, String autor, double valor, LocalDate dataRestauracio,
            String estat, LocalDate dataRevisio, double amplada, double alcada, Museu museu, boolean color) {
        super(id, nom, autor, valor, dataRestauracio, estat, dataRevisio, alcada, amplada, museu);
        this.color=color;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + (this.color ? 1 : 0);
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
        if (!super.equals(obj)) {
            return false;
        }

        final Fotografia other = (Fotografia) obj;
        return this.color == other.color;
    }

    
    
}
