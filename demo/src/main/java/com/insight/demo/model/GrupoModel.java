package com.insight.demo.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class GrupoModel {
    @Id
    @GeneratedValue
    private Long id;
    private String titulo;
    private Integer ordem;

    public GrupoModel(Long id, String titulo, Integer ordem) {
        this.id = id;
        this.titulo = titulo;
        this.ordem = ordem;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getOrdem() {
        return ordem;
    }

    public void setOrdem(Integer ordem) {
        this.ordem = ordem;
    }

    @ManyToOne
    @JoinColumn(name = "pagina_id")
    public PaginaModel paginaModel;

    @OneToMany(mappedBy = "grupoModel", cascade = CascadeType.ALL, orphanRemoval = true)
    public List<CampoModel> campoModels = new ArrayList<>();
}
