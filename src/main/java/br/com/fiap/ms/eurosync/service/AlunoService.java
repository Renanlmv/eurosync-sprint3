package br.com.fiap.ms.eurosync.service;

import br.com.fiap.ms.eurosync.dto.AlunoRequestDTO;
import br.com.fiap.ms.eurosync.dto.AlunoResponseDTO;
import br.com.fiap.ms.eurosync.entity.Aluno;
import br.com.fiap.ms.eurosync.entity.Turma;
import br.com.fiap.ms.eurosync.exceptions.DatabaseException;
import br.com.fiap.ms.eurosync.exceptions.ResourceNotFoundException;
import br.com.fiap.ms.eurosync.repository.AlunoRepository;
import br.com.fiap.ms.eurosync.repository.TurmaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private TurmaRepository turmaRepository;

    // visualizar alunos
    @Transactional(readOnly = true)
    public List<AlunoResponseDTO> findAllAlunos() {

        List<Aluno> alunos = alunoRepository.findAll();
        return alunos.stream().map(AlunoResponseDTO::new).toList();
    }

    // visualizar aluno especifico
    @Transactional(readOnly = true)
    public AlunoResponseDTO findAlunoById(Long id) {

        Aluno aluno = alunoRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Aluno não encontrado. ID: " + id)
        );

        return new AlunoResponseDTO(aluno);
    }

    // criar aluno
    @Transactional
    public AlunoResponseDTO saveAluno(AlunoRequestDTO requestDTO) {

        Aluno aluno = new Aluno();
        copyDtoToAluno(requestDTO, aluno);
        aluno = alunoRepository.save(aluno);
        return new AlunoResponseDTO(aluno);
    }

    public void copyDtoToAluno(AlunoRequestDTO requestDTO, Aluno aluno) {

        aluno.setNome(requestDTO.getNome());
        aluno.setEmail(requestDTO.getEmail());

        Turma turma = turmaRepository.findById(requestDTO.getTurmaId()).orElseThrow(
                () -> new DatabaseException("Não foi possível salvar Aluno. Turma inexistente (ID:" + requestDTO.getTurmaId() + ")")
        );

        aluno.setTurma(turma);
    }

    // editar aluno
    @Transactional
    public AlunoResponseDTO updateAluno(Long id, AlunoRequestDTO requestDTO) {

        try {
            Aluno aluno = alunoRepository.getReferenceById(id);
            copyDtoToAluno(requestDTO, aluno);
            aluno = alunoRepository.save(aluno);
            return new AlunoResponseDTO(aluno);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Aluno não encontrado. ID: " + id);
        }
    }

    // excluir aluno
    @Transactional
    public void deleteAlunoById(Long id) {

        if (!alunoRepository.existsById(id)) {
            throw new EntityNotFoundException("Aluno não encontrado. ID: " + id);
        }

        alunoRepository.deleteById(id);
    }
}
