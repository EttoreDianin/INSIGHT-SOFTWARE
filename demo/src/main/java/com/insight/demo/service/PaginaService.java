package com.insight.demo.service;

import com.insight.demo.model.PaginaModel;
import com.insight.demo.repository.PaginaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaginaService {

    private final PaginaRepository paginaRepository;

    public PaginaService(PaginaRepository paginaRepository) {
        this.paginaRepository = paginaRepository;
    }

    public List<PaginaModel> listarTodos() {
        return paginaRepository.findAll();
    }

    public Optional<PaginaModel> buscarPorId(Long id) {
        return paginaRepository.findById(id);
    }

    public PaginaModel salvar(PaginaModel pagina) {
        return paginaRepository.save(pagina);
    }

    public PaginaModel atualizar(Long id, PaginaModel paginaAtualizada) {
        return paginaRepository.findById(id)
                .map(p -> {
                    p.setTitulo(paginaAtualizada.getTitulo());
                    p.setOrdem(paginaAtualizada.getOrdem());
                    p.formularioModel = paginaAtualizada.formularioModel;
                    return paginaRepository.save(p);
                })
                .orElseThrow(() -> new RuntimeException("Página não encontrada com id " + id));
    }

    public void deletar(Long id) {
        paginaRepository.deleteById(id);
    }
}

