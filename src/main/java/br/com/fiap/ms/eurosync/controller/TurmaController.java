package br.com.fiap.ms.eurosync.controller;

import br.com.fiap.ms.eurosync.dto.ProfessorResponseDTO;
import br.com.fiap.ms.eurosync.dto.TurmaRequestDTO;
import br.com.fiap.ms.eurosync.dto.TurmaResponseDTO;
import br.com.fiap.ms.eurosync.service.TurmaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/turmas")
public class TurmaController {

    @Autowired
    private TurmaService turmaService;

    // visualizar turmas
    @GetMapping
    public ResponseEntity<List<TurmaResponseDTO>> getAllTurmas() {

        List<TurmaResponseDTO> list = turmaService.findAllTurmas();

        return ResponseEntity.ok(list);
    }

    // visualizar turma especifica
    @GetMapping("/{id}")
    public ResponseEntity<TurmaResponseDTO> getTurmaById(@PathVariable Long id) {

        TurmaResponseDTO turmaDTO = turmaService.findTurmaById(id);

        return ResponseEntity.ok(turmaDTO);
    }

    // visualizar todos os professores de uma turma
    @GetMapping("/{id}/professores")
    public ResponseEntity<List<ProfessorResponseDTO>> getAllProfessoresByTurma(@PathVariable Long id) {

        List<ProfessorResponseDTO> list = turmaService.findAllProfessoresByTurmaId(id);

        return ResponseEntity.ok(list);
    }

    // criar turma
    @PostMapping
    public ResponseEntity<TurmaResponseDTO> createTurma(@RequestBody @Valid TurmaRequestDTO inputDTO) {

        TurmaResponseDTO turmaDTO = turmaService.saveTurma(inputDTO);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(turmaDTO.getId())
                .toUri();

        return ResponseEntity.created(uri).body(turmaDTO);
    }

    // editar turma
    @PutMapping("/{id}")
    public ResponseEntity<TurmaResponseDTO> updateTurma(@PathVariable Long id, @RequestBody @Valid TurmaRequestDTO inputDTO) {

        TurmaResponseDTO turmaDTO = turmaService.updateTurma(id, inputDTO);

        return ResponseEntity.ok(turmaDTO);
    }

    // excluir turma
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTurma(@PathVariable Long id) {

        turmaService.deleteTurmaById(id);

        return ResponseEntity.noContent().build();
    }
}
