package com.balsani.geradorDeSenha.repository;

import com.balsani.geradorDeSenha.models.Senha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SenhaRepository extends JpaRepository<Senha, Long> {
}
