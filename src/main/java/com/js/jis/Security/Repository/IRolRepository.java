/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.js.jis.Security.Repository;

import com.js.jis.Security.Entity.Rol;
import com.js.jis.Security.Enums.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jsajn
 */
@Repository
public interface IRolRepository extends JpaRepository<Rol, Integer>{
    Optional<Rol> findByRolNombre (RolNombre rol);
    
}
