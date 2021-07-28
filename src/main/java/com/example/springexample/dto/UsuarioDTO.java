/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.springexample.dto;

import com.example.springexample.models.UsuarioModel;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author rsaldana
 */
public class UsuarioDTO {
    
    private Long usuario_id;
    private String nombre;
    private String apellido;
    private Integer edad;
    
    private List<ContactoDTO> contactos;
    
    public static UsuarioDTO ToDTO(UsuarioModel usuarioModel) {
        return new UsuarioDTO(usuarioModel);
    }
    
    public UsuarioDTO(UsuarioModel usuarioModel) {
        this.usuario_id = usuarioModel.getId();
        this.nombre = usuarioModel.getNombre();
        this.apellido = usuarioModel.getApellido();
        this.edad = usuarioModel.getEdad();
        
        this.contactos = usuarioModel.getContactos().stream()
//                .map(ContactoDTO::toDTO)
                .map(c -> ContactoDTO.toDTO(c))
                .collect(Collectors.toList());
        
    }

    public Long getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(Long usuario_id) {
        this.usuario_id = usuario_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public List<ContactoDTO> getContactos() {
        return contactos;
    }

    public void setContactos(List<ContactoDTO> usuarios) {
        this.contactos = usuarios;
    }
    
    
    
    
}
