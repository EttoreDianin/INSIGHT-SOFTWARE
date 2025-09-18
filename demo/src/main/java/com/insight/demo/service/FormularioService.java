package com.insight.demo.service;

import com.insight.demo.model.FormularioModel;
import com.insight.demo.repository.FormularioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FormularioService {

    private final FormularioRepository formularioRepository;

    public FormularioService(FormularioRepository formularioRepository) {
        this.formularioRepository = formularioRepository;
    }

    public List<FormularioModel> listarTodos() {
        return formularioRepository.findAll();
    }

    public Optional<FormularioModel> buscarPorId(Long id) {
        return formularioRepository.findById(id);
    }

    public FormularioModel salvar(FormularioModel formulario) {
        return formularioRepository.save(formulario);
    }

    public FormularioModel atualizar(Long id, FormularioModel formularioAtualizado) {
        return formularioRepository.findById(id)
                .map(f -> {
                    f.setNome(formularioAtualizado.getNome());
                    f.paginaModelList = formularioAtualizado.paginaModelList; // atualiza páginas associadas
                    return formularioRepository.save(f);
                })
                .orElseThrow(() -> new RuntimeException("Formulário não encontrado com id " + id));
    }

    public void deletar(Long id) {
        formularioRepository.deleteById(id);
    }
}

