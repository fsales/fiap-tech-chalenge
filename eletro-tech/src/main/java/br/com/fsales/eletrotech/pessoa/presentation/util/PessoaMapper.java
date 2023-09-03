package br.com.fsales.eletrotech.pessoa.presentation.util;

import br.com.fsales.eletrotech.pessoa.application.dto.PessoaAtualizarDTO;
import br.com.fsales.eletrotech.pessoa.application.dto.PessoaCadastroDTO;
import br.com.fsales.eletrotech.pessoa.application.dto.PessoaListarDTO;
import br.com.fsales.eletrotech.pessoa.presentation.dto.DadosAtualizarPessoaRequest;
import br.com.fsales.eletrotech.pessoa.presentation.dto.ListarPessoaRequest;
import br.com.fsales.eletrotech.pessoa.presentation.dto.PessoaRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PessoaMapper {

    PessoaMapper INSTANCE = Mappers.getMapper(PessoaMapper.class);

    /**
     * @param request
     * @return
     */
    PessoaCadastroDTO pessoaRequestToPessoaCadastroDTO(PessoaRequest request);

    /**
     * @param request
     * @return
     */
    PessoaAtualizarDTO pessoaRequestToPessoaAtualizarDTO(DadosAtualizarPessoaRequest request);

    PessoaListarDTO pessoaRequestToListaPessoaDTO(ListarPessoaRequest request);
}
