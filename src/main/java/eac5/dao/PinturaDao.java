/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eac5.dao;

import eac5.model.Pintura;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import eac5.repository.PinturaRepository;

/**
 * Component DAO per manegar els objectes de la classe Pintura a la base de dades
 * @author docent
 */
@Component
public class PinturaDao {
    @Autowired
    private PinturaRepository pinturaRepository;
    
   /**
     * Consulta de totes les pintures
     *
     * @return la llista de pintures
     */
    public List<Pintura> consultaPintures() {

        return pinturaRepository.findAll();
    }
    
   /**
     * Consulta de totes les pintures en un interval de superfície
     *
     * @param minSup superfície mínima de l'interval
     * @param maxSup superfície màxima de l'interval
     * @return llista de les pintures seleccionades
     */
    public List<Pintura> consultaPinturesPerSuperficie(double minSup, double maxSup) {
         return pinturaRepository.findAllWithWithSurfaceBetween(minSup, maxSup);
    }

    
    
}
