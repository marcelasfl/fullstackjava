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

import com.example.demo.dto.RedeMtDTO;
import com.example.demo.model.RedeMt;
import com.example.demo.service.RedeMtService;

@RestController
@RequestMapping("/api/redesmt")
public class RedeMtController {

  @Autowired
  private RedeMtService redeMtService;

  // Criar uma nova rede MT
  @PostMapping
  public RedeMt createRedeMt(@RequestBody RedeMtDTO redeMt) {
    return redeMtService.createRedeMt(redeMt);
  }

  // Obter todas as redes MT
  @GetMapping
  public List<RedeMt> getAllRedesMt() {
    return redeMtService.getAllRedesMt();
  }

  // Obter uma rede MT por ID
  @GetMapping("/{id}")
  public ResponseEntity<RedeMtDTO> getRedeMtById(@PathVariable Long id) {
    return redeMtService.getRedeMtById(id)
        .map(ResponseEntity::ok)
        .orElseGet(() -> ResponseEntity.notFound().build());
  }

  // Atualizar uma rede MT
  @PutMapping("/{id}")
  public ResponseEntity<RedeMt> updateRedeMt(@PathVariable Long id, @RequestBody RedeMt redeMtDetails) {
    return redeMtService.updateRedeMt(id, redeMtDetails)
        .map(ResponseEntity::ok)
        .orElseGet(() -> ResponseEntity.notFound().build());
  }

  // Deletar uma rede MT
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteRedeMt(@PathVariable Long id) {
    return redeMtService.deleteRedeMt(id)
        ? ResponseEntity.noContent().build()
        : ResponseEntity.notFound().build();
  }
}
