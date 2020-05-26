package br.com.tt.petshop.service;

import br.com.tt.petshop.model.Cliente;
import br.com.tt.petshop.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ClienteService {

    private ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<Cliente> listarClientes(){
        return this.clienteRepository
                .listarClientes();
    }

    @Transactional//Deixa tudo abaixo de uma transação, ou seja, propricia ROLLBACK!
    //Poderia estar no Repository também, mas é mais comum no Service.
    public void criarCliente(Cliente cliente) {
        //auditoriaReposiory.criaAuditoria(cliente);
        clienteRepository.criarCliente(cliente);
    }
}
