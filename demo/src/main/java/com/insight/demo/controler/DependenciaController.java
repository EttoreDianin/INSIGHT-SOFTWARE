package com.insight.demo.controler;

import com.insight.demo.model.DependenciaModel;
import com.insight.demo.service.DependenciaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dependencias")
public class DependenciaController {

    private final DependenciaService dependenciaService;

    public DependenciaController(DependenciaService dependenciaService) {
        this.dependenciaService = dependenciaService;
    }

    @GetMapping
    public List<DependenciaModel> listarTodos() {
        return dependenciaService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DependenciaModel> buscarPorId(@PathVariable Long id) {
        return dependenciaService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public DependenciaModel salvar(@RequestBody DependenciaModel dependencia) {
        return dependenciaService.salvar(dependencia);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DependenciaModel> atualizar(@PathVariable Long id,
                                                      @RequestBody DependenciaModel dependencia) {
        try {
            return ResponseEntity.ok(dependenciaService.atualizar(id, dependencia));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        dependenciaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
