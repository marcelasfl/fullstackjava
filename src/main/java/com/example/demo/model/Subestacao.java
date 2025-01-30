package com.example.demo.model;

import java.math.BigDecimal;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_SUBESTACAO")
public class Subestacao {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID_SUBESTACAO")
  private Long idSubestacao;

  @Column(name = "CODIGO", length = 3, nullable = false, unique = true)
  private String codigo;

  @Column(name = "NOME", length = 100)
  private String nome;

  @Column(name = "LATITUDE", nullable = false, precision = 15, scale = 13)
  private BigDecimal latitude;

  @Column(name = "LONGITUDE", precision = 15, scale = 13)
  private BigDecimal longitude;

  @OneToMany(mappedBy = "subestacao", cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<RedeMt> redeMtSet;

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

  public Set<RedeMt> getRedeMtSet() {
    return redeMtSet;
  }

  public void setRedeMtSet(Set<RedeMt> redeMtSet) {
    this.redeMtSet = redeMtSet;
  }
}
