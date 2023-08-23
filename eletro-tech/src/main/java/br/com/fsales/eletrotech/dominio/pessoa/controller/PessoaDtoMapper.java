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
        if (pessoa.getParent() != null)
            parent = fromPessoaToPessoaResponse(pessoa.getParent());

        // dependentes
        var dependentes = new ArrayList<PessoaResponse>();

        if (pessoa.getDependentes() != null)
            pessoa.getDependentes().forEach(dependente -> dependentes.add(PessoaDtoMapper.fromPessoaToPessoaResponse(dependente)));

        return PessoaDtoMapper.fromPessoaToPessoaResponse(
                pessoa,
                parent,
                dependentes
        );
    }

    private static PessoaResponse fromPessoaToPessoaResponse(Pessoa pessoa) {

        if (pessoa == null) return null;

        var pessoaResponse = new PessoaResponse(
                pessoa.getId(),
                pessoa.getNome(),
                pessoa.getSobrenome(),
                pessoa.getDataNascimento(),
                pessoa.getCpf(),
                pessoa.getSexo(),
                pessoa.getParentesco(),
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
                pessoa.getId(),
                pessoa.getNome(),
                pessoa.getSobrenome(),
                pessoa.getDataNascimento(),
                pessoa.getCpf(),
                pessoa.getSexo(),
                pessoa.getParentesco(),
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
