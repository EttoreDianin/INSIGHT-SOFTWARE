package com.insight.demo.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class FormularioModel{
    @Id
    @GeneratedValue
    private Long id;
    private String nome;

    public FormularioModel(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @OneToMany(mappedBy = "formularioModel", cascade = CascadeType.ALL, orphanRemoval = true)
    public List<PaginaModel> paginaModelList = new ArrayList<>();
}

