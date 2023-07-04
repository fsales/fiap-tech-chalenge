package br.com.fsales.eletrotech.dominio.pessoa.util;

import br.com.fsales.eletrotech.dominio.pessoa.dto.DadosAtualizarPessoaRequest;
import br.com.fsales.eletrotech.dominio.pessoa.entitie.Pessoa;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PessoaCustomerMapper {

    PessoaCustomerMapper INSTANCE = Mappers.getMapper(PessoaCustomerMapper.class);

    /**
     * @param pessoaRequest
     * @return
     */
    Pessoa fromPessoa(DadosAtualizarPessoaRequest pessoaRequest);

    /**
     * @param entity
     * @param updateEntity
     */
    @Mapping(target = "id", ignore = true)
    void update(@MappingTarget Pessoa entity, Pessoa updateEntity);

    /**
     * @param pessoaRequest
     * @param pessoa
     */
    @InheritConfiguration
    @Mapping(target = "parent", ignore = true)
    void updatePessoaFromPessoaRequest(
            DadosAtualizarPessoaRequest pessoaRequest,
            @MappingTarget Pessoa pessoa
    );


}
