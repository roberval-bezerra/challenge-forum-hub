// DTO para detalhamento de um tópico
package com.josetsi.api.forumhub.domain.topico;

import com.josetsi.api.forumhub.domain.autor.Autor;
import com.josetsi.api.forumhub.domain.curso.Curso;

import java.time.LocalDateTime;

public record DadosDetalhamentoTopico(
        Long id,
        String titulo,
        String mensagem,
        LocalDateTime dataCriacao,
        String status,
        Autor autor,
        Curso curso
) {

    public DadosDetalhamentoTopico(Topico topico) {
        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensagem(),
                topico.getDataCriacao(),
                topico.getStatus(),
                topico.getAutor(),
                topico.getCurso()
        );
    }
}
