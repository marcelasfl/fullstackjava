package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.SubestacaoDTO;
import com.example.demo.model.Subestacao;
import com.example.demo.service.SubestacaoService;

@RestController
@RequestMapping("/api/subestacoes")
public class SubestacaoController {

  @Autowired
  private SubestacaoService subestacaoService;

  // Criar uma nova subestação
  @PostMapping
  public Subestacao createSubestacao(@RequestBody SubestacaoDTO subestacao) {
    return subestacaoService.createSubestacao(subestacao);
  }

  // Obter todas as subestações
  @GetMapping
  public ResponseEntity<List<Subestacao>> getAllSubestacoes() {
    return ResponseEntity.ok(subestacaoService.getAllSubestacoes());
  }

  // Obter uma subestação por ID
  @GetMapping("/{id}")
  public ResponseEntity<Subestacao> getSubestacaoById(@PathVariable Long id) {
    return subestacaoService.getSubestacaoById(id)
        .map(ResponseEntity::ok)
        .orElseGet(() -> ResponseEntity.notFound().build());
  }

  // Atualizar uma subestação
  @PutMapping("/{id}")
  public ResponseEntity<Subestacao> updateSubestacao(@PathVariable Long id, @RequestBody Subestacao subestacaoDetails) {
    return subestacaoService.updateSubestacao(id, subestacaoDetails)
        .map(ResponseEntity::ok)
        .orElseGet(() -> ResponseEntity.notFound().build());
  }

  // Deletar uma subestação
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteSubestacao(@PathVariable Long id) {
    return subestacaoService.deleteSubestacao(id)
        ? ResponseEntity.noContent().build()
        : ResponseEntity.notFound().build();
  }
}
