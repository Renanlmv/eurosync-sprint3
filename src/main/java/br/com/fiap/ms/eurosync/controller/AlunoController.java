package br.com.fiap.ms.eurosync.controller;

import br.com.fiap.ms.eurosync.dto.AlunoRequestDTO;
import br.com.fiap.ms.eurosync.dto.AlunoResponseDTO;
import br.com.fiap.ms.eurosync.service.AlunoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/alunos")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    // visualizar alunos
    @GetMapping
    public ResponseEntity<List<AlunoResponseDTO>> getAllAlunos() {

        List<AlunoResponseDTO> list = alunoService.findAllAlunos();

        return ResponseEntity.ok(list);
    }

    // visualizar aluno especifico
    @GetMapping("/{id}")
    public ResponseEntity<AlunoResponseDTO> getAlunoById(@PathVariable Long id) {

        AlunoResponseDTO alunoDTO = alunoService.findAlunoById(id);

        return ResponseEntity.ok(alunoDTO);
    }

    // criar aluno
    @PostMapping
    public ResponseEntity<AlunoResponseDTO> createAluno(@RequestBody @Valid AlunoRequestDTO inputDTO) {

        AlunoResponseDTO alunoDTO = alunoService.saveAluno(inputDTO);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(alunoDTO.getId())
                .toUri();

        return ResponseEntity.created(uri).body(alunoDTO);
    }

    // editar aluno
    @PutMapping("/{id}")
    public ResponseEntity<AlunoResponseDTO> updateAluno(@PathVariable Long id, @RequestBody @Valid AlunoRequestDTO inputDTO) {

        AlunoResponseDTO alunoDTO = alunoService.updateAluno(id, inputDTO);

        return ResponseEntity.ok(alunoDTO);
    }

    // excluir aluno
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAluno(@PathVariable Long id) {

        alunoService.deleteAlunoById(id);

        return ResponseEntity.noContent().build();
    }
}
