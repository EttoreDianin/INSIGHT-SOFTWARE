package com.insight.demo.service;
import com.insight.demo.model.CampoModel;
import com.insight.demo.repository.CampoRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CampoService {

    private final CampoRepository campoRepository;

    public CampoService(CampoRepository campoRepository) {
        this.campoRepository = campoRepository;
    }

    public List<CampoModel> listarTodos() {
        return campoRepository.findAll();
    }

    public Optional<CampoModel> buscarPorId(Long id) {
        return campoRepository.findById(id);
    }

    public CampoModel salvar(CampoModel campo) {
        return campoRepository.save(campo);
    }

    public CampoModel atualizar(Long id, CampoModel campoAtualizado) {
        return campoRepository.findById(id)
                .map(campo -> {
                    campo.setNome(campoAtualizado.getNome());
                    campo.setLabel(campoAtualizado.getLabel());
                    campo.setTipo(campoAtualizado.getTipo());
                    campo.setOrdem(campoAtualizado.getOrdem());
                    campo.setObrigatorio(campoAtualizado.isObrigatorio());
                    campo.setVisivel(campoAtualizado.isVisivel());
                    campo.setGrupoModel(campoAtualizado.getGrupoModel());
                    return campoRepository.save(campo);
                })
                .orElseThrow(() -> new RuntimeException("Campo não encontrado com id " + id));
    }

    public void deletar(Long id) {
        campoRepository.deleteById(id);
    }
}

