// Serviço responsável pela geração e validação do token JWT
package com.josetsi.api.forumhub.infra.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;

import com.josetsi.api.forumhub.usuario.Usuario;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("${api.security.token.secret}")
    private String segredo;  // Renomeado para "segredo"

    // Gera um token JWT para o usuário
    public String criarToken(Usuario usuario) {
        try {
            var algoritmo = Algorithm.HMAC256(segredo);  // Algoritmo de criptografia para o token
            return JWT.create()
                    .withIssuer("API ForumHub")  // Definindo o emissor do token
                    .withSubject(usuario.getLogin())  // Definindo o login do usuário como o "assunto" do token
                    .withExpiresAt(obterDataExpiracao())  // Definindo a data de expiração do token
                    .sign(algoritmo);  // Assinando o token com o algoritmo
        } catch (JWTCreationException exception){
            throw new RuntimeException("Erro ao criar o token JWT", exception);  // Em caso de erro, lançar exceção
        }
    }

    // Valida o token JWT e retorna o login do usuário
    public String validarToken(String tokenJWT) {
        try {
            var algoritmo = Algorithm.HMAC256(segredo);  // Algoritmo de criptografia para validação
            return JWT.require(algoritmo)  // Configurando o token para validação
                    .withIssuer("API ForumHub")  // Verificando o emissor do token
                    .build()  // Constrói a configuração
                    .verify(tokenJWT)  // Verifica o token
                    .getSubject();  // Retorna o "assunto" do token, que é o login do usuário
        } catch (JWTVerificationException exception) {
            throw new RuntimeException("Token JWT inválido ou expirado", exception);  // Em caso de erro na validação, lançar exceção
        }
    }

    // Retorna a data de expiração do token (2 horas a partir de agora)
    private Instant obterDataExpiracao() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.UTC);  // Usando UTC para garantir consistência global
    }
}
