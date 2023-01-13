/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.js.jis.Repository;

import com.js.jis.Entity.Proyectos;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jsajn
 */
@Repository
public interface RProyectos extends JpaRepository<Proyectos, Integer>{
    
    public Optional<Proyectos> findByNombreE(String nombreE);
    public boolean existsByNombreE(String nombreE);
    
}