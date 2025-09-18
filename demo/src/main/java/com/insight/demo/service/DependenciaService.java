package com.insight.demo.service;

import com.insight.demo.model.DependenciaModel;
import com.insight.demo.repository.DependenciaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DependenciaService {

    private final DependenciaRepository dependenciaRepository;

    public DependenciaService(DependenciaRepository dependenciaRepository) {
        this.dependenciaRepository = dependenciaRepository;
    }

    public List<DependenciaModel> listarTodos() {
        return dependenciaRepository.findAll();
    }

    public Optional<DependenciaModel> buscarPorId(Long id) {
        return dependenciaRepository.findById(id);
    }

    public DependenciaModel salvar(DependenciaModel dependencia) {
        return dependenciaRepository.save(dependencia);
    }

    public DependenciaModel atualizar(Long id, DependenciaModel dependenciaAtualizada) {
        return dependenciaRepository.findById(id)
                .map(dep -> {
                    dep.setCampoDependente(dependenciaAtualizada.getCampoDependente());
                    dep.setValorEsperado(dependenciaAtualizada.getValorEsperado());
                    dep.setCampoModel(dependenciaAtualizada.getCampoModel());
                    return dependenciaRepository.save(dep);
                })
                .orElseThrow(() -> new RuntimeException("Dependência não encontrada com id " + id));
    }

    public void deletar(Long id) {
        dependenciaRepository.deleteById(id);
    }
}
