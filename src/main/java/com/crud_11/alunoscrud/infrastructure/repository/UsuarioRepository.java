package com.crud_11.alunoscrud.infrastructure.repository;

import com.crud_11.alunoscrud.infrastructure.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository <Usuario, Integer>{
}
