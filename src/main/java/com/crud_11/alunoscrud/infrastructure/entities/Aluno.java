package com.crud_11.alunoscrud.infrastructure.entities;

import com.crud_11.alunoscrud.infrastructure.enums.Curso;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "aluno")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "matricula", unique = true, nullable = false)
    private String matricula;

    @Enumerated(EnumType.STRING)
    @Column(name = "curso", nullable = false)
    private Curso curso;
}
