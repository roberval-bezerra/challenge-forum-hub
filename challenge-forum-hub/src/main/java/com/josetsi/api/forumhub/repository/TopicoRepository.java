// Repositório para a entidade Topico, estendendo JpaRepository
package com.josetsi.api.forumhub.repository;

import com.josetsi.api.forumhub.domain.topico.Topico;
import org.springframework.data.jpa.repository.JpaRepository;

// Interface de repositório para manipulação dos dados de Topico
public interface TopicoRepository extends JpaRepository<Topico, Long> {
    // O JpaRepository já oferece métodos prontos para operações CRUD
}
