/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.springexample.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;

/**
 *
 * @author rsaldana
 */
@Entity
@Table(name = "contacto")
public class ContactoModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long contacto_id;
    
////    @Column(columnDefinition = "NUMERIC")
//    @Pattern(regexp = "[0-9]{10}", message = "Solo 10 valores Numericos")
    @Digits(integer = 10, fraction = 20, message = "SOLO NUMERO Y 10 DIGITOS.")
    private String telefono;
    
    private String direccion;
    @Email()
    private String mail;
    
    @ManyToOne
    @JoinColumn(name = "fk_usuario")
    private UsuarioModel usuario;

    public Long getIdContacto() {
        return contacto_id;
    }

    public void setIdContacto(Long idContacto) {
        this.contacto_id = idContacto;
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
    
    public UsuarioModel getUsuario() {
        return this.usuario;
    }
    
    public void setUsuario(UsuarioModel usuario) {
        this.usuario = usuario;
    }
    
    
    
    
}
