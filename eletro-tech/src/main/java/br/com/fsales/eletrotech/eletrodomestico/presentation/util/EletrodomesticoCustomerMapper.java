package br.com.fsales.eletrotech.eletrodomestico.presentation.util;

import br.com.fsales.eletrotech.eletrodomestico.aplication.dto.Eletrodomestico;
import br.com.fsales.eletrotech.eletrodomestico.aplication.dto.EletrodomesticoAtualizar;
import br.com.fsales.eletrotech.eletrodomestico.aplication.dto.EletrodomesticoCadastro;
import br.com.fsales.eletrotech.eletrodomestico.aplication.dto.FiltroListarEletrodomestico;
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

    EletrodomesticoResponse eletrodomesticoToEletrodomestico(Eletrodomestico eletrodomestico);

    FiltroListarEletrodomestico listarEletrodomesticoRequestToFiltroListarEletrodomestico(ListarEletrodomesticoRequest eletrodomesticoRequest);

    EletrodomesticoCadastro eletrodomesticoRequestToEletrodomesticoCadastro(EletrodomesticoRequest eletrodomestico);

    EletrodomesticoAtualizar eletrodomesticoRequestToEletrodomesticoAtualizar(DadosAtualizarEletrodomesticoRequest request);

    @Mapping(target = "pessoa.idPessoa", source = "pessoa.id")
    @Mapping(target = "pessoa.parent.idPessoa", source = "pessoa.parent.id")
    Eletrodomestico eletrodomesticoToEletrodomestico(EletrodomesticoProjection eletrodomestico);
}
