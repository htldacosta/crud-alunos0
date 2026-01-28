package com.crud_11.alunoscrud.infrastructure.repository;

import com.crud_11.alunoscrud.infrastructure.entities.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository <Aluno, Integer>{

    Optional<Aluno> findByEmail(String email);

    @Transactional
    void deleteByEmail(String email);
}
