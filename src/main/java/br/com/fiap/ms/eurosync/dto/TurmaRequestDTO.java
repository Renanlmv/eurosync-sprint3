package br.com.fiap.ms.eurosync.dto;

import br.com.fiap.ms.eurosync.entity.Turma;
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
public class TurmaRequestDTO {

    @NotBlank(message = "Campo nome não pode estar vazio, nulo ou em branco.")
    @Size(min = 3, max = 100, message = "O nome deve ter entre 3 e 100 caracteres.")
    @Schema(example = "Investigação Criminal")
    private String nome;

    public TurmaRequestDTO(Turma turma) {
        nome = turma.getNome();
    }
}
