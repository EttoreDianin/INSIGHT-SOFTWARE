package com.insight.demo.controler;

import com.insight.demo.model.PaginaModel;
import com.insight.demo.service.PaginaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/paginas")
public class PaginaController {

    private final PaginaService paginaService;

    public PaginaController(PaginaService paginaService) {
        this.paginaService = paginaService;
    }

    @GetMapping
    public List<PaginaModel> listarTodos() {
        return paginaService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaginaModel> buscarPorId(@PathVariable Long id) {
        return paginaService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public PaginaModel salvar(@RequestBody PaginaModel pagina) {
        return paginaService.salvar(pagina);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PaginaModel> atualizar(@PathVariable Long id,
                                                 @RequestBody PaginaModel pagina) {
        try {
            return ResponseEntity.ok(paginaService.atualizar(id, pagina));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        paginaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}

