package com.example.demo.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_REDE_MT")
public class RedeMt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_REDE_MT")
    private Long idRedeMt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_SUBESTACAO", nullable = false)
    private Subestacao subestacao;

    @Column(name = "CODIGO", length = 5, nullable = false, unique = true)
    private String codigo;

    @Column(name = "NOME", length = 100)
    private String nome;

    @Column(name = "TENSAO_NOMINAL", precision = 5, scale = 2)
    private BigDecimal tensaoNominal;

    // Getters and Setters

    public Long getIdRedeMt() {
        return idRedeMt;
    }

    public void setIdRedeMt(Long idRedeMt) {
        this.idRedeMt = idRedeMt;
    }

    public Subestacao getSubestacao() {
        return subestacao;
    }

    public void setSubestacao(Subestacao subestacao) {
        this.subestacao = subestacao;
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
}
