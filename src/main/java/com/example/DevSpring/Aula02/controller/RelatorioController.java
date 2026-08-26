package com.example.DevSpring.Aula02.controller;

import com.example.DevSpring.Aula02.dto.RelatorioDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(
        value = "/aula02-relatorio",
        method = RequestMethod.POST,
        consumes = "application/json",
        produces = "application/xml"
)
public class RelatorioController {

    @PostMapping
    public ResponseEntity<String> gerarRelatorio(@RequestBody RelatorioDTO relatorio) {
        if(relatorio.getTipo().isBlank()) {
            return ResponseEntity.badRequest().body("Relatorio vazio");
        }

        String xml = """
        <relatorio>
            <tipo>%s</tipo>
            <conteudo>Simulação de relatório de vendas</conteudo>
        </relatorio>
        """.formatted(relatorio.getTipo());

        return ResponseEntity.ok(xml);
    }
}