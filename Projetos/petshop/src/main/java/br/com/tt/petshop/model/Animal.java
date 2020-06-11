package br.com.tt.petshop.model;

import br.com.tt.petshop.enumeration.TipoAnimal;

import javax.persistence.*;
import java.time.LocalDate;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "TB_ANIMAL")
public class Animal {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "DATA_NASCIMENTO")
    private LocalDate dataNascimento;

    @Column(name = "TIPO_ANIMAL")
    @Enumerated(EnumType.STRING)
    private TipoAnimal tipo;

    @JoinColumn(name = "ID_CLIENTE")
    @ManyToOne
    private Cliente cliente;

    Animal(){
    }
}
