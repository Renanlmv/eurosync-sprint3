package br.com.fiap.ms.eurosync.repository;

import br.com.fiap.ms.eurosync.entity.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}
