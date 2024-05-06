/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eac5.gestors;

import eac5.dao.ObraDao;
import eac5.model.Obra;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Classe per manegar els objectes de la classe Obra que son a la base de dades
 * @author joan
 */


@Component
public class GestorObra {

    @Autowired
    ObraDao obraDao;


    /**
     * Insereix una obra
     *
     * @param obra obra a inserir
     * @throws GestorException si l'identificador ja existeix o l'identificador
     * de museu no existeix
     */
    public void inserir(Obra obra) throws GestorException {


         obraDao.inserir(obra);
    }

    /**
     * Elimina una obra de la base de dades
     *
     * @param id l'identificador de la obra
     * @throws GestorException si l'obra no existeix
     */
    public void eliminar(int id) throws GestorException {
         obraDao.elimina(id);
    }

    /**
     * Consulta de totes les obres
     *
     * @return la llista d'obres
     */
    public List<Obra> consultaObres() {
         return obraDao.consultaObres();
    }

    /**
     * Obtenir les obres d'un museu
     *
     * @param idMuseu l'identificador del museu
     * @return la llista d'obres del museu indicat
     * @throws GestorException si el museu no existeix
     */
    public List<Obra> consultaObres(int idMuseu) throws GestorException {
        // return obraDao.consultaTotesDe(idMuseu);
        return null;
    }

    /**
     * Actualitza la data de restauració d'una obra. L'estat passa a ser
     * Obra.PERFECTE
     *
     * @param id identificador obra a actualitzar
     * @param data nova data de restauració
     *
     */
    public void actualitzaDataRestauracio(int id, LocalDate data) throws GestorException {
        // obraDao.actualitzaDataRestauracio(id, data);
    }

    /**
     * Converteix totes l'amplada i l'alcada de totes les obres de cm a m
     */
    public void convertirCmAm() {
        // obraDao.convertirCmAm();
    }

    /**
     * Incrementa el valor de totes les obres d'un autor en un percentatge
     *
     * @param autor el nom de l'autor
     * @param percentatge el percentatge d'increment
     */
    public void revalora(String autor, int percentatge) {
        // obraDao.revalora(autor, percentatge);
    }
}