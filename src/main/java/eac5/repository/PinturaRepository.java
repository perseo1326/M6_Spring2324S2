/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package eac5.repository;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */


import eac5.model.Pintura;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author docent
 */

@Repository
public interface PinturaRepository extends JpaRepository<Pintura,Long> {
    /**
     * Retorna totes les pintures amb una superficie entre dos valors determinats, ambdos inclosos
     * @param minSup valor minim de la superficie de la pintura
     * @param maxSup valor maxim de la superficie de la pintura
     * @return la llista de les pintures seleccionades
     */    
    @Query(value="select p from Pintura p where p.alcada*p.amplada between :minSup and :maxSup")
    List<Pintura> findAllWithWithSurfaceBetween(@Param("minSup")double minSup, @Param("maxSup") double maxSup);
} 
