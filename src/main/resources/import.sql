-- Inserindo turmas
INSERT INTO tb_turma(nome) VALUES ('Microsserviços');
INSERT INTO tb_turma(nome) VALUES ('Desenvolvimento Cross Platform');
INSERT INTO tb_turma(nome) VALUES ('OSTC');
INSERT INTO tb_turma(nome) VALUES ('Android Kotlin Developer');
INSERT INTO tb_turma(nome) VALUES ('Software Projects Quality Assurance');

-- Inserindo professores
INSERT INTO tb_professor(nome, email) VALUES ('Cida Rosa', 'cida@email.com');
INSERT INTO tb_professor(nome, email) VALUES ('Diego Camilo', 'diego@email.com');
INSERT INTO tb_professor(nome, email) VALUES ('Fábio Pimentel', 'fabio@email.com');
INSERT INTO tb_professor(nome, email) VALUES ('Heider Lopes', 'heider@email.com');
INSERT INTO tb_professor(nome, email) VALUES ('Renato Parducci', 'renato@email.com');

-- Relacionando professores às turmas
INSERT INTO turma_professor (turma_id, professor_id) VALUES (1, 1);
INSERT INTO turma_professor (turma_id, professor_id) VALUES (2, 2);
INSERT INTO turma_professor (turma_id, professor_id) VALUES (3, 3);
INSERT INTO turma_professor (turma_id, professor_id) VALUES (4, 4);
INSERT INTO turma_professor (turma_id, professor_id) VALUES (5, 5);

-- Inserindo de alunos
INSERT INTO tb_aluno(nome, email, turma_id) VALUES('Bruno Itikawa', 'bruno@email.com', 1);
INSERT INTO tb_aluno(nome, email, turma_id) VALUES('Carolina Seiko', 'carolina@email.com', 1);
INSERT INTO tb_aluno(nome, email, turma_id) VALUES('Kevin Bueno', 'kevin@email.com', 1);
INSERT INTO tb_aluno(nome, email, turma_id) VALUES('Renan Lopes', 'renan@email.com', 2);
INSERT INTO tb_aluno(nome, email, turma_id) VALUES('Sophia Alves', 'sophia@email.com', 2);

