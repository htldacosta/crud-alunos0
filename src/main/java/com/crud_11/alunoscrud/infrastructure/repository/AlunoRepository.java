package com.crud_11.alunoscrud.infrastructure.repository;

import com.crud_11.alunoscrud.infrastructure.entities.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface AlunoRepository extends JpaRepository <Aluno, Integer>{

    boolean existsByEmail(String email);
    boolean existsByMatricula(String matricula);
}
