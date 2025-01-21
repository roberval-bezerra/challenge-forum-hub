// Repositório para a entidade Autor, estendendo JpaRepository
package com.josetsi.api.forumhub.repository;

import com.josetsi.api.forumhub.domain.autor.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

// Interface de repositório para manipulação dos dados de Autor
public interface AutorRepository extends JpaRepository<Autor, Long> {
    // O JpaRepository já oferece métodos prontos para operações CRUD
}
