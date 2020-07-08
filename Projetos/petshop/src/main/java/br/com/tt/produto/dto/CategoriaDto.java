package br.com.tt.produto.dto;

import br.com.tt.produto.Categoria;

public class CategoriaDto {
    private String nome;

    private CategoriaDto(Categoria categoria) {
        if(categoria != null){
            this.nome = categoria.getNome();
        }
    }

    public static CategoriaDto fromEntity(Categoria categoria){
        return new CategoriaDto(categoria);
    }
}
