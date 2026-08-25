package br.com.fiap.ms.eurosync.dto;

import br.com.fiap.ms.eurosync.entity.Professor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProfessorResponseDTO {

    private Long id;
    private String nome;
    private String email;

    public ProfessorResponseDTO(Professor professor) {
        id = professor.getId();
        nome = professor.getNome();
        email = professor.getEmail();
    }
}
