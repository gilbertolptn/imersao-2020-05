package br.com.tt.petshop.controller;

import br.com.tt.petshop.model.Cliente;
import br.com.tt.petshop.service.ClienteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin/cliente")
public class ClienteController {

    private ClienteService clienteService;

    public ClienteController(
            ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @RequestMapping("lista")
    public String listarClientes(Model model){

        List<Cliente> clientes =
                clienteService.listarClientes();
        model.addAttribute("clientes", clientes);

        return "cliente_lista";
    }
}
