package br.com.tt.petshop.dto;

public class UnidadeDto {

    private Integer id;
    private String nome;
    private String endereco;

    public UnidadeDto(Integer id, String nome, String endereco) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
    }

    public String getDescricao() {
        return String.format("%s - %s", nome, endereco);
    }
}