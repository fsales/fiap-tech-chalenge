package br.com.fsales.eletrotech.dominio.endereco.service;

import br.com.fsales.eletrotech.dominio.endereco.dto.DadosAtualizarEnderecoRequest;
import br.com.fsales.eletrotech.dominio.endereco.dto.EnderecoRequest;
import br.com.fsales.eletrotech.dominio.endereco.dto.ListarEnderecoRequest;
import br.com.fsales.eletrotech.dominio.endereco.entitie.Endereco;
import br.com.fsales.eletrotech.dominio.endereco.entitie.EnderecoId;
import br.com.fsales.eletrotech.dominio.endereco.integracao.IValidarEnderecoIntegracao;
import br.com.fsales.eletrotech.dominio.endereco.projection.EnderecoProjection;
import br.com.fsales.eletrotech.dominio.endereco.repository.IEnderecoRepository;
import br.com.fsales.eletrotech.dominio.endereco.util.EnderecoCustomerMapper;
import br.com.fsales.eletrotech.dominio.endereco.validacao.ValidarEndereco;
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

    private final EnderecoCustomerMapper enderecoMapper;

    private final List<ValidarEndereco> validadores;

    /**
     * @param filtro
     * @param pageable
     * @return
     */
    @Override
    public Page<EnderecoProjection> consultaPaginada(
            final ListarEnderecoRequest filtro,
            final Pageable pageable
    ) {

        return enderecoRepository.consultarEnderecoPaginado(
                filtro,
                pageable
        );
    }

    /**
     * @param enderecoRequest
     * @return
     */
    @Override
    @Transactional
    public Endereco cadastrar(
            final EnderecoRequest enderecoRequest
    ) {

        log.debug("Salvando endereço");

        // validar
        validadores.forEach(v -> v.validar(enderecoRequest));

        var estado = enderecoMapper.enderecoRequestToEndereco(
                enderecoRequest
        );

        // definindo o ID de endereço da chave composta
        estado.getEnderecoId().setId(UUID.randomUUID());

        return enderecoRepository.save(
                estado
        );
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Endereco detalhar(
            final UUID id,
            final UUID idPessoa
    ) {

        return enderecoRepository.findById(new EnderecoId(id, idPessoa))
                .orElseThrow(
                        () -> new NotFoundException("Endere\u00E7o n\u00E3o encontrado.")
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
     * @param enderecoRequest
     * @return
     */
    @Override
    @Transactional
    public Endereco atualizar(DadosAtualizarEnderecoRequest enderecoRequest) {

        validadores.forEach(v -> v.validar(enderecoRequest));
        var enderecoExistente = enderecoRepository.getReferenceById(
                new EnderecoId(
                        enderecoRequest.id(),
                        enderecoRequest.idPessoa()
                )
        );


        enderecoMapper.update(enderecoRequest, enderecoExistente);

        return enderecoExistente;
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
