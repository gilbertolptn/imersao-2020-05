package br.com.tt.petshop.util;

public class CpfValidator {

    /**
     * 00011122233 - valido sem formatação
     * 000.111.222-33 - valido com formatação
     * 000.1111.22-33 - invalido (por causa da máscara inválida)
     */
    public boolean verifica(String cpf){
        // Quantidade de dígitos
        if(cpf.length() == 11){
            if(cpf.matches("\\d*")){
                return true;
            }
        }
        // Formatação (se houver)
        //if()

        //Se não cair em nenhum true, é inválido!
        return false;
    }
}
