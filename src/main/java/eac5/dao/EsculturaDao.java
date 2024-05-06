/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eac5.dao;

import eac5.model.Escultura;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import eac5.repository.EsculturaRepository;

/**
 * Component DAO per manegar els objectes de la classe Escultura a la base de dades
 * @author docent
 */

//TODO Afegir anotacions d'SpringBoot
@Component
public class EsculturaDao {
   
    @Autowired
    private EsculturaRepository esculturaRepository;
    
    /**
     * Obtenir totes les escultures
     *
     * @return una llista amb totes les escultures
     */
    public List<Escultura> consultaTotes() {

        return esculturaRepository.findAll();
    }
    
    /**
     * Obtenir totes les escultures amb una pes superior a un de donat
     * @param minPes el pes minim de l'escultura
     * @return la llista d'esculturess amb el pes minim seleccionat
     */
    public List<Escultura> consultaMesPesadesQue(double minPes) {

        // return esculturaRepository.findHeavierThan(minPes);
        return null;
    }
    
    
}
