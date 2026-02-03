package com.crud_11.alunoscrud.business;

import com.crud_11.alunoscrud.infrastructure.entities.Aluno;
import com.crud_11.alunoscrud.infrastructure.enums.dto.AlunoRequestDTO;
import com.crud_11.alunoscrud.infrastructure.enums.dto.AlunoResponseDTO;
import com.crud_11.alunoscrud.infrastructure.repository.AlunoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {

    private final AlunoRepository alunoRepository;


    public AlunoService(AlunoRepository alunoRepository){
        this.alunoRepository = alunoRepository;
    }

    public AlunoResponseDTO salvarAluno(AlunoRequestDTO dto){

        if (alunoRepository.existsByEmail(dto.email())){
            throw new IllegalArgumentException("Já existe um aluno com este email");
        }
        if (alunoRepository.existsByMatricula(dto.matricula())){
            throw new IllegalArgumentException("Já existe um aluno com esta matricula");
        }

        Aluno aluno = Aluno.builder()
                .nome(dto.nome())
                .email(dto.email())
                .matricula(dto.matricula())
                .curso(dto.curso())
                .build();

        aluno = alunoRepository.save(aluno);

        return AlunoResponseDTO.paraDTO(aluno);
    }

    public List<AlunoResponseDTO> buscarTodos() {
        return alunoRepository.findAll().stream()
                .map(AlunoResponseDTO::paraDTO)
                .toList();
    }

    public AlunoResponseDTO buscarPorId(Integer id) {
        return alunoRepository.findById(id)
                .map(AlunoResponseDTO::paraDTO)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado com ID: " + id));
    }

    public AlunoResponseDTO atualizarAluno(Integer id, AlunoRequestDTO dto) {

        Aluno alunoExistente = alunoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado para atualização"));

        if (!alunoExistente.getEmail().equals(dto.email()) && alunoRepository.existsByEmail(dto.email())) {
            throw new IllegalArgumentException("O novo email informado já pertence a outro aluno.");
        }

        alunoExistente.setNome(dto.nome());
        alunoExistente.setEmail(dto.email());
        alunoExistente.setMatricula(dto.matricula());
        alunoExistente.setCurso(dto.curso());


        Aluno alunoAtualizado = alunoRepository.save(alunoExistente);
        
        return AlunoResponseDTO.paraDTO(alunoAtualizado);
    }

    public void deletarPorId(Integer id) {
        if (!alunoRepository.existsById(id)) {
            throw new RuntimeException("Aluno não encontrado para exclusão.");
        }
        alunoRepository.deleteById(id);
    }
}
