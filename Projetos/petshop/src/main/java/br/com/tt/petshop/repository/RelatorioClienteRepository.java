package br.com.tt.petshop.repository;

import br.com.tt.petshop.model.Cliente;
import br.com.tt.petshop.model.projection.ClienteRelatorioProjection;
import br.com.tt.petshop.model.projection.ClienteSimplificadoProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RelatorioClienteRepository
        extends JpaRepository<Cliente, Integer> {

    @Query("select c.nome as nome, c.cpf as cpf, " +
            " count(a.id) as quantidade from Cliente c left join c.animais a" +
            " group by c.nome, c.cpf")
    List<ClienteRelatorioProjection> listarRelatorioClientes();

    @Query("select c from Cliente c")
    List<ClienteSimplificadoProjection> listaSimplificada();
}
