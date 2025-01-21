// Controlador para gerenciamento de autores
package com.josetsi.api.forumhub.controller;

import com.josetsi.api.forumhub.domain.autor.Autor;
import com.josetsi.api.forumhub.domain.autor.DadosAutor;
import com.josetsi.api.forumhub.repository.AutorRepository;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/autores")
@SecurityRequirement(name = "bearer-key")
public class AutorController {

    @Autowired
    private AutorRepository repository;

    @GetMapping("/{id}")
    public ResponseEntity obterAutor(@PathVariable Long id) {
        var autor = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosAutor(autor));
    }

    @GetMapping
    public ResponseEntity<Page<DadosAutor>> listarTodos(@PageableDefault(sort = {"nome"}) Pageable paginacao) {
        var pagina = repository.findAll(paginacao).map(DadosAutor::new);
        return ResponseEntity.ok(pagina);
    }

    @PostMapping
    public Autor criar(@RequestBody @Valid Autor autor) {
        return repository.save(autor);
    }

    @PutMapping
    public Autor atualizar(@RequestBody @Valid Autor autor) {
        return repository.save(autor);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
