// Repositório para a entidade Curso, estendendo JpaRepository
package com.josetsi.api.forumhub.repository;

import com.josetsi.api.forumhub.domain.curso.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

// Interface de repositório para manipulação dos dados de Curso
public interface CursoRepository extends JpaRepository<Curso, Long> {
    // O JpaRepository já oferece métodos prontos para operações CRUD
}
