package com.alura.foro_hub.controller;


import com.alura.foro_hub.domain.usuario.DatosAutenticacion;
import com.alura.foro_hub.domain.usuario.Usuario;
import com.alura.foro_hub.infra.exceptions.security.DatosTokenJWT;
import com.alura.foro_hub.infra.exceptions.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/login")
public class AutenticationController {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private AuthenticationManager manager;

    @PostMapping
    public ResponseEntity iniciarSesion(@RequestBody @Valid DatosAutenticacion datos){
        var authenticationToken = new UsernamePasswordAuthenticationToken(datos.login(),datos.contrasena());
        var autenticacion = manager.authenticate(authenticationToken);
        var tokenJWT = tokenService.generarToken((Usuario) autenticacion.getPrincipal());
        return ResponseEntity.ok(new DatosTokenJWT(tokenJWT)); //principal es el usuario lo
    }

}
