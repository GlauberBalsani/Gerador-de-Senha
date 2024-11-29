package com.balsani.geradorDeSenha.dto;

import com.balsani.geradorDeSenha.models.Senha;

import java.time.LocalDateTime;

public record SenhaResponseDTO(Long idSenha,String nomeDoSite, String senha, LocalDateTime dataCriacao) {

    public SenhaResponseDTO(Senha senha) {
        this(senha.getSenhaId(),senha.getNomeDoSite(),senha.getSenha(),senha.getDataCriacao());
    }
}
