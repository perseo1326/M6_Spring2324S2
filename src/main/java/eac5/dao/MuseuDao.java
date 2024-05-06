/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eac5.dao;

import eac5.gestors.GestorException;
import eac5.model.Museu;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import eac5.repository.MuseuRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

/**
 * Component DAO per manegar els objectes de la classe Museu a la base de dades
 * @author docent
 */
//TODO Afegir anotacions d'SpringBoot
@Service
public class MuseuDao {
    
    @Autowired
    private MuseuRepository museuRepository;
    
    /**
     * Insereix un nou museu a la base de dades
     *
     * @param museu el museu a afegir
     * @throws GestorException si el museu ja existeix
     */
    public void inserir(Museu museu) throws GestorException {

       if(!museuRepository.existsById(museu.getId())){
           Museu x = museuRepository.save(museu);
           System.out.println("Museo ID: " + x.getId() +" NOMBRE: " + x.getNom());
       }else {
           System.out.println("Museo duplicado: (" + museu.getId() + ") " + museu.getNom());
           throw new GestorException("Clau duplicada");
       }
     
    }

    /**
     * Elimina un museu de la base de dades
     *
     * @param id l'identificador del museu
     * @throws GestorException si el museu no existeix
     */
    public void eliminar(int id) throws GestorException {

    //    if(museuRepository.existsById(id)){
    //         museuRepository.deleteById(id);
    //    }else {
    //        throw new GestorException("Clau inexistent");
    //    }      
    }

    /**
     * Obtenir tots els museus
     *
     * @return la llista amb les museus
     */
    public List<Museu> consultaTots() {
        return museuRepository.findAll();
    }

    /**
     * Obtenir tots els museus d'una ciutat
     *
     * @param ciutat el nom de la ciutat
     * @return la llista amb les museus de la ciutat indicada
     */
    public List<Museu> consultaTotsDe(String ciutat) {

        // return museuRepository.findByCityName(ciutat);
        return null;
    }

    /**
     * Actualitza la data de revisió de totes les obres d'un museu. 
     *
     * @param idMuseu id del museu del qual se'n revisaran les obres
     * @param data nova data revisio de les obres
     * @throws eac3.gestors.GestorException si no hi ha cap museu amb l'identificador indicat
     */
    // public void actualitzaDataRevisio(int idMuseu, LocalDate data) throws GestorException {

    //    if(museuRepository.existsById(idMuseu)){
    //         // museuRepository.updateArtWork(idMuseu, data);
    //    }else {
    //        throw new GestorException("Clau inexistent");
    //    }  
    // }
}
