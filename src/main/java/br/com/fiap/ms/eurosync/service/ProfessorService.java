package br.com.fiap.ms.eurosync.service;

import br.com.fiap.ms.eurosync.dto.ProfessorRequestDTO;
import br.com.fiap.ms.eurosync.dto.ProfessorResponseDTO;
import br.com.fiap.ms.eurosync.entity.Professor;
import br.com.fiap.ms.eurosync.exceptions.ResourceNotFoundException;
import br.com.fiap.ms.eurosync.repository.ProfessorRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;

    // visualizar professores
    @Transactional(readOnly = true)
    public List<ProfessorResponseDTO> findAllProfessores() {

        List<Professor> professores = professorRepository.findAll();
        return professores.stream().map(ProfessorResponseDTO::new).toList();
    }

    // visualizar professor especifico
    @Transactional(readOnly = true)
    public ProfessorResponseDTO findProfessorById(Long id) {

        Professor professor = professorRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Professor não encontrado. ID: " + id)
        );

        return new ProfessorResponseDTO(professor);
    }

    // criar professor
    @Transactional
    public ProfessorResponseDTO saveProfessor(ProfessorRequestDTO requestDTO) {

        Professor professor = new Professor();
        copyDtoToProfessor(requestDTO, professor);
        professor = professorRepository.save(professor);
        return new ProfessorResponseDTO(professor);
    }

    public void copyDtoToProfessor(ProfessorRequestDTO requestDTO, Professor professor) {

        professor.setNome(requestDTO.getNome());
        professor.setEmail(requestDTO.getEmail());
    }

    // editar professor
    @Transactional
    public ProfessorResponseDTO updateProfessor(Long id, ProfessorRequestDTO requestDTO) {

        try {
            Professor professor = professorRepository.getReferenceById(id);
            copyDtoToProfessor(requestDTO, professor);
            professor = professorRepository.save(professor);
            return new ProfessorResponseDTO(professor);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Professor não encontrado. ID: " + id);
        }
    }

    // excluir professor
    @Transactional
    public void deleteProfessorById(Long id) {

        if (!professorRepository.existsById(id)) {
            throw new EntityNotFoundException("Professor não encontrado. ID: " + id);
        }

        professorRepository.deleteById(id);
    }
}
