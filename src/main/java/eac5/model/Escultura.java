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
 * Obra d'art del tipus escultura
 * @author joan
 */

@Entity
@DiscriminatorValue("E")
// TODO afegir les anotacions Lombok
@Data
@NoArgsConstructor

public class Escultura extends Obra {

    private double profunditat;
    private String material;
    private String base;
    private double pes;
    
    /**
     * Crea una escultura
     * @param id identificador de l'escultura
     * @param autor autor de l'escultura
     * @param valor valor de l'escultura
     * @param dataRestauracio data de l'ultima restauració de l'escultura
     * @param estat estat de l'escultura
     * @param dataRevisio data de la darrera revisio de l'escultura
     * @param amplada amplada de l'escultura
     * @param alcada alcada de l'escultura
     * @param museu museu on es l'escultura
     * @param profunditat profunditat de l'escultura
     * @param material material principal de l'escultura
     * @param base tipius de base de l'escultura
     * @param pes pes de l'escultura
     */

    public Escultura(int id, String nom, String autor, double valor, LocalDate dataRestauracio,
            String estat, LocalDate dataRevisio, double amplada, double alcada, Museu museu,
            double profunditat, String material, String base, double pes) {
        super(id, nom, autor, valor, dataRestauracio, estat, dataRevisio, amplada, alcada, museu);
        this.profunditat = profunditat;
        this.material = material;
        this.base = base;
        this.pes = pes;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + Objects.hashCode(this.profunditat);
        hash = 19 * hash + Objects.hashCode(this.material);
        hash = 19 * hash + Objects.hashCode(this.base);
        hash = 19 * hash + (int) (Double.doubleToLongBits(this.pes) ^ (Double.doubleToLongBits(this.pes) >>> 32));
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

        final Escultura other = (Escultura) obj;
        if (Double.doubleToLongBits(this.pes) != Double.doubleToLongBits(other.pes)) {
            return false;
        }
        if (!Objects.equals(this.material, other.material)) {
            return false;
        }
        if (!Objects.equals(this.base, other.base)) {
            return false;
        }
        return Objects.equals(this.profunditat, other.profunditat);
    }
}


