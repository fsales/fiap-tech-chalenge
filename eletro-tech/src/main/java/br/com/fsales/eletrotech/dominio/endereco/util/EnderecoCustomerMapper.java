package br.com.fsales.eletrotech.dominio.endereco.util;

import br.com.fsales.eletrotech.dominio.endereco.dto.DadosAtualizarEnderecoRequest;
import br.com.fsales.eletrotech.dominio.endereco.dto.EnderecoRequest;
import br.com.fsales.eletrotech.dominio.endereco.dto.EnderecoResponse;
import br.com.fsales.eletrotech.dominio.endereco.dto.ListarEnderecoResponse;
import br.com.fsales.eletrotech.dominio.endereco.entitie.Endereco;
import br.com.fsales.eletrotech.dominio.endereco.projection.EnderecoProjection;
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

    @Mapping(target = "estadoEnum", expression = "java(br.com.fsales.eletrotech.dominio.endereco.enumeration.EstadoEnum.getEnum(endereco.getSiglaEstado()))")
    ListarEnderecoResponse enderecoProjectionToListarEnderecoResponse(EnderecoProjection endereco);



    /**
     * @param enderecoRequest
     * @return
     */
    @Mapping(target = "pessoa.id", source = "idPessoa")
    @Mapping(target = "estado", expression = "java(br.com.fsales.eletrotech.dominio.endereco.enumeration.EstadoEnum.getEnum(enderecoRequest.siglaEstado()))")
    Endereco enderecoRequestToEndereco(EnderecoRequest enderecoRequest);

    /**
     * @param enderecoRequest
     * @param endereco
     */
    @InheritConfiguration
    @Mapping(target = "estado", expression = "java(br.com.fsales.eletrotech.dominio.endereco.enumeration.EstadoEnum.getEnum(enderecoRequest.siglaEstado()))")
    void update(DadosAtualizarEnderecoRequest enderecoRequest, @MappingTarget Endereco endereco);

}
