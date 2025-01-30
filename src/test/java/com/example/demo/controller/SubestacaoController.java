package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Subestacao;
import com.example.demo.repository.SubestacaoRepository;

@RestController
@RequestMapping("/subestacoes")
public class SubestacaoController {

  @Autowired
  private SubestacaoRepository subestacaoRepository;

  @PostMapping
  public Subestacao create(@RequestBody Subestacao subestacao) {
    return subestacaoRepository.save(subestacao);
  }

  @GetMapping
  public List<Subestacao> getAll() {
    return subestacaoRepository.findAll();
  }

  @GetMapping("/{id}")
  public Subestacao getById(@PathVariable Long id) {
    return subestacaoRepository.findById(id).orElse(null);
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable Long id) {
    subestacaoRepository.deleteById(id);
  }
}
