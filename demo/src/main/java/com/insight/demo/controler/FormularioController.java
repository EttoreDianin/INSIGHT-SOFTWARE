package com.insight.demo.controler;

import com.insight.demo.model.FormularioModel;
import com.insight.demo.service.FormularioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/formularios")
public class FormularioController {

    private final FormularioService formularioService;

    public FormularioController(FormularioService formularioService) {
        this.formularioService = formularioService;
    }

    @GetMapping
    public List<FormularioModel> listarTodos() {
        return formularioService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FormularioModel> buscarPorId(@PathVariable Long id) {
        return formularioService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public FormularioModel salvar(@RequestBody FormularioModel formulario) {
        return formularioService.salvar(formulario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FormularioModel> atualizar(@PathVariable Long id,
                                                     @RequestBody FormularioModel formulario) {
        try {
            return ResponseEntity.ok(formularioService.atualizar(id, formulario));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        formularioService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
