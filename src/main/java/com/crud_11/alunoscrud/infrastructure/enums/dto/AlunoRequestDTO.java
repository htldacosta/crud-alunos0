package com.crud_11.alunoscrud.infrastructure.enums.dto;

import com.crud_11.alunoscrud.infrastructure.enums.Curso;

public record AlunoRequestDTO(
        String nome,
        String email,
        String matricula,
        Curso curso
) {}
