package br.com.fsales.eletrotech.dominio.pessoa.controller;

import br.com.fsales.eletrotech.dominio.pessoa.dto.PessoaResponse;
import br.com.fsales.eletrotech.dominio.pessoa.entitie.Pessoa;

import java.util.ArrayList;
import java.util.Collection;

public final class PessoaDtoMapper {

    private PessoaDtoMapper() {
    }

    public static PessoaResponse fromPessoaToResponse(
            Pessoa pessoa
    ) {

        // parent
        PessoaResponse parent = null;
        if (pessoa.getParent() != null)
            parent = fromPessoaToPessoaResponse(pessoa);

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

        return new PessoaResponse(
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
    }

    private static PessoaResponse fromPessoaToPessoaResponse(
            Pessoa pessoa,
            PessoaResponse parent,
            Collection<PessoaResponse> dependentes
    ) {
        return new PessoaResponse(
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
    }
}
