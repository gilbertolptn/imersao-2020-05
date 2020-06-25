package br.com.tt.petshop.service;

import br.com.tt.petshop.repository.RelatorioClienteRepository;
import br.com.tt.petshop.model.projection.ClienteRelatorioProjection;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RelatorioService {

    private final RelatorioClienteRepository relatorioClienteRepository;

    public RelatorioService(RelatorioClienteRepository relatorioClienteRepository) {
        this.relatorioClienteRepository = relatorioClienteRepository;
    }

    public List<ClienteRelatorioProjection> listarRelatorioClientes(){
        return relatorioClienteRepository.listarRelatorioClientes();
    }

}
