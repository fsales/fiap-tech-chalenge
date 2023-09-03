package br.com.fsales.eletrotech.pessoa.application.util;

import br.com.fsales.eletrotech.pessoa.application.dto.PessoaAtualizarDTO;
import br.com.fsales.eletrotech.pessoa.application.dto.PessoaCadastroDTO;
import br.com.fsales.eletrotech.pessoa.application.dto.PessoaDTO;
import br.com.fsales.eletrotech.pessoa.domain.entity.PessoaEntity;
import br.com.fsales.eletrotech.pessoa.presentation.dto.DadosAtualizarPessoaRequest;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.Collection;

@Mapper(componentModel = "spring")
public interface PessoaCustomerMapper {

    PessoaCustomerMapper INSTANCE = Mappers.getMapper(PessoaCustomerMapper.class);
    CycleAvoidingMappingContext CYCLE_AVOIDING_MAPPING_CONTEXT = new CycleAvoidingMappingContext();

    /**
     * @param pessoa
     * @param context
     * @return
     */
    PessoaDTO pessoaCadastroToPessoaEntity(PessoaEntity pessoa, @Context CycleAvoidingMappingContext context);

    /**
     * @param pessoa
     * @param context
     * @return
     */
    @Mapping(target = "sexo", expression = "java(br.com.fsales.eletrotech.pessoa.domain.enumeration.SexoEnum.getEnum(pessoa.siglaSexo()))")
    @Mapping(target = "parentesco", expression = "java(br.com.fsales.eletrotech.pessoa.domain.enumeration.ParentescoEnum.getEnum(pessoa.siglaParentesco()))")
    PessoaEntity pessoaCadastroToPessoaEntity(PessoaCadastroDTO pessoa, @Context CycleAvoidingMappingContext context);

    /**
     * @param pessoaCadastro
     * @param context
     * @return
     */
    Collection<PessoaEntity> pessoaCadastroToPessoaEntity(Collection<PessoaCadastroDTO> pessoaCadastro, @Context CycleAvoidingMappingContext context);


    /**
     * @param pessoaRequest
     * @return
     */
    PessoaEntity fromPessoa(DadosAtualizarPessoaRequest pessoaRequest);

    /**
     * @param entity
     * @param updateEntity
     */
    @Mapping(target = "id", ignore = true)
    void update(@MappingTarget PessoaEntity entity, PessoaEntity updateEntity);

    /**
     * @param pessoaAtualizar
     * @param pessoa
     */
    @InheritConfiguration
    @Mapping(target = "parent", ignore = true)
    @Mapping(target = "sexo", expression = "java(br.com.fsales.eletrotech.pessoa.domain.enumeration.SexoEnum.getEnum(pessoaAtualizar.siglaSexo()))")
    @Mapping(target = "parentesco", expression = "java(br.com.fsales.eletrotech.pessoa.domain.enumeration.ParentescoEnum.getEnum(pessoaAtualizar.siglaParentesco()))")
    void updatePessoaFromPessoaRequest(
            PessoaAtualizarDTO pessoaAtualizar,
            @MappingTarget PessoaEntity pessoa
    );

}
