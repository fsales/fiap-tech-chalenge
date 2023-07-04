package br.com.fsales.eletrotech.dominio.endereco.util;

import br.com.fsales.eletrotech.dominio.endereco.dto.DadosAtualizarEnderecoRequest;
import br.com.fsales.eletrotech.dominio.endereco.dto.EnderecoRequest;
import br.com.fsales.eletrotech.dominio.endereco.dto.EnderecoResponse;
import br.com.fsales.eletrotech.dominio.endereco.entitie.Endereco;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface EnderecoCustomerMapper {

    EnderecoCustomerMapper INSTANCE = Mappers.getMapper(EnderecoCustomerMapper.class);

    /**
     * @param endereco
     * @return
     */

    EnderecoResponse enderecoToEnderecoResponse(Endereco endereco);

    /**
     * @param enderecoRequest
     * @return
     */
    Endereco enderecoRequestToEndereco(EnderecoRequest enderecoRequest);

    /**
     * @param enderecoRequest
     * @param endereco
     */
    @InheritConfiguration
    void update(DadosAtualizarEnderecoRequest enderecoRequest, @MappingTarget Endereco endereco);

}
