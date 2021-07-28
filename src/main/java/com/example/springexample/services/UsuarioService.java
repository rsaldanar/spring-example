/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.springexample.services;

import com.example.springexample.models.UsuarioModel;
import com.example.springexample.repositories.ContactoRepository;
import com.example.springexample.repositories.UsuarioRepository;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author rsaldana
 */
@Service
public class UsuarioService {
    
    @Autowired
    UsuarioRepository usuarioRepository;
    
    public ArrayList<UsuarioModel> obtenerUsuario(){// Para obtener toda la data de la tabla usuario
        return (ArrayList<UsuarioModel>) usuarioRepository.findAll();
    }
    
    public UsuarioModel guardarUsuario(UsuarioModel usuarioModel){//Guarda en la tabla contacto
        return usuarioRepository.save(usuarioModel);
    }
    
    public Optional<UsuarioModel> obtenerUsuarioPorId(Long id){
        return usuarioRepository.findById(id);
    }
    
    public ArrayList<UsuarioModel> obtenerUsuarioPorNombre(String nombre){
        return usuarioRepository.findByNombre(nombre);
    }
    
    public ArrayList<UsuarioModel> obtenerUsuarioPorApellido(String apellido){
        return usuarioRepository.findByApellido(apellido);
    }
    
    public boolean eliminarUsuarioPorId(Long usuario_id){
        try {
            usuarioRepository.deleteById(usuario_id);
            return true;
            
        } catch (Exception e) {
            return false;
        }
    }
    
}
