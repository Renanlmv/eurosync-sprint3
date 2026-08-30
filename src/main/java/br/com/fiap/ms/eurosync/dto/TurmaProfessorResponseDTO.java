package br.com.fiap.ms.eurosync.dto;

import br.com.fiap.ms.eurosync.entity.Professor;
import br.com.fiap.ms.eurosync.entity.Turma;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class TurmaProfessorResponseDTO {

    private Long turmaId;
    private String turmaNome;
    private Long professorId;
    private String professorNome;

    public TurmaProfessorResponseDTO(Turma turma, Professor professor) {
        turmaId = turma.getId();
        turmaNome = turma.getNome();
        professorId = professor.getId();
        professorNome = professor.getNome();
    }
}
