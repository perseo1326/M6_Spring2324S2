/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eac5.gestors;

import eac5.dao.MuseuDao;
import eac5.dao.ObraDao;
import eac5.model.Museu;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Classe per manegar els objectes de la classe Museu a la base de dades
 * @author joan
 */


@Component
public class GestorMuseu {

    @Autowired
    private MuseuDao museuDao;
    
    @Autowired
    private ObraDao obraDao;


    /**
     * Insereix un nou museu a la base de dades
     *
     * @param museu el museu a afegir
     * @throws GestorException si el museu ja existeix
     */
    public void inserir(Museu museu) throws GestorException {
 

        // museuDao.inserir(museu);
    }

    /**
     * Elimina un museu de la base de dades
     *
     * @param id l'identificador del museu
     * @throws GestorException si el museu no existeix
     */
    public void eliminar(int id) throws GestorException {

    //    museuDao.eliminar(id);
    }
    
    
    /**
     * Obtenir tots els museus
     *
     * @return la llista amb les museus
     */

    public List<Museu> consultaMuseus() {

    //    return museuDao.consultaTots();
        return null;
    }

    /**
     * Obtenir tots els museus d'una ciutat
     *
     * @param ciutat el nom de la ciutat
     * @return la llista amb les museus de la ciutat indicada
     */

    public List<Museu> consultaMuseus(String ciutat) {

    //    return museuDao.consultaTotsDe(ciutat);
        return null;
    }

    /**
     * Actualitza la data de revisió de totes les obres d'un museu
     *
     * @param id id del museu del qual se'n revisaran les obres
     * @param data nova data revisio de les obres
     * @throws eac3.gestors.GestorException si no hi ha cap museu amb l'identificador indicat
     */
    public void actualitzaDataRevisio(int id, LocalDate data) throws GestorException {
        // museuDao.actualitzaDataRevisio(id,data);
    }

}
