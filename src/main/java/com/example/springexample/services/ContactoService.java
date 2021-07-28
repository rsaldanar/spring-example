/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.springexample.services;

import com.example.springexample.models.ContactoModel;
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
public class ContactoService {

    @Autowired
    ContactoRepository contactoRepository;
    
    

    public ArrayList<ContactoModel> obtenerContacto() {// para obtener los datos de la tabla contacto.
        return (ArrayList<ContactoModel>) contactoRepository.findAll();
    }

    public ContactoModel salvarContacto(ContactoModel contactoModel) {// Guarda los datos en la tabla contacto.
                return contactoRepository.save(contactoModel);

    }

    public Optional<ContactoModel> obtenerContactoPorId(Long idContacto) {
        return contactoRepository.findById(idContacto);
    }

    public ArrayList<ContactoModel> obtenerContactoPorTelefono(Integer telefono) {
        return contactoRepository.findByTelefono(telefono);
    }

    public ArrayList<ContactoModel> optenerContactoPorMail(String mail) {
        return contactoRepository.findByMail(mail);
    }
    
    public boolean eliminarContactoPorId(Long contacto_id){
        try {
            contactoRepository.deleteById(contacto_id);
            return true;
            
        } catch (Exception e) {
            return false;
        }
    }
    
}
