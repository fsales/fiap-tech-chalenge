package br.com.fsales.eletrotech.dominio.pessoa.service;

import br.com.fsales.eletrotech.dominio.pessoa.dto.ListarPessoaRequest;
import br.com.fsales.eletrotech.dominio.pessoa.dto.PessoaRequest;
import br.com.fsales.eletrotech.dominio.pessoa.entitie.Pessoa;
import br.com.fsales.eletrotech.dominio.pessoa.enumeration.ParentescoEnum;
import br.com.fsales.eletrotech.dominio.pessoa.enumeration.SexoEnum;

import java.util.Collection;
import java.util.stream.Stream;

public final class PessoaMapper {

    private PessoaMapper() {
    }


    /**
     * @param pessoaRequest
     * @return Pessoa
     */
    public static Pessoa fromRequestToPessoa(
            final PessoaRequest pessoaRequest
    ) {
        return new Pessoa()
                .setNome(pessoaRequest.nome())
                .setSobrenome(pessoaRequest.sobrenome())
                .setDataNascimento(pessoaRequest.dataNascimento())
                .setCpf(pessoaRequest.cpf())
                .setSexo(SexoEnum.getEnum(pessoaRequest.siglaSexo()))
                .setParentesco(ParentescoEnum.getEnum(pessoaRequest.siglaParentesco()));
    }

    /**
     * @param pessoasRequest
     * @return Optional<Stream < Pessoa>>
     */
    public static Stream<Pessoa> fromRequestToPessoa(
            final Collection<PessoaRequest> pessoasRequest
    ) {

        return pessoasRequest
                .stream()
                .map(
                        PessoaMapper::fromRequestToPessoa
                );
    }

    /**
     * @param pessoaRequest
     * @return
     */
    public static Pessoa fromRequestToPessoa(
            final ListarPessoaRequest pessoaRequest
    ) {
        return new Pessoa()
                .setNome(pessoaRequest.nome())
                .setSobrenome(pessoaRequest.sobrenome());
    }
}
