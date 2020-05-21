package br.com.tt.petshop.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Cliente {

    @Id
    private Integer id;
    private String nome;
    private String cpf;
}
