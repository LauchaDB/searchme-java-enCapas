package com.viajesEnCapas.controller;

import negocio.Usuarios;
import negocio.model.Usuario;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    Usuarios usuarios = new Usuarios();

    @GetMapping("")
    public List<Usuario> usuarios() throws SQLException {
        return usuarios.findAllUsuarios();
    }
}
