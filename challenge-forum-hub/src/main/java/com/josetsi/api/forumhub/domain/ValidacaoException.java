// Exceção personalizada para validação de dados
package com.josetsi.api.forumhub.domain;

public class ValidacaoException extends RuntimeException {

    public ValidacaoException(String mensagem) {
        super(mensagem);
    }
}
