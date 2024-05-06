/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package eac5.repository;

import eac5.model.Museu;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

/**
 * Repositori per manegar els objectes de la classe Museu a la base de dades
 * @author docent
 */
//TODO Completar la interfície
public interface MuseuRepository extends JpaRepository<Museu,Integer> {
    /**
     * retorna els museus d'una ciutat
     * @param ciutat nom de la ciutat
     * @return llista de les estacions
     */
    List<Museu>findByCityName(@Param("ciutat")String ciutat);  
    
    /**
     * Actualitza la data de revisió de totes les obres d'un museu
     *
     * @param idMuseu id del museu a actaulitzar
     * @param data nova data de revisio de les obres del museu
     */
    void updateArtWork(@Param("idMuseu")int idMuseu, @Param("novaData")LocalDate data);    
    
}
