/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.springexample.dto;

import com.example.springexample.models.ContactoModel;

/**
 *
 * @author rsaldana
 */
public class ContactoDTO {
    
    private Long contact_id;
    private String telefono;
    private String direccion;
    private String mail;
    
    public ContactoDTO(ContactoModel contactoModel) {
        this.contact_id = contactoModel.getIdContacto();
        this.telefono = contactoModel.getTelefono();
        this.direccion = contactoModel.getDireccion();
        this.mail = contactoModel.getMail();
    }
    
    public static ContactoDTO toDTO(ContactoModel contactoModel) {
        return new ContactoDTO(contactoModel);
    }

    public Long getContact_id() {
        return contact_id;
    }

    public void setContact_id(Long contact_id) {
        this.contact_id = contact_id;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
    
    
}
