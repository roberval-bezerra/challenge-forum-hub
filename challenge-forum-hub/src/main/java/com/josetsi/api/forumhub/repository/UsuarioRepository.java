// Repositório para a entidade Usuario, estendendo JpaRepository
package com.josetsi.api.forumhub.repository;

import com.josetsi.api.forumhub.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

// Interface de repositório para manipulação dos dados de Usuario
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    // Método para buscar o usuário pelo login (username)
    UserDetails findByLogin(String username);
}
