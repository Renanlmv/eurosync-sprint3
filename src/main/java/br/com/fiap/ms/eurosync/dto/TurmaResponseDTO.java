package br.com.fiap.ms.eurosync.dto;

import br.com.fiap.ms.eurosync.entity.Turma;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TurmaResponseDTO {

    private Long id;
    private String nome;

    public TurmaResponseDTO(Turma turma) {
        id = turma.getId();
        nome = turma.getNome();
    }
}
