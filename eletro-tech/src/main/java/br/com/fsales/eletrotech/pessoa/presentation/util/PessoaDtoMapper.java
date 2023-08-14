package br.com.fsales.eletrotech.pessoa.presentation.util;

import br.com.fsales.eletrotech.pessoa.application.dto.PessoaDTO;
import br.com.fsales.eletrotech.pessoa.presentation.dto.PessoaResponse;

import java.util.LinkedHashSet;
import java.util.Set;

public final class PessoaDtoMapper {

    private PessoaDtoMapper() {
    }

    /**
     * @param pessoa
     * @return
     */
    public static PessoaResponse fromPessoaToResponse(
            PessoaDTO pessoa
    ) {

        // parent
        PessoaResponse parent = null;
        if (pessoa.parent() != null)
            parent = fromPessoaToPessoaResponse(pessoa.parent());

        // dependentes
        var dependentes = new LinkedHashSet<PessoaResponse>();


        if (pessoa.dependentes() != null)
            pessoa.dependentes().forEach(dependente -> dependentes.add(PessoaDtoMapper.fromPessoaToPessoaResponse(dependente)));

        return PessoaDtoMapper.fromPessoaToPessoaResponse(
                pessoa,
                parent,
                dependentes
        );
    }

    private static PessoaResponse fromPessoaToPessoaResponse(PessoaDTO pessoa) {

        if (pessoa == null) return null;

        var pessoaResponse = new PessoaResponse(
                pessoa.id(),
                pessoa.nome(),
                pessoa.sobrenome(),
                pessoa.dataNascimento(),
                pessoa.cpf(),
                pessoa.created(),
                pessoa.updated(),
                pessoa.descricaoParentesco(),
                pessoa.siglaParentesco(),
                pessoa.tipoPessoa(),
                pessoa.sexoDescricao()
        );

        adicinarEnderecoResponse(pessoa, pessoaResponse);

        return pessoaResponse;
    }

    private static void adicinarEnderecoResponse(PessoaDTO pessoa, PessoaResponse pessoaResponse) {
        Set<PessoaDTO.EnderecoDTO> enderecos = pessoa.enderecos();

        if (enderecos != null && !enderecos.isEmpty())
            pessoaResponse
                    .enderecos()
                    .addAll(
                            PessoaResponse.EnderecoResponse
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
            PessoaDTO pessoa,
            PessoaResponse parent,
            Set<PessoaResponse> dependentes
    ) {
        var pessoaRequest = new PessoaResponse(
                pessoa.id(),
                pessoa.nome(),
                pessoa.sobrenome(),
                pessoa.dataNascimento(),
                pessoa.cpf(),
                parent,
                pessoa.created(),
                pessoa.updated(),
                dependentes,
                pessoa.descricaoParentesco(),
                pessoa.siglaParentesco(),
                pessoa.tipoPessoa(),
                pessoa.sexoDescricao()
        );

        adicinarEnderecoResponse(
                pessoa,
                pessoaRequest
        );

        return pessoaRequest;
    }
}
