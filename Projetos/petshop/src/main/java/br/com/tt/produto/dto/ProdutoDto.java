package br.com.tt.produto.dto;

import br.com.tt.petshop.exception.ErroNegocioException;
import br.com.tt.produto.Produto;

import java.util.Optional;

public class ProdutoDto {
    private String nome;
    private CategoriaDto categoria;

    public ProdutoDto(Produto produto) {
        if(produto == null){
            throw new ErroNegocioException("produto_nulo", "Produto não pode ser nulo!");
        }
        this.nome = produto.getNome();
        this.categoria = CategoriaDto.fromEntity(produto.getCategoria());
    }

//    public ProdutoDto(Produto produto) {
//        Optional.of(produto)
//                .map( prod -> {
//                    this.nome = produto.getNome();
//                    this.categoria = CategoriaDto.fromEntity(produto.getCategoria());
//                    return prod;
//                }).orElseThrow(() -> new RuntimeException("Produto não deve ser nulo"));
//    }

    public String getNome() {
        return nome;
    }

    public CategoriaDto getCategoria() {
        return categoria;
    }
}
