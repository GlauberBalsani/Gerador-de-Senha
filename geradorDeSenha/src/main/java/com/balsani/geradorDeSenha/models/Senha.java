package com.balsani.geradorDeSenha.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "TB_SENHA")
public class Senha {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long senhaId;
    @Column(name = "nome_do_site")
    private String nomeDoSite;
    @Column(name = "senha")
    private String senha;
    @Column(name = "tamanho")
    private int tamanho;

    private LocalDateTime dataCriacao;

    public Long getSenhaId() {
        return senhaId;
    }

    public void setSenhaId(Long senhaId) {
        this.senhaId = senhaId;
    }

    public String getNomeDoSite() {
        return nomeDoSite;
    }

    public void setNomeDoSite(String nomeDoSite) {
        this.nomeDoSite = nomeDoSite;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }
}
