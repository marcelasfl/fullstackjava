package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.SubestacaoDTO;
import com.example.demo.model.Subestacao;
import com.example.demo.repository.SubestacaoRepository;

@Service
public class SubestacaoService {

    @Autowired
    private SubestacaoRepository subestacaoRepository;

    // Criar uma nova subestação
    public Subestacao createSubestacao(SubestacaoDTO data) {
        Subestacao subestacao = new Subestacao();
        subestacao.setCodigo(data.getCodigo());
        subestacao.setNome(data.getNome());
        subestacao.setLatitude(data.getLatitude());
        subestacao.setLongitude(data.getLongitude());

        return subestacaoRepository.save(subestacao);
    }

    // Obter todas as subestações
    public List<Subestacao> getAllSubestacoes() {
        return subestacaoRepository.findAll();
    }

    // Obter uma subestação por ID
    public Optional<Subestacao> getSubestacaoById(Long id) {
        return subestacaoRepository.findById(id);
    }

    // Atualizar uma subestação
    public Optional<Subestacao> updateSubestacao(Long id, Subestacao subestacaoDetails) {
        return subestacaoRepository.findById(id)
                .map(subestacao -> {
                    subestacao.setCodigo(subestacaoDetails.getCodigo());
                    subestacao.setNome(subestacaoDetails.getNome());
                    subestacao.setLatitude(subestacaoDetails.getLatitude());
                    subestacao.setLongitude(subestacaoDetails.getLongitude());
                    return subestacaoRepository.save(subestacao);
                });
    }

    // Deletar uma subestação
    public boolean deleteSubestacao(Long id) {
        return subestacaoRepository.findById(id)
                .map(subestacao -> {
                    subestacaoRepository.delete(subestacao);
                    return true;
                }).orElse(false);
    }
}
