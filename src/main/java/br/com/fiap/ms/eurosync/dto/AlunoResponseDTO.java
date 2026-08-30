package br.com.fiap.ms.eurosync.dto;

import br.com.fiap.ms.eurosync.entity.Aluno;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonPropertyOrder({ "id", "nome", "email", "turma" })
public class AlunoResponseDTO {

    private Long id;
    private String nome;
    private String email;
    private TurmaResponseDTO turma;

    public AlunoResponseDTO(Aluno aluno) {
        id = aluno.getId();
        nome = aluno.getNome();
        email = aluno.getEmail();
        turma = new TurmaResponseDTO(aluno.getTurma());
    }
}
