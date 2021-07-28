/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.springexample.repositories;

import com.example.springexample.models.UsuarioModel;
import java.util.ArrayList;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author rsaldana
 */
@Repository
public interface UsuarioRepository extends CrudRepository<UsuarioModel, Long>{
    //Debe tener un endpoint de busqueda por nombre o apellido, telefono y correo electronico.
       public abstract ArrayList<UsuarioModel> findByNombre(String nombre);
       public abstract ArrayList<UsuarioModel> findByApellido(String apellido);
}
