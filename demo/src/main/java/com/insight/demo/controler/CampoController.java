package com.insight.demo.controler;

import com.insight.demo.model.CampoModel;
import com.insight.demo.service.CampoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/campos")
public class CampoController{

    private final CampoService campoService;

    public CampoController(CampoService campoService) {
        this.campoService = campoService;
    }

    @GetMapping
    public List<CampoModel> listarTodos() {
        return campoService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CampoModel> buscarPorId(@PathVariable Long id) {
        return campoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public CampoModel salvar(@RequestBody CampoModel campo) {
        return campoService.salvar(campo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CampoModel> atualizar(@PathVariable Long id, @RequestBody CampoModel campo) {
        try {
            return ResponseEntity.ok(campoService.atualizar(id, campo));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        campoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}

