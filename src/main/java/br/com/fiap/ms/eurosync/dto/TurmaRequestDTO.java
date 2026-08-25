package br.com.fiap.ms.eurosync.dto;

import br.com.fiap.ms.eurosync.entity.Aluno;
import br.com.fiap.ms.eurosync.entity.Professor;
import br.com.fiap.ms.eurosync.entity.Turma;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TurmaRequestDTO {

    @NotBlank(message = "Campo nome não pode estar vazio, nulo ou em branco.")
    @Size(min = 3, max = 100, message = "O nome deve ter entre 3 e 100 caracteres.")
    private String nome;

    @NotBlank(message = "Campo alunos não pode estar vazio, nulo ou em branco.")
    private List<Aluno> alunos = new ArrayList<>();

    @NotBlank(message = "Campo professores não pode estar vazio, nulo ou em branco.")
    private List<Professor> professores = new ArrayList<>();

    public TurmaRequestDTO(Turma turma) {
        nome = turma.getNome();
    }
}
