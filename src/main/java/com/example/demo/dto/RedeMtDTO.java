package com.example.demo.dto;

import java.math.BigDecimal;

public class RedeMtDTO {

  private Long idRedeMt;
  private String codigo;
  private String nome;
  private BigDecimal tensaoNominal;
  private Long idSubestacao;

  // Getters and Setters
  public Long getIdRedeMt() {
    return idRedeMt;
  }

  public void setIdRedeMt(Long idRedeMt) {
    this.idRedeMt = idRedeMt;
  }

  public String getCodigo() {
    return codigo;
  }

  public void setCodigo(String codigo) {
    this.codigo = codigo;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public BigDecimal getTensaoNominal() {
    return tensaoNominal;
  }

  public void setTensaoNominal(BigDecimal tensaoNominal) {
    this.tensaoNominal = tensaoNominal;
  }

  public Long getIdSubestacao() {
    return idSubestacao;
  }

  public void setIdSubestacao(Long idSubestacao) {
    this.idSubestacao = idSubestacao;
  }
}