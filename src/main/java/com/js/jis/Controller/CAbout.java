/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.js.jis.Controller;

import com.js.jis.Dto.dtoAbout;
import com.js.jis.Entity.About;
import com.js.jis.Security.Controller.Mensaje;
import com.js.jis.Service.SAbout;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jsajn
 */
@RestController
@RequestMapping("/about")
@CrossOrigin(origins = "https://front-end-argentina-programajs.web.app")
public class CAbout {
    @Autowired
    SAbout sAbout;
    
    @GetMapping("/lista")
    public ResponseEntity<List<About>>list(){
        List<About> list = sAbout.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
     @GetMapping("/detail/{id}")
    public ResponseEntity<About> getById(@PathVariable("id")int id){
        if(!sAbout.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }
        
       About about = sAbout.getOne(id).get();
        return new ResponseEntity(about, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!sAbout.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        sAbout.delete(id);
        return new ResponseEntity(new Mensaje("Educacion eliminada"), HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoAbout dtoabout){
        if(StringUtils.isBlank(dtoabout.getNombreE())){
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if(sAbout.existsByNombreE(dtoabout.getNombreE())){
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        
        About about = new About(
                dtoabout.getNombreE(), dtoabout.getDescripcionE()
            );
        sAbout.save(about);
        return new ResponseEntity(new Mensaje("About me creado"), HttpStatus.OK);
                
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoAbout dtoabout){
        if(!sAbout.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        if(sAbout.existsByNombreE(dtoabout.getNombreE()) && sAbout.getByNombreE(dtoabout.getNombreE()).get().getId() != id){
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoabout.getNombreE())){
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }
        
        About about = sAbout.getOne(id).get();
        
        about.setNombreE(dtoabout.getNombreE());
        about.setDescripcionE(dtoabout.getDescripcionE());
        
        sAbout.save(about);
        
        return new ResponseEntity(new Mensaje("About me actualizado"), HttpStatus.OK);
    }
}