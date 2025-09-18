package com.insight.demo.model;

import jakarta.persistence.*;

@Entity
public class DependenciaModel {
    @Id
    @GeneratedValue
    private Long id;
    private String campoDependente;
    private String valorEsperado;

    public DependenciaModel(Long id, String campoDependente, String valorEsperado, CampoModel campoModel) {
        this.id = id;
        this.campoDependente = campoDependente;
        this.valorEsperado = valorEsperado;
        this.campoModel = campoModel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCampoDependente() {
        return campoDependente;
    }

    public void setCampoDependente(String campoDependente) {
        this.campoDependente = campoDependente;
    }

    public String getValorEsperado() {
        return valorEsperado;
    }

    public void setValorEsperado(String valorEsperado) {
        this.valorEsperado = valorEsperado;
    }

    public CampoModel getCampoModel() {
        return campoModel;
    }

    public void setCampoModel(CampoModel campoModel) {
        this.campoModel = campoModel;
    }

    @ManyToOne
    @JoinColumn(name = "campo_id")
    public CampoModel campoModel;
}
