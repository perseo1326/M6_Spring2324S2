/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package eac5.repository;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */



import eac5.model.Escultura;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

/**
 * Repository per manegar els objectes de la classe Escultura a la base de dades
 * @author docent
 */

//TODO Completar la interfície
public interface EsculturaRepository extends JpaRepository<Escultura,Long> {

    /**
     * Retorna una llista amb totes les escultures amb un pes superior a minPes
     * @param minPes límit inferior als pesos de les escultures, sense incloure'l
     * @return la llista de les escultures amb el pes demanat
     */
    // List <Escultura> findHeavierThan(@Param("minPes")double minPes);   

    /**
     * Converteix la profunditat de totes les escultures de cm a metres
     */
    // void convertDepthUnits();

} 
