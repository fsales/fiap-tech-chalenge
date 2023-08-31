package br.com.fsales.eletrotech.dominio.pessoa.controller;

import br.com.fsales.eletrotech.dominio.pessoa.dto.EnderecoResponse;
import br.com.fsales.eletrotech.dominio.pessoa.dto.PessoaResponse;
import br.com.fsales.eletrotech.dominio.pessoa.entitie.Pessoa;

import java.util.ArrayList;
import java.util.Collection;

public final class PessoaDtoMapper {

    private PessoaDtoMapper() {
    }

    /**
     * @param pessoa
     * @return
     */
    public static PessoaResponse fromPessoaToResponse(
            Pessoa pessoa
    ) {

        // parent
        PessoaResponse parent = null;
        if (pessoa.parent() != null)
            parent = fromPessoaToPessoaResponse(pessoa.parent());

        // dependentes
        var dependentes = new ArrayList<PessoaResponse>();

        if (pessoa.dependentes() != null)
            pessoa.dependentes().forEach(dependente -> dependentes.add(PessoaDtoMapper.fromPessoaToPessoaResponse(dependente)));

        return PessoaDtoMapper.fromPessoaToPessoaResponse(
                pessoa,
                parent,
                dependentes
        );
    }

    private static PessoaResponse fromPessoaToPessoaResponse(Pessoa pessoa) {

        if (pessoa == null) return null;

        var pessoaResponse = new PessoaResponse(
                pessoa.id(),
                pessoa.nome(),
                pessoa.sobrenome(),
                pessoa.dataNascimento(),
                pessoa.cpf(),
                pessoa.sexo(),
                pessoa.parentesco(),
                pessoa.getCreated(),
                pessoa.getUpdated()
        );

        adicinarEnderecoResponse(pessoa, pessoaResponse);

        return pessoaResponse;
    }

    private static void adicinarEnderecoResponse(Pessoa pessoa, PessoaResponse pessoaResponse) {
        var enderecos = pessoa.enderecos();
        if (enderecos != null && !enderecos.isEmpty())
            pessoaResponse
                    .enderecos()
                    .addAll(
                            EnderecoResponse
                                    .toEnderecoResponse(
                                            enderecos
                                    )
                    );
    }

    /**
     * @param pessoa
     * @param parent
     * @param dependentes
     * @return
     */
    private static PessoaResponse fromPessoaToPessoaResponse(
            Pessoa pessoa,
            PessoaResponse parent,
            Collection<PessoaResponse> dependentes
    ) {
        var pessoaRequest = new PessoaResponse(
                pessoa.id(),
                pessoa.nome(),
                pessoa.sobrenome(),
                pessoa.dataNascimento(),
                pessoa.cpf(),
                pessoa.sexo(),
                pessoa.parentesco(),
                parent,
                pessoa.getCreated(),
                pessoa.getUpdated(),
                dependentes
        );

        adicinarEnderecoResponse(
                pessoa,
                pessoaRequest
        );

        return pessoaRequest;
    }
}
