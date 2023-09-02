package br.com.fsales.eletrotech.endereco.application.service;

import br.com.fsales.eletrotech.endereco.application.dto.*;
import br.com.fsales.eletrotech.endereco.application.integracao.IValidarEnderecoIntegracao;
import br.com.fsales.eletrotech.endereco.application.util.EnderecoMapper;
import br.com.fsales.eletrotech.endereco.application.validacao.ValidarEndereco;
import br.com.fsales.eletrotech.endereco.domain.entity.EnderecoId;
import br.com.fsales.eletrotech.endereco.domain.repository.IEnderecoRepository;
import br.com.fsales.eletrotech.infrastructure.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j

public class EnderecoServiceImpl implements EnderecoService, IValidarEnderecoIntegracao {

    private final IEnderecoRepository enderecoRepository;

    private final EnderecoMapper enderecoMapper;

    private final List<ValidarEndereco> validadores;

    /**
     * @param filtro
     * @param pageable
     * @return
     */
    @Override
    public Page<EnderecoListar> consultaPaginada(
            final FiltroEnderecoListar filtro,
            final Pageable pageable
    ) {

        var page = enderecoRepository.consultarEnderecoPaginado(
                filtro,
                pageable
        );

        return page.map(enderecoMapper::enderecoProjectionToEnderecoListar);
    }

    /**
     * @param enderecoDTO
     * @return
     */
    @Override
    @Transactional
    public EnderecoDTO cadastrar(
            final EnderecoCadastroDTO enderecoDTO
    ) {

        log.debug("Salvando endereço");

        // validar
        validadores.forEach(v -> v.validar(enderecoDTO));

        var endereco = enderecoMapper.enderecoCadastroToEndereco(
                enderecoDTO
        );

        // definindo o ID de endereço da chave composta
        endereco.getEnderecoId().setId(UUID.randomUUID());


        return enderecoMapper.enderecoToEnderecoDTO(enderecoRepository.save(
                endereco
        ));
    }

    /**
     * @param id
     * @return
     */
    @Override
    public EnderecoDTO detalhar(
            final UUID id,
            final UUID idPessoa
    ) {

        var endereco = enderecoRepository.findById(new EnderecoId(id, idPessoa))
                .orElseThrow(
                        () -> new NotFoundException("Endere\u00E7o n\u00E3o encontrado.")
                );
        return enderecoMapper.enderecoToEnderecoDTO(
                endereco
        );
    }

    /**
     * @param id
     */
    @Override
    @Transactional
    public void excluir(
            final UUID id,
            final UUID idPessoa
    ) {
        enderecoRepository
                .deleteById(
                        new EnderecoId(
                                id,
                                idPessoa
                        )
                );
    }

    /**
     * @param enderecoDTO
     * @return
     */
    @Override
    @Transactional
    public EnderecoDTO atualizar(EnderecoAtualizarDTO enderecoDTO) {

        validadores.forEach(v -> v.validar(enderecoDTO));
        var enderecoExistente = enderecoRepository.getReferenceById(
                new EnderecoId(
                        enderecoDTO.id(),
                        enderecoDTO.idPessoa()
                )
        );


        enderecoMapper.update(
                enderecoDTO, enderecoExistente
        );

        return enderecoMapper.enderecoToEnderecoDTO(
                enderecoExistente
        );
    }

    /**
     * @param id
     * @return
     */
    @Override
    public boolean verificarSeIdExiste(UUID id, UUID idPessoa) {
        return Objects.nonNull(id) &&
               enderecoRepository.existsById(new EnderecoId(id, idPessoa));
    }
}
