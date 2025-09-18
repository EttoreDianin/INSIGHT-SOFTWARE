package com.insight.demo.controler;

import com.insight.demo.model.GrupoModel;
import com.insight.demo.service.GrupoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/grupos")
public class GrupoController {

    private final GrupoService grupoService;

    public GrupoController(GrupoService grupoService) {
        this.grupoService = grupoService;
    }

    @GetMapping
    public List<GrupoModel> listarTodos() {
        return grupoService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<GrupoModel> buscarPorId(@PathVariable Long id) {
        return grupoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public GrupoModel salvar(@RequestBody GrupoModel grupo) {
        return grupoService.salvar(grupo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GrupoModel> atualizar(@PathVariable Long id,
                                                @RequestBody GrupoModel grupo) {
        try {
            return ResponseEntity.ok(grupoService.atualizar(id, grupo));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        grupoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
