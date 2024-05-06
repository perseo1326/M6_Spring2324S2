/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eac5.gestors;

import eac5.dao.FotografiaDao;
import eac5.model.Fotografia;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Classe per manegar els objectes de la classe Fotografia a la base de dades
 * @author joan
 */


@Component
public class GestorFotografia {
    
    
    @Autowired
    private FotografiaDao fotografiaDao;


    /**
     * Consulta totes les fotografies
     *
     * @return la llista de totes les fotografies
     */
    public List<Fotografia> consultaFotografies() {

      //  return fotografiaDao.consultaTotes();
      return null;
    }

    /**
     * Consulta totes les fotografies segons si tenen o no color
     *
     * @param color true si tenen color, false si no tenen color
     * @return llista de fotografies amb el color especificat
     */
    public List<Fotografia> consultaFotografies(boolean color) {
      //  return fotografiaDao.consultaSegonsColor(color);
       return null;
        
    }

}