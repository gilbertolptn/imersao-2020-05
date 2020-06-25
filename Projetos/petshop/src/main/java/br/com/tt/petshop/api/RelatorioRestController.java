package br.com.tt.petshop.api;

import br.com.tt.petshop.model.projection.ClienteRelatorioProjection;
import br.com.tt.petshop.service.RelatorioService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RelatorioRestController {

    private final RelatorioService relatorioService;

    public RelatorioRestController(RelatorioService relatorioService) {
        this.relatorioService = relatorioService;
    }

    @GetMapping("/relatorio/cliente")
    public List<ClienteRelatorioProjection> listarRelatorioClientes(){
        return relatorioService.listarRelatorioClientes();
    }

}
