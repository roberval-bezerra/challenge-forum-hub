// Controlador de autenticação
package com.josetsi.api.forumhub.controller;

import com.josetsi.api.forumhub.domain.Login;
import com.josetsi.api.forumhub.infra.security.DadosTokenJWT;
import com.josetsi.api.forumhub.infra.security.TokenService;
import com.josetsi.api.forumhub.usuario.Usuario;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity realizarLogin(@RequestBody @Valid Login loginDados) {
        var authToken = new UsernamePasswordAuthenticationToken(loginDados.login(), loginDados.senha());
        var authentication = authenticationManager.authenticate(authToken);

        // Chame o método correto "criarToken" aqui
        var jwtToken = tokenService.criarToken((Usuario) authentication.getPrincipal());

        return ResponseEntity.ok(new DadosTokenJWT(jwtToken));
    }
}
