package br.com.tt.petshop.repository;

import br.com.tt.petshop.dto.UnidadeDto;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UnidadeRepository {

    private JdbcTemplate jdbcTemplate;

    public UnidadeRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<UnidadeDto> listarUnidades(){

        return jdbcTemplate
                //.queryForList("select nome from unidade", String.class);
                .query("select id,nome,endereco from unidade",
                        (rs, rowNum) -> new UnidadeDto(
                                            rs.getInt("id"),
                                            rs.getString("nome"),
                                            rs.getString("endereco"))
                );

        //List<String> unidades = Arrays.asList("ZN", "ZS");
        //return unidades;
    }

//    .query("select id,nome,endereco from unidade", this::converteResultSetEmUnidadeDto);
//    private UnidadeDto converteResultSetEmUnidadeDto(ResultSet rs, int rowNum) throws SQLException {
//        return new UnidadeDto(
//                rs.getInt("id"),
//                rs.getString("nome"),
//                rs.getString("endereco"));
//    }
}
