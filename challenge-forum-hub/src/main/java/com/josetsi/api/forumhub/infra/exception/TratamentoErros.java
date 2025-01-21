// Classe para tratamento de exceções específicas
package com.josetsi.api.forumhub.infra.exception;

import com.josetsi.api.forumhub.domain.ValidacaoException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TratamentoErros {

    // Tratamento de erro 404 - Entidade não encontrada
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<?> tratarErro404() {
        return ResponseEntity.notFound().build();
    }

    // Tratamento de erro 400 - Argumentos inválidos
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> tratarErro400(MethodArgumentNotValidException ex) {
        var erros = ex.getFieldErrors();
        return ResponseEntity.badRequest().body(erros.stream().map(DadosErroValidacao::new).toList());
    }

    // Tratamento de erro 400 - Validação de regras de negócio
    @ExceptionHandler(ValidacaoException.class)
    public ResponseEntity<?> tratarErroRegrasDeNegocio(ValidacaoException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    // Classe interna para representar os erros de validação
    private record DadosErroValidacao(String campo, String mensagem) {

        public DadosErroValidacao(FieldError error) {
            this(error.getField(), error.getDefaultMessage());
        }
    }
}
