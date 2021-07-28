/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.springexample.controller;

import com.example.springexample.dto.UsuarioDTO;
import com.example.springexample.models.ContactoModel;
import com.example.springexample.models.UsuarioModel;
import com.example.springexample.services.UsuarioService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author rsaldana
 */
@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;
    
    
    @GetMapping()
    public List<UsuarioDTO> obtenerUsuario(){
        return usuarioService.obtenerUsuario()
                .stream()
                .map(UsuarioDTO::new)
                .collect(Collectors.toList());
    }
    
    @PostMapping()
    public UsuarioModel guardarUsuario(@Valid @RequestBody @Validated UsuarioModel usuarioModel, BindingResult resultadoValidacionGuardarUsuario){
        return this.usuarioService.guardarUsuario(usuarioModel);
    }
    
    @GetMapping(path = "/{usuario_id}")
    public Optional<UsuarioModel> obtenerUsuarioPorId(@PathVariable("usuario_id") Long usuario_id){
        return this.usuarioService.obtenerUsuarioPorId(usuario_id);
    }
    
    
    @GetMapping(path = "/nombre/{nombre}")//"/query")
    public ArrayList<UsuarioModel> obtenerContactoPorNombre(@PathVariable("nombre") String nombre){
        return this.usuarioService.obtenerUsuarioPorNombre(nombre);
    }
    
    @GetMapping(path = "/apellido/{apellido}")//"/query")
    public ArrayList<UsuarioModel> obtenerContactoPorApellido(@PathVariable("apellido") String apellido){
        return this.usuarioService.obtenerUsuarioPorApellido(apellido);
    }
    
    @DeleteMapping(path = "/{usuario_id}")
    public String eliminarUsuarioPorId(@PathVariable("usuario_id") Long usuario_id){
        boolean ok = this.usuarioService.eliminarUsuarioPorId(usuario_id);
        if (ok) {
            return "Usuario ELIMINADO.";
        } else {
            return "Usuanrio NO eliminado.";
        }
    }
    
    
    
    
}
