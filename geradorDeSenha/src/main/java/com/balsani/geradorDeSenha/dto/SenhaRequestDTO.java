package com.balsani.geradorDeSenha.dto;

import com.balsani.geradorDeSenha.models.Senha;

public record SenhaRequestDTO(String nomeDoSite, int tamanho) {

    public SenhaRequestDTO toModel(Senha senha) {
        return new SenhaRequestDTO(senha.getNomeDoSite(),senha.getTamanho());
    }
}
