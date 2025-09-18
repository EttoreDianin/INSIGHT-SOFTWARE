package com.insight.demo.service;

import com.insight.demo.model.GrupoModel;
import com.insight.demo.repository.GrupoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GrupoService {

    private final GrupoRepository grupoRepository;

    public GrupoService(GrupoRepository grupoRepository) {
        this.grupoRepository = grupoRepository;
    }

    public List<GrupoModel> listarTodos() {
        return grupoRepository.findAll();
    }

    public Optional<GrupoModel> buscarPorId(Long id) {
        return grupoRepository.findById(id);
    }

    public GrupoModel salvar(GrupoModel grupo) {
        return grupoRepository.save(grupo);
    }

    public GrupoModel atualizar(Long id, GrupoModel grupoAtualizado) {
        return grupoRepository.findById(id)
                .map(g -> {
                    g.setTitulo(grupoAtualizado.getTitulo());
                    g.setOrdem(grupoAtualizado.getOrdem());
                    g.paginaModel = grupoAtualizado.paginaModel;
                    g.campoModels = grupoAtualizado.campoModels;
                    return grupoRepository.save(g);
                })
                .orElseThrow(() -> new RuntimeException("Grupo não encontrado com id " + id));
    }

    public void deletar(Long id) {
        grupoRepository.deleteById(id);
    }
}
