package br.com.fiap.ms.eurosync.repository;

import br.com.fiap.ms.eurosync.entity.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
}
