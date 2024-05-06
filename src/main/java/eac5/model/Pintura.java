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
import java.util.Objects;

/**
 * Pintura
 * @author joan
 */

@Entity
// @Table( name="Pintura")
@DiscriminatorValue("P")
// TODO afegir les anotacions Lombok
@Data
@NoArgsConstructor

public class Pintura extends Obra{
    private String tipusPintura;
    private String suport;
    
    /**
     * Pintura
     * @param id identificador de la pintura
     * @param nom nom de la pintura
     * @param autor autor de la pintura
     * @param valor valor de la pintura
     * @param dataRestauracio data de la darrera restauracio de la pintura
     * @param estat estat de conservacio de la pintura
     * @param dataRevisio data de la darrera revisio de la pintura
     * @param amplada amplada de la pintura
     * @param alcada alcada de la pintura
     * @param museu museu on es la pintura
     * @param tipusPintura tipius de pintura
     * @param suport suport on s'ha fet la pintura
     */

    public Pintura(int id, String nom, String autor, double valor, LocalDate dataRestauracio, String estat, LocalDate dataRevisio, double amplada, double alcada, Museu museu, String tipusPintura, String suport) {
        super(id, nom, autor, valor, dataRestauracio, estat, dataRevisio, amplada, alcada, museu);
        this.tipusPintura = tipusPintura;
        this.suport = suport;
    }
    

    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.tipusPintura);
        hash = 23 * hash + Objects.hashCode(this.suport);
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

        final Pintura other = (Pintura) obj;
        if (!Objects.equals(this.tipusPintura, other.tipusPintura)) {
            return false;
        }
        return Objects.equals(this.suport, other.suport);
    }
    
}
