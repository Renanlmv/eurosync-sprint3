package br.com.fiap.ms.eurosync.dto;

import br.com.fiap.ms.eurosync.entity.Professor;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProfessorRequestDTO {

    @NotBlank(message = "Campo nome não pode estar vazio, nulo ou em branco.")
    @Size(min = 3, max = 100, message = "O nome deve ter entre 3 e 100 caracteres.")
    @Schema(example = "Alfred Pennyworth")
    private String nome;

    @NotBlank(message = "Campo email não pode estar vazio, nulo ou em branco.")
    @Size(min = 10, max = 50, message = "O email deve ter entre 10 e 50 caracteres.")
    @Schema(example = "alfred@email.com")
    private String email;

    public ProfessorRequestDTO(Professor professor) {
        nome = professor.getNome();
        email = professor.getEmail();
    }
}
