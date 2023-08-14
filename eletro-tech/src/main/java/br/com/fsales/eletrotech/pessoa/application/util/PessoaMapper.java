package br.com.fsales.eletrotech.pessoa.application.util;

import br.com.fsales.eletrotech.pessoa.domain.entity.PessoaEntity;
import br.com.fsales.eletrotech.pessoa.domain.enumeration.ParentescoEnum;
import br.com.fsales.eletrotech.pessoa.domain.enumeration.SexoEnum;
import br.com.fsales.eletrotech.pessoa.presentation.dto.ListarPessoaRequest;
import br.com.fsales.eletrotech.pessoa.presentation.dto.PessoaRequest;

import java.util.Collection;
import java.util.stream.Stream;

public final class PessoaMapper {

    private PessoaMapper() {
    }


    /**
     * @param pessoaRequest
     * @return PessoaEntity
     */
    public static PessoaEntity fromRequestToPessoa(
            final PessoaRequest pessoaRequest
    ) {
        return new PessoaEntity()
                .setNome(pessoaRequest.nome())
                .setSobrenome(pessoaRequest.sobrenome())
                .setDataNascimento(pessoaRequest.dataNascimento())
                .setCpf(pessoaRequest.cpf())
                .setSexo(SexoEnum.getEnum(pessoaRequest.siglaSexo()))
                .setParentesco(ParentescoEnum.getEnum(pessoaRequest.siglaParentesco()));
    }

    /**
     * @param pessoasRequest
     * @return Optional<Stream < PessoaEntity>>
     */
    public static Stream<PessoaEntity> fromRequestToPessoa(
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
    public static PessoaEntity fromRequestToPessoa(
            final ListarPessoaRequest pessoaRequest
    ) {
        return new PessoaEntity()
                .setNome(pessoaRequest.nome())
                .setSobrenome(pessoaRequest.sobrenome());
    }
}
