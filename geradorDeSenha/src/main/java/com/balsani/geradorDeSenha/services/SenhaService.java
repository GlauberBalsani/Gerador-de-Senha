package com.balsani.geradorDeSenha.services;

import com.balsani.geradorDeSenha.dto.SenhaRequestDTO;
import com.balsani.geradorDeSenha.dto.SenhaResponseDTO;
import com.balsani.geradorDeSenha.models.Senha;
import com.balsani.geradorDeSenha.repository.SenhaRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.time.LocalDateTime;

@Service
public class SenhaService {
    private final SenhaRepository senhaRepository;

    public SenhaService(SenhaRepository senhaRepository) {
        this.senhaRepository = senhaRepository;
    }

    @Transactional
    public SenhaResponseDTO createSenha(SenhaRequestDTO request) {
        int tamanho = request.tamanho();

        String senhaGerada = createPasswordSize(tamanho);

        Senha senha = new Senha();
        senha.setNomeDoSite(request.nomeDoSite());
        senha.setTamanho(tamanho);
        senha.setSenha(senhaGerada);
        senha.setDataCriacao(LocalDateTime.now());
        Senha senhaSalva = senhaRepository.save(senha);

        return new SenhaResponseDTO(
                senhaSalva.getSenhaId(),
                senhaSalva.getNomeDoSite(),
                senhaSalva.getSenha(),
                senhaSalva.getDataCriacao()
        );

    }





    public String createPasswordSize(int tamanhoDaSenha) {
        final String senhaComEspeciais =
                "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789{{!@#$%&*()/-_=+";

        if (tamanhoDaSenha < 8 || tamanhoDaSenha > 12) {
            throw new RuntimeException("Senha não permitida");
        }

        SecureRandom random = new SecureRandom();
        StringBuilder builder = new StringBuilder();

        int sizeCharacters = senhaComEspeciais.length();

        for (int i = 0; i < tamanhoDaSenha; i++) {
            int index = random.nextInt(sizeCharacters);
            builder.append(senhaComEspeciais.charAt(index));
        }

        return builder.toString();
    }
}
