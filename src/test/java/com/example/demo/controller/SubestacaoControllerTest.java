package com.example.demo.controller;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.Subestacao;
import com.example.demo.repository.SubestacaoRepository;

@SpringBootTest
public class SubestacaoControllerTest {

  @Autowired
  private SubestacaoRepository subestacaoRepository;

  @BeforeEach
  void setUp() {
    subestacaoRepository.deleteAll(); // Limpa os dados antes dos testes
  }

  @Test
  public void testCreateSubestacao() {
    Subestacao subestacao = new Subestacao();
    subestacao.setCodigo("001");
    subestacao.setNome("Subestação 1");
    subestacao.setLatitude(new BigDecimal("15.0000000000000"));
    subestacao.setLongitude(new BigDecimal("-45.0000000000000"));

    Subestacao savedSubestacao = subestacaoRepository.save(subestacao);

    assertNotNull(savedSubestacao.getIdSubestacao());
  }
}
