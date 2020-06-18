package br.com.tt.petshop.dto;

import org.hibernate.validator.constraints.br.CPF;

public class ClienteEntradaDto {

    private String nome;

    @CPF
    private String cpf;

    public ClienteEntradaDto(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome.replaceAll("^[a-zA-Z0-9 ]*", " ")
                .replaceAll("[ ]*", " ");
    }

    public String getNomeOriginal(){
        return nome;
    }

    public String getCpf() {
        return cpf;
    }
}
