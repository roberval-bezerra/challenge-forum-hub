// Controlador para gerenciamento de cursos
package com.josetsi.api.forumhub.controller;

import com.josetsi.api.forumhub.domain.curso.Curso;
import com.josetsi.api.forumhub.domain.curso.DadosCurso;
import com.josetsi.api.forumhub.repository.CursoRepository;
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
@RequestMapping("/cursos")
@SecurityRequirement(name = "bearer-key")
public class CursoController {

    @Autowired
    private CursoRepository repository;

    @GetMapping("/{id}")
    public ResponseEntity obterCurso(@PathVariable Long id) {
        var curso = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosCurso(curso));
    }

    @GetMapping
    public ResponseEntity<Page<DadosCurso>> listarTodos(@PageableDefault(sort = {"nome"}) Pageable paginacao) {
        var pagina = repository.findAll(paginacao).map(DadosCurso::new);
        return ResponseEntity.ok(pagina);
    }

    @PostMapping
    public Curso criar(@RequestBody @Valid Curso curso) {
        return repository.save(curso);
    }

    @PutMapping
    public Curso atualizar(@RequestBody @Valid Curso curso) {
        return repository.save(curso);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
