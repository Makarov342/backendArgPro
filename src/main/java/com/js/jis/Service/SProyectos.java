/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.js.jis.Service;

import com.js.jis.Entity.Proyectos;
import com.js.jis.Repository.RProyectos;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jsajn
 */
@Service
@Transactional
public class SProyectos {
    @Autowired
    RProyectos rProyectos;
    
    
    
    public List<Proyectos> list(){
        return rProyectos.findAll();
    }
    
    public Optional<Proyectos>getOne(int id){
        return rProyectos.findById(id);
    }
    
    public  Optional<Proyectos> getByNombreE(String nombreE){
        return rProyectos.findByNombreE(nombreE);
    }
    public void save(Proyectos proyectos){
       rProyectos.save(proyectos);
    }
    
    public void delete(int id){
        rProyectos.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rProyectos.existsById(id);
    }
    public boolean existsByNombreE(String nombreE){
        return rProyectos.existsByNombreE(nombreE);
    }
}