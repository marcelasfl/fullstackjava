package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Subestacao;

public interface SubestacaoRepository extends JpaRepository<Subestacao, Long> {
  // Você pode adicionar métodos personalizados aqui, se necessário
}
