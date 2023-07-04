package br.com.fsales.eletrotech.dominio.eletrodomestico.util;

import br.com.fsales.eletrotech.dominio.eletrodomestico.dto.DadosAtualizarEletrodomesticoRequest;
import br.com.fsales.eletrotech.dominio.eletrodomestico.dto.EletrodomesticoRequest;
import br.com.fsales.eletrotech.dominio.eletrodomestico.dto.EletrodomesticoResponse;
import br.com.fsales.eletrotech.dominio.eletrodomestico.entitie.Eletrodomestico;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface EletrodomesticoCustomerMapper {

    EletrodomesticoCustomerMapper INSTANCE = Mappers.getMapper(EletrodomesticoCustomerMapper.class);

    /**
     * @param eletrodomestico
     * @return
     */
    EletrodomesticoResponse eletrodomesticoToEletrodomesticoResponse(Eletrodomestico eletrodomestico);

    /**
     * @param eletrodomesticoRequest
     * @return
     */
    Eletrodomestico eletrodomesticoRequestToEletrodomestico(EletrodomesticoRequest eletrodomesticoRequest);

    /**
     * @param enderecoRequest
     * @param eletrodomestico
     */
    @InheritConfiguration
    void update(DadosAtualizarEletrodomesticoRequest enderecoRequest, @MappingTarget Eletrodomestico eletrodomestico);

}
