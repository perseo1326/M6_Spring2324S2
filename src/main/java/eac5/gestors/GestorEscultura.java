/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eac5.gestors;

import eac5.dao.EsculturaDao;
import eac5.model.Escultura;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Classe que manega els objectes de la classe Escultura a la base de dades
 * @author joan
 */



@Component
public class GestorEscultura {

    // TODO: adicionar private
    @Autowired
    private EsculturaDao esculturaDao;

    
    /**
     * Obtenir totes les escultures
     *
     * @return una llista amb totes les escultures
     */
   
    public List<Escultura> consultaEscultures() {

        // return esculturaDao.consultaTotes();
        return null;
    }
    
    
    /**
     * Obtenir totes les escultures amb una pes superior a un de donat
     * @param minPes el pes minim de l'escultura
     * @return la llista d'esculturess amb el pes minim seleccionat
     */
    public List<Escultura> consultaEscultures(double minPes) {
        // return esculturaDao.consultaMesPesadesQue(minPes);
        return null;
    }    
    
}