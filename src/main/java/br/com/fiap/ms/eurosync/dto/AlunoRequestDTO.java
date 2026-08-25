package br.com.fiap.ms.eurosync.dto;

import br.com.fiap.ms.eurosync.entity.Aluno;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AlunoRequestDTO {

    @NotBlank(message = "Campo nome não pode estar vazio, nulo ou em branco.")
    @Size(min = 3, max = 100, message = "O nome deve ter entre 3 e 100 caracteres.")
    private String nome;

    @NotBlank(message = "Campo email não pode estar vazio, nulo ou em branco.")
    @Size(min = 10, max = 50, message = "O email deve ter entre 10 e 50 caracteres.")
    private String email;

    @NotNull(message = "Campo turmaId é requerido.")
    private Long turmaId;

    public AlunoRequestDTO(Aluno aluno) {
        nome = aluno.getNome();
        email = aluno.getEmail();
        turmaId = aluno.getTurma().getId();
    }
}
