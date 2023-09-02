package br.com.fsales.eletrotech.endereco.presentation.util;

import br.com.fsales.eletrotech.endereco.application.dto.*;
import br.com.fsales.eletrotech.endereco.presentation.dto.*;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface EnderecoCustomerMapper {

    EnderecoCustomerMapper INSTANCE = Mappers.getMapper(EnderecoCustomerMapper.class);


    EnderecoResponse enderecoToEnderecoResponse(EnderecoDTO endereco);

    EnderecoCadastroDTO enderecoRequestToEnderecoCadastro(EnderecoRequest request);

    EnderecoAtualizarDTO enderecoRequestToEnderecoAtualizar(DadosAtualizarEnderecoRequest request);

    FiltroEnderecoListar listarEnderecoRequestToFiltroEnderecoListar(ListarEnderecoRequest request);

    ListarEnderecoResponse enderecoListarToListarEnderecoResponse(EnderecoListar enderecoListar);
}
