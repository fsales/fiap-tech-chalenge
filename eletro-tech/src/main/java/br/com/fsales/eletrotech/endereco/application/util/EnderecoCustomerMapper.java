package br.com.fsales.eletrotech.endereco.application.util;

import br.com.fsales.eletrotech.endereco.domain.entity.Endereco;
import br.com.fsales.eletrotech.endereco.domain.projection.EnderecoProjection;
import br.com.fsales.eletrotech.endereco.presentation.dto.DadosAtualizarEnderecoRequest;
import br.com.fsales.eletrotech.endereco.presentation.dto.EnderecoRequest;
import br.com.fsales.eletrotech.endereco.presentation.dto.EnderecoResponse;
import br.com.fsales.eletrotech.endereco.presentation.dto.ListarEnderecoResponse;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface EnderecoCustomerMapper {

    EnderecoCustomerMapper INSTANCE = Mappers.getMapper(EnderecoCustomerMapper.class);

    /**
     * @param endereco
     * @return
     */

    EnderecoResponse enderecoToEnderecoResponse(Endereco endereco);

    @Mapping(target = "estadoEnum", expression = "java(br.com.fsales.eletrotech.endereco.domain.enumeration.EstadoEnum.getEnum(endereco.getSiglaEstado()))")
    ListarEnderecoResponse enderecoProjectionToListarEnderecoResponse(EnderecoProjection endereco);



    /**
     * @param enderecoRequest
     * @return
     */
    @Mapping(target = "estado", expression = "java(br.com.fsales.eletrotech.endereco.domain.enumeration.EstadoEnum.getEnum(enderecoRequest.siglaEstado()))")
    @Mapping(target = "pessoa.id", source = "idPessoa")
    @Mapping(target = "enderecoId.idPessoa", source = "idPessoa")
    Endereco enderecoRequestToEndereco(EnderecoRequest enderecoRequest);

    /**
     * @param enderecoRequest
     * @param endereco
     */
    @InheritConfiguration
    @Mapping(target = "estado", expression = "java(br.com.fsales.eletrotech.endereco.domain.enumeration.EstadoEnum.getEnum(enderecoRequest.siglaEstado()))")
    @Mapping(target = "enderecoId", ignore = true)
    void update(DadosAtualizarEnderecoRequest enderecoRequest, @MappingTarget Endereco endereco);

}
