package br.com.fiap.ms.eurosync.service;

import br.com.fiap.ms.eurosync.dto.TurmaRequestDTO;
import br.com.fiap.ms.eurosync.dto.TurmaResponseDTO;
import br.com.fiap.ms.eurosync.entity.Turma;
import br.com.fiap.ms.eurosync.exceptions.ResourceNotFoundException;
import br.com.fiap.ms.eurosync.repository.TurmaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TurmaService {

    @Autowired
    private TurmaRepository turmaRepository;

    // visualizar turmas
    @Transactional(readOnly = true)
    public List<TurmaResponseDTO> findAllTurmas() {

        List<Turma> turmas = turmaRepository.findAll();
        return turmas.stream().map(TurmaResponseDTO::new).toList();
    }

    // visualizar turma especifica
    @Transactional(readOnly = true)
    public TurmaResponseDTO findTurmaById(Long id) {

        Turma turma = turmaRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Turma não encontrada. ID: " + id)
        );

        return new TurmaResponseDTO(turma);
    }

    // criar turma
    @Transactional
    public TurmaResponseDTO saveTurma(TurmaRequestDTO requestDTO) {

        Turma turma = new Turma();
        copyDtoToTurma(requestDTO, turma);
        turma = turmaRepository.save(turma);
        return new TurmaResponseDTO(turma);
    }

    public void copyDtoToTurma(TurmaRequestDTO requestDTO, Turma turma) {

        turma.setNome(requestDTO.getNome());
    }

    // editar turma
    @Transactional
    public TurmaResponseDTO updateTurma(Long id, TurmaRequestDTO requestDTO) {

        try {
            Turma turma = turmaRepository.getReferenceById(id);
            copyDtoToTurma(requestDTO, turma);
            turma = turmaRepository.save(turma);
            return new TurmaResponseDTO(turma);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Turma não encontrada. ID: " + id);
        }
    }

    // excluir turma
    @Transactional
    public void deleteTurmaById(Long id) {

        if (!turmaRepository.existsById(id)) {
            throw new ResourceNotFoundException("Turma não encontrada. ID: " + id);
        }

        turmaRepository.deleteById(id);
    }
}
