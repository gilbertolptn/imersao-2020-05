package br.com.tt.petshop.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CpfValidatorTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void deveriaValidarCpfSemFormatacao() {
        //Preparação
        String cpf = "00011122233";

        //Ação
        boolean resultado = new CpfValidator().verifica(cpf);

        //Verificação
        Assertions.assertTrue(resultado, "Deveria ser um CPF Válido!");
    }

    @Test
    void deveriaFalharCpfSemFormatacaoComLetras() {
        //Preparação
        String cpf = "0001A12223A";

        //Ação
        boolean resultado = new CpfValidator().verifica(cpf);

        //Verificação
        Assertions.assertFalse(resultado, "Deveria ser um CPF Inválido pois tem letras!");
    }

    @Test
    void deveriaValidarCpfComFormatacao() {
        //Preparação
        String cpf = "000.111.222-33";

        //Ação
        boolean resultado = new CpfValidator().verifica(cpf);

        //Verificação
        Assertions.assertTrue(resultado, "Deveria ser um CPF Válido");
    }

    //deveriaFalharEmCpfComFormatacaoELetras
    //deveriaFalharEmCpfComFormatacaoIncorreta
    //deveriaFalharComCpfMenorQue11Digitos
    //deveriaFalharComCpfMaiorQue14Digitos

}