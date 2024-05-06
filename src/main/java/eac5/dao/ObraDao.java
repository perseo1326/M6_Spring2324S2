/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eac5.dao;

import eac5.gestors.GestorException;
import eac5.model.Obra;
import eac5.repository.EsculturaRepository;
import eac5.repository.MuseuRepository;
import eac5.repository.ObraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

/**
 * Component DAO per manegar els objectes de la classe Obra a la base de dades
 *
 * @author docent
 */
//TODO Afegir anotacions d'SpringBoot
@Component
public class ObraDao {

    @Autowired
    private ObraRepository obraRepository;

    @Autowired
    private EsculturaRepository esculturaRepository;

    @Autowired
    private MuseuRepository museuRepository;

    /**
     * Insereix una obra
     *
     * @param obra obra a inserir
     * @throws GestorException si l'identificador ja existeix o l'identificador
     *                         de museu no existeix
     */
    public void inserir(Obra obra) throws GestorException {

        if (!obraRepository.existsById(obra.getId())) {

            if (museuRepository.existsById(obra.getMuseu().getId())) {
                obraRepository.save(obra);
            } else {
                throw new GestorException("Museu inexistent");
            }
        } else {
            throw new GestorException("Clau duplicada");
        }

    }

    /**
     * Elimina una obra de la base de dades
     *
     * @param id l'identificador de la obra
     * @throws GestorException si l'obra no existeix
     */

    public void elimina(int id) throws GestorException {

//        TODO: mejora en la validacion
        if (!obraRepository.existsById(id)) {
            throw new GestorException("Clau inexistent");
        }

        obraRepository.deleteById(id);
    }

        /**
         * Consulta de totes les obres
         *
         * @return la llista d'obres
         */
        public List<Obra> consultaObres() {
            return obraRepository.findAll();
        }


        /**
         * Obtenir les obres d'un museu
         *
         * @param idMuseu l'identificador del museu
         * @return la llista d'obres del musueu indicat
         * @throws GestorException si el museu no existeix
         */
        public List<Obra> consultaTotesDe ( int idMuseu) throws GestorException {

//       if(museuRepository.existsById(idMuseu)){
//            return obraRepository.findByMuseumId(idMuseu);
//       }else {
//           throw new GestorException("Clau inexistent");
//       }
            return null;
        }
        /**
         * Actualitza la data de restauració d'una obra. L'estat passa a ser
         * Obra.PERFECTE
         *
         * @param idObra identificador obra a actualitzar
         * @param data nova data de restauració
         *
         */
        public void actualitzaDataRestauracio ( int idObra, LocalDate data) throws GestorException {
//        if(obraRepository.existsById(idObra)){
//            obraRepository.restore(idObra, data);
//        }else{
//              throw new GestorException("Clau inexistent");
//        }
        }

        /**
         * Converteix les mides alcada i amplada de totes les obres de cm a m
         */
        public void convertirCmAm () {
//        obraRepository.convert2DUnits();
            // TODO
            // esculturaRepository.convertDepthUnits();

        }

        /**
         * Incrementa el valor de totes les obres d'un autor en un percentatge
         *
         * @param autor el nom de l'autor
         * @param percentatge el percentatge d'increment
         */
        public void revalora (String autor,int percentatge){
//        obraRepository.increasesValue(autor,percentatge);
        }

    }
