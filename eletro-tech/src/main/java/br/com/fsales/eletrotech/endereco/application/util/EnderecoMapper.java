package br.com.fsales.eletrotech.endereco.application.util;

import br.com.fsales.eletrotech.endereco.application.dto.EnderecoAtualizarDTO;
import br.com.fsales.eletrotech.endereco.application.dto.EnderecoCadastroDTO;
import br.com.fsales.eletrotech.endereco.application.dto.EnderecoDTO;
import br.com.fsales.eletrotech.endereco.application.dto.EnderecoListarDTO;
import br.com.fsales.eletrotech.endereco.domain.entity.EnderecoEntity;
import br.com.fsales.eletrotech.endereco.domain.projection.EnderecoProjection;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface EnderecoMapper {

    EnderecoMapper INSTANCE = Mappers.getMapper(EnderecoMapper.class);

    EnderecoDTO enderecoToEnderecoDTO(EnderecoEntity endereco);

    EnderecoListarDTO enderecoProjectionToEnderecoListar(EnderecoProjection enderecoProjection);

    /**
     * @param endereco
     * @return
     */
    @Mapping(target = "estado", expression = "java(br.com.fsales.eletrotech.endereco.domain.enumeration.EstadoEnum.getEnum(endereco.siglaEstado()))")
    @Mapping(target = "pessoa.id", source = "idPessoa")
    @Mapping(target = "enderecoId.idPessoa", source = "idPessoa")
    EnderecoEntity enderecoCadastroToEndereco(EnderecoCadastroDTO endereco);

    /**
     * @param enderecoRequest
     * @param endereco
     */
    @InheritConfiguration
    @Mapping(target = "estado", expression = "java(br.com.fsales.eletrotech.endereco.domain.enumeration.EstadoEnum.getEnum(enderecoRequest.siglaEstado()))")
    @Mapping(target = "enderecoId", ignore = true)
    void update(EnderecoAtualizarDTO enderecoRequest, @MappingTarget EnderecoEntity endereco);
}
