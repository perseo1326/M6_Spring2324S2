/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package eac5.repository;

import eac5.model.Fotografia;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

/**
 * Repositori per manegar els objectes de la classe Fotografia a la base de dades
 * @author docent
 */
//TODO Completar la interfície
public interface FotografiaRepository extends JpaRepository<Fotografia,Long> {
    
    /**
     * Consulta totes les fotografies segons si tenen o no color
     *
     * @param color true si tenen color, false si no tenen color
     * @return llista de fotografies amb el color especificat
     */
    List<Fotografia> findAllAccordingColor(@Param("color")boolean color);    
}    
