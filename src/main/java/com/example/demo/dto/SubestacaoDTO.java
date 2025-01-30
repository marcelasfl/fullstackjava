package com.example.demo.dto;

import java.math.BigDecimal;

public class SubestacaoDTO {

  private Long idSubestacao;

  
  private String codigo;

  
  private String nome;

  
  private BigDecimal latitude;

  
  private BigDecimal longitude;


  // Getters and Setters

  public Long getIdSubestacao() {
    return idSubestacao;
  }

  public void setIdSubestacao(Long idSubestacao) {
    this.idSubestacao = idSubestacao;
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

  public BigDecimal getLatitude() {
    return latitude;
  }

  public void setLatitude(BigDecimal latitude) {
    this.latitude = latitude;
  }

  public BigDecimal getLongitude() {
    return longitude;
  }

  public void setLongitude(BigDecimal longitude) {
    this.longitude = longitude;
  }

  
}
