package br.com.tt.petshop.repository;

import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class UnidadeRepository {
    public List<String> listarUnidades(){
        List<String> unidades = Arrays.asList("ZN", "ZS");
        return unidades;
    }
}
