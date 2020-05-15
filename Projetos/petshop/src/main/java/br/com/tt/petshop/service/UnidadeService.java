package br.com.tt.petshop.service;

import br.com.tt.petshop.repository.UnidadeRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UnidadeService {

    private UnidadeRepository unidadeRepository;

    //Services/Controllers/Repositories - NUNCA tem atributo específico de algum sessão/usuário
    //private String nomeUsuario;

    public UnidadeService(UnidadeRepository unidadeRepository){
        this.unidadeRepository = unidadeRepository;
    }

    public List<String> listarUnidades(){
        return unidadeRepository.listarUnidades();
    }
}
