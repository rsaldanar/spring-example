/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.springexample.controller;

import com.example.springexample.models.ContactoModel;
import com.example.springexample.repositories.ContactoRepository;
import com.example.springexample.services.ContactoService;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author rsaldana
 */
@RestController
@RequestMapping("/contacto")
public class ContactoController {

    @Autowired
    ContactoService contactoService;

    @Autowired
    ContactoRepository contactoRepository;

    @GetMapping()
    public ArrayList<ContactoModel> obtenerContacto() {
        return contactoService.obtenerContacto();
    }

    @PostMapping()
    public ContactoModel salvarContacto(@RequestBody @Validated ContactoModel contactoModel) {
        return this.contactoService.salvarContacto(contactoModel);
    }

    @GetMapping(path = "/{contacto_id}")
    public Optional<ContactoModel> obtenerContactoPorId(@PathVariable("contacto_id") Long idContacto) {
        return this.contactoService.obtenerContactoPorId(idContacto);
    }

    @GetMapping(path = "/telefono/{telefono}")
    public ArrayList<ContactoModel> obtenerContactoPoTelefono(@PathVariable("telefono") Integer telefono) {
        return this.contactoService.obtenerContactoPorTelefono(telefono);
    }

    @GetMapping(path = "/mail/{mail}")
    public ArrayList<ContactoModel> obtenerContactoPorMail(@PathVariable("mail") String mail) {
        return this.contactoService.optenerContactoPorMail(mail);
    }

    @GetMapping("/contacto/{contacto_id}")
    public ResponseEntity<ContactoModel> getContactById(@PathVariable("contacto_id") long contactoId) {
        Optional<ContactoModel> contacOptional = contactoRepository.findById(contactoId);

        if (contacOptional.isPresent()) {
            return new ResponseEntity<>(contacOptional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/contacto/{contacto_id}")
    public ResponseEntity<ContactoModel> upDateContacto(@PathVariable("contacto_id") Long contactoId, @RequestBody ContactoModel contactoModel) {
        Optional<ContactoModel> contactoOptional = contactoRepository.findById(contactoId);
        if (contactoOptional.isPresent()) {
            ContactoModel contactoModelData = contactoOptional.get();
            contactoModelData.setTelefono(contactoModel.getTelefono());
            contactoModelData.setDireccion(contactoModel.getDireccion());
            contactoModelData.setMail(contactoModel.getMail());

            return new ResponseEntity<>(contactoRepository.save(contactoModelData), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
