package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.RedeMt;

public interface RedeMtRepository extends JpaRepository<RedeMt, Long> {
  // Você pode adicionar métodos personalizados aqui, se necessário

}
