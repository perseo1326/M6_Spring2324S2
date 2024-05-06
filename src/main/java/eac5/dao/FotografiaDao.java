/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eac5.dao;

import eac5.model.Fotografia;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import eac5.repository.FotografiaRepository;

/**
 * Component DAO per manegar els objectes de la classe Fotografia a la base de dades
 * @author docent
 */
//TODO Afegir anotacions d'SpringBoot
public class FotografiaDao {
    
    @Autowired
    private FotografiaRepository fotografiaRepository;
    
    /**
     * Consulta totes les fotografies
     *
     * @return la llista de fotografies
     */
    public List<Fotografia> consultaTotes() {

        return fotografiaRepository.findAll();
    }
    
    /**
     * Consulta totes les fotografies segons si tenen o no color
     *
     * @param color true si tenen color, false si no tenen color
     * @return llista de fotografies amb el color especificat
     */
    public List<Fotografia> consultaSegonsColor(boolean color) {

        return fotografiaRepository.findAllAccordingColor(color);
    }
    
    
}
