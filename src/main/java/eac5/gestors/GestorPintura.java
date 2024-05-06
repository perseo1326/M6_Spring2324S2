/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eac5.gestors;

import eac5.dao.PinturaDao;
import eac5.model.Pintura;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author joan
 */



@Component
public class GestorPintura {
    
    @Autowired
    PinturaDao pinturaDao;


    /**
     * Consulta totes les pintures
     * @return llista amb totes les pintures
     */
    public List<Pintura> consultaPintures() {

        // return pinturaDao.consultaPintures();
        return null;
    }

   /**
     * Consulta de totes les pintures en un interval de superfície
     *
     * @param minSup superfície mínima de l'interval
     * @param maxSup superfície màxima de l'interval
     * @return llista de pintures seleccionades
     */
    public List<Pintura> consultaPintures(double minSup, double maxSup) {

        // return pinturaDao.consultaPinturesPerSuperficie(minSup, maxSup);
        return null;
    }
}

