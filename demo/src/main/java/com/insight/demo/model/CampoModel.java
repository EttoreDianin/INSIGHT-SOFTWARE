package com.insight.demo.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class CampoModel {
    @Id
    @GeneratedValue
    private Long id;
    private String nome;
    private String label;
    private String tipo;
    private Integer ordem;
    private boolean obrigatorio;
    private boolean visivel;

    public CampoModel(Long id, String nome, String label, String tipo, Integer ordem, boolean obrigatorio, boolean visivel, GrupoModel grupoModel, List<DependenciaModel> dependencias) {
        this.id = id;
        this.nome = nome;
        this.label = label;
        this.tipo = tipo;
        this.ordem = ordem;
        this.obrigatorio = obrigatorio;
        this.visivel = visivel;
        this.grupoModel = grupoModel;
        this.dependencias = dependencias;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getOrdem() {
        return ordem;
    }

    public void setOrdem(Integer ordem) {
        this.ordem = ordem;
    }

    public boolean isObrigatorio() {
        return obrigatorio;
    }

    public void setObrigatorio(boolean obrigatorio) {
        this.obrigatorio = obrigatorio;
    }

    public boolean isVisivel() {
        return visivel;
    }

    public void setVisivel(boolean visivel) {
        this.visivel = visivel;
    }

    public GrupoModel getGrupoModel() {
        return grupoModel;
    }

    public void setGrupoModel(GrupoModel grupoModel) {
        this.grupoModel = grupoModel;
    }

    public List<DependenciaModel> getDependencias() {
        return dependencias;
    }

    public void setDependencias(List<DependenciaModel> dependencias) {
        this.dependencias = dependencias;
    }

    @ManyToOne
    @JoinColumn(name = "grupo_id")
    public GrupoModel grupoModel;

    @OneToMany(mappedBy = "campoModel", cascade = CascadeType.ALL, orphanRemoval = true)
    public List<DependenciaModel> dependencias = new ArrayList<>();
}
