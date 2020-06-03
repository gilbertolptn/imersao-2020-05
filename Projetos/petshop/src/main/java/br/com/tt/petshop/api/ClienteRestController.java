package br.com.tt.petshop.api;

import br.com.tt.petshop.model.Cliente;
import br.com.tt.petshop.service.ClienteService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClienteRestController {

    private final ClienteService clienteService;

    public ClienteRestController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping(value = "/clientes", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Cliente> lista(){
        return clienteService.listarClientes();
    }

    @GetMapping(value = "/clientes/{clienteId}", produces = "application/json")
    public Cliente buscarPorId(@PathVariable("clienteId") Integer id){
        return clienteService.buscarPorId(id);
    }

    //Put /clientes/{id} -> body json (campos do objeto a ser atualizado!)
    @PutMapping("/clientes/{idCliente}")
    public ResponseEntity atualizar(@PathVariable("idCliente") Integer idCliente,
                                    @RequestBody Cliente cliente){
        clienteService.atualizar(idCliente, cliente);
        return ResponseEntity.noContent().build();
    }
}
