package br.com.fsales.eletrotech.dominio.endereco.projection;


import java.util.UUID;

public record PessoaProjection(
        UUID idPessoa,
        String nome,
        String sobrenome,
        PessoaProjection parent
) {

    public PessoaProjection(UUID idPessoa, String nome, String sobrenome) {
        this(idPessoa, nome, sobrenome, null);
    }

}
