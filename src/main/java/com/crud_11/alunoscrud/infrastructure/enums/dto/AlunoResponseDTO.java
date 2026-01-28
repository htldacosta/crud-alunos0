package com.crud_11.alunoscrud.infrastructure.enums.dto;

import com.crud_11.alunoscrud.infrastructure.entities.Aluno;
import com.crud_11.alunoscrud.infrastructure.enums.Curso;

public record AlunoResponseDTO(
        Integer id,
        String nome,
        String email,
        String matricula,
        Curso curso
) {
    public static AlunoResponseDTO paraDTO(Aluno aluno) {
        return new AlunoResponseDTO(
                aluno.getId(),
                aluno.getNome(),
                aluno.getEmail(),
                aluno.getMatricula(),
                aluno.getCurso()
        );
    }
}
