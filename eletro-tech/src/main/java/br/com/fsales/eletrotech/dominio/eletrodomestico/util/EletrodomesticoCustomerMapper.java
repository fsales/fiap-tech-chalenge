package br.com.fsales.eletrotech.dominio.eletrodomestico.util;

import br.com.fsales.eletrotech.dominio.eletrodomestico.dto.DadosAtualizarEletrodomesticoRequest;
import br.com.fsales.eletrotech.dominio.eletrodomestico.dto.EletrodomesticoRequest;
import br.com.fsales.eletrotech.dominio.eletrodomestico.dto.EletrodomesticoResponse;
import br.com.fsales.eletrotech.dominio.eletrodomestico.entitie.Eletrodomestico;
import br.com.fsales.eletrotech.dominio.eletrodomestico.projection.EletrodomesticoProjection;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface EletrodomesticoCustomerMapper {

    EletrodomesticoCustomerMapper INSTANCE = Mappers.getMapper(EletrodomesticoCustomerMapper.class);

    /**
     * @param eletrodomestico
     * @return
     */
    //@Mapping(target = "idPessoa", source = "pessoa.id")
    //@Mapping(target = "idEndereco", source = "endereco.id")
    EletrodomesticoResponse eletrodomesticoToEletrodomesticoResponse(Eletrodomestico eletrodomestico);

    /**
     * @param eletrodomestico
     * @return
     */
    //@Mapping(target = "pessoa.idPessoa", source = "pessoa.id")
    //@Mapping(target = "pessoa.parent.idPessoa", source = "pessoa.parent.id")
    EletrodomesticoResponse eletrodomesticoToEletrodomesticoResponse(EletrodomesticoProjection eletrodomestico);

    /**
     * @param eletrodomesticoRequest
     * @return
     */
    //@Mapping(target = "pessoa.id", source = "idPessoa")
    //@Mapping(target = "endereco.id", source = "idEndereco")
    Eletrodomestico eletrodomesticoRequestToEletrodomestico(EletrodomesticoRequest eletrodomesticoRequest);

    /**
     * @param enderecoRequest
     * @param eletrodomestico
     */
    @InheritConfiguration
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "pessoa", ignore = true)
    @Mapping(target = "endereco", ignore = true)
    void update(DadosAtualizarEletrodomesticoRequest enderecoRequest, @MappingTarget Eletrodomestico eletrodomestico);

}
