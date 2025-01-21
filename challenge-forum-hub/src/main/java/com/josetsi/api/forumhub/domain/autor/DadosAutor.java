// DTO para representar os dados de um autor
package com.josetsi.api.forumhub.domain.autor;

public record DadosAutor(Long id, String nome, String email) {

    public DadosAutor(Autor autor) {
        this(autor.getId(), autor.getNome(), autor.getEmail());
    }
}
