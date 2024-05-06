/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package eac5.repository;

import eac5.model.Obra;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Repository per manegar els objectes de la classe Obra que son a la base de dades
 * @author docent
 */
//TODO Completar la interfície
@Repository
public interface ObraRepository extends JpaRepository<Obra,Integer> {
    /**
     * Retorna la llista de les obres d'un museu
     * @param idMuseu identificador del museu on son les obres
     * @return llista de les obres del museu indicat
     */
//    List<Obra> findByMuseumId(@Param("idMuseu")int idMuseu);
    
    
    /**
     * Actualitza la data de restauració d'una obra. L'estat passa a ser
     * Obra.PERFECTE
     * @param idObra identificador de l'obra restaurada
     * @param data  data de restauracio de l'obra
     */
//    void restore(@Param("idObra") int idObra, @Param("novaData") LocalDate data);

    /**
     *  Converteix l'amplada i l'alcada d'una obra de cm a metres
     */    
//    void convert2DUnits();
    
    /**
     * Incremetenta en un percentatge determinat el valor de les obres d'un autor
     * @param autor autor de les obres de les quals se n'actualitzara el valor
     * @param percentatge percentatge d'increment que s'aplicara a les obres indicades
     */  
//    void increasesValue(@Param("autor") String autor, @Param("percentatge") double percentatge);
    
}    

