package br.com.fsales.eletrotech.eletrodomestico.aplication.util;

import br.com.fsales.eletrotech.eletrodomestico.aplication.dto.EletrodomesticoAtualizarDTO;
import br.com.fsales.eletrotech.eletrodomestico.aplication.dto.EletrodomesticoCadastroDTO;
import br.com.fsales.eletrotech.eletrodomestico.aplication.dto.EletrodomesticoDTO;
import br.com.fsales.eletrotech.eletrodomestico.domain.entity.EletrodomesticoEntity;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface EletrodomesticoMapper {

    EletrodomesticoMapper INSTANCE = Mappers.getMapper(EletrodomesticoMapper.class);

    @Mapping(target = "endereco", source = "endereco")
    @Mapping(target = "idEndereco", source = "endereco.id")
    @Mapping(target = "pessoa", source = "pessoa")
    @Mapping(target = "pessoa.idPessoa", source = "pessoa.id")
    @Mapping(target = "idPessoa", source = "pessoa.id")
    EletrodomesticoDTO eletrodomesticoToEletrodomestico(EletrodomesticoEntity eletrodomestico);


    @Mapping(target = "endereco.enderecoId.idPessoa", source = "idPessoa")
    @Mapping(target = "endereco.enderecoId.id", source = "idEndereco")
    EletrodomesticoEntity eletrodomesticoCadastroToEletrodomestico(EletrodomesticoCadastroDTO eletrodomesticoCadastro);

    /**
     * @param eletrodomesticoAtualizar
     * @param eletrodomestico
     */
    @InheritConfiguration
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "endereco.enderecoId.idPessoa", source = "idPessoa")
    @Mapping(target = "endereco.enderecoId.id", source = "idEndereco")
    void update(EletrodomesticoAtualizarDTO eletrodomesticoAtualizar, @MappingTarget EletrodomesticoEntity eletrodomestico);
}
