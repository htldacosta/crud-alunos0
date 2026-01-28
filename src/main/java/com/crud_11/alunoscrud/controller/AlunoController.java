package com.crud_11.alunoscrud.controller;

import com.crud_11.alunoscrud.business.AlunoService;
import com.crud_11.alunoscrud.infrastructure.enums.dto.AlunoRequestDTO;
import com.crud_11.alunoscrud.infrastructure.enums.dto.AlunoResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aluno")
@RequiredArgsConstructor
public class AlunoController {

    private final AlunoService alunoService;

    @PostMapping
    public ResponseEntity<AlunoResponseDTO> salvar(@RequestBody AlunoRequestDTO dto) {
        return ResponseEntity.ok(alunoService.salvarAluno(dto));
    }

    @GetMapping
    public ResponseEntity<List<AlunoResponseDTO>> listarTodos() {
        return ResponseEntity.ok(alunoService.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlunoResponseDTO> buscarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(alunoService.buscarPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        alunoService.deletarPorId(id);
        return ResponseEntity.noContent().build(); // Retorna 204 (Sucesso sem conteúdo)
    }
}
