package br.com.fiap.ms.eurosync.controller;

import br.com.fiap.ms.eurosync.dto.ProfessorRequestDTO;
import br.com.fiap.ms.eurosync.dto.ProfessorResponseDTO;
import br.com.fiap.ms.eurosync.service.ProfessorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/professores")
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;

    // visualizar professores
    @GetMapping
    public ResponseEntity<List<ProfessorResponseDTO>> getAllProfessores() {

        List<ProfessorResponseDTO> list = professorService.findAllProfessores();

        return ResponseEntity.ok(list);
    }

    // visualizar professor especifico
    @GetMapping("/{id}")
    public ResponseEntity<ProfessorResponseDTO> getProfessorById(@PathVariable Long id) {

        ProfessorResponseDTO professorDTO = professorService.findProfessorById(id);

        return ResponseEntity.ok(professorDTO);
    }

    // criar professor
    @PostMapping
    public ResponseEntity<ProfessorResponseDTO> createProfessor(@RequestBody @Valid ProfessorRequestDTO inputDTO) {

        ProfessorResponseDTO professorDTO = professorService.saveProfessor(inputDTO);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(professorDTO.getId())
                .toUri();

        return ResponseEntity.created(uri).body(professorDTO);
    }

    // editar professor
    @PutMapping("/{id}")
    public ResponseEntity<ProfessorResponseDTO> updateProfessor(@PathVariable Long id, @RequestBody @Valid ProfessorRequestDTO inputDTO) {

        ProfessorResponseDTO professorDTO = professorService.updateProfessor(id, inputDTO);

        return ResponseEntity.ok(professorDTO);
    }

    // excluir professor
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProfessor(@PathVariable Long id) {

        professorService.deleteProfessorById(id);

        return ResponseEntity.noContent().build();
    }
}
