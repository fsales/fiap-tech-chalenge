package br.com.fsales.eletrotech.eletrodomestico.presentation.util;

import br.com.fsales.eletrotech.eletrodomestico.aplication.dto.EletrodomesticoAtualizarDTO;
import br.com.fsales.eletrotech.eletrodomestico.aplication.dto.EletrodomesticoCadastroDTO;
import br.com.fsales.eletrotech.eletrodomestico.aplication.dto.EletrodomesticoDTO;
import br.com.fsales.eletrotech.eletrodomestico.aplication.dto.FiltroListarEletrodomesticoDTO;
import br.com.fsales.eletrotech.eletrodomestico.domain.projection.EletrodomesticoProjection;
import br.com.fsales.eletrotech.eletrodomestico.presentation.dto.DadosAtualizarEletrodomesticoRequest;
import br.com.fsales.eletrotech.eletrodomestico.presentation.dto.EletrodomesticoRequest;
import br.com.fsales.eletrotech.eletrodomestico.presentation.dto.EletrodomesticoResponse;
import br.com.fsales.eletrotech.eletrodomestico.presentation.dto.ListarEletrodomesticoRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface EletrodomesticoCustomerMapper {
    EletrodomesticoCustomerMapper INSTANCE = Mappers.getMapper(EletrodomesticoCustomerMapper.class);

    EletrodomesticoResponse eletrodomesticoToEletrodomesticoResponse(EletrodomesticoDTO eletrodomestico);

    FiltroListarEletrodomesticoDTO listarEletrodomesticoRequestToFiltroListarEletrodomestico(ListarEletrodomesticoRequest eletrodomesticoRequest);

    EletrodomesticoCadastroDTO eletrodomesticoRequestToEletrodomesticoCadastro(EletrodomesticoRequest eletrodomestico);

    EletrodomesticoAtualizarDTO eletrodomesticoRequestToEletrodomesticoAtualizar(DadosAtualizarEletrodomesticoRequest request);

    @Mapping(target = "pessoa.idPessoa", source = "pessoa.id")
    @Mapping(target = "pessoa.parent.idPessoa", source = "pessoa.parent.id")
    EletrodomesticoDTO eletrodomesticoToEletrodomesticoResponse(EletrodomesticoProjection eletrodomestico);
}
