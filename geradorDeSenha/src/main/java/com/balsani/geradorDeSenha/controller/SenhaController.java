package com.balsani.geradorDeSenha.controller;

import com.balsani.geradorDeSenha.dto.SenhaRequestDTO;
import com.balsani.geradorDeSenha.dto.SenhaResponseDTO;
import com.balsani.geradorDeSenha.services.SenhaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gerador")
public class SenhaController {

    private final SenhaService service;

    public SenhaController(SenhaService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<SenhaResponseDTO> create(@RequestBody SenhaRequestDTO request) {
        SenhaResponseDTO senhaResponseDTO = service.createSenha(request);
        return ResponseEntity.ok(senhaResponseDTO);
    }
}
