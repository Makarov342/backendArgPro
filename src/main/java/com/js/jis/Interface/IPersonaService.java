/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.js.jis.Interface;

import com.js.jis.Entity.Persona;
import java.util.List;

/**
 *
 * @author jsajn
 */

public interface IPersonaService {
    //Traer una lista de personas
    public List<Persona> getPersona();
    //Guardar un objeto de tipo persona
    public void savePersona(Persona persona);
    //Eliminar un objeto por id
    public void deletePersona(Long id);
    //Buscar una persona por id
    public Persona findPersona(Long id);
}
