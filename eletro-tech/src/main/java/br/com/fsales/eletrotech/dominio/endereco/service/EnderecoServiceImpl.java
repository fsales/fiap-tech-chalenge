package br.com.fsales.eletrotech.dominio.endereco.service;

import br.com.fsales.eletrotech.dominio.endereco.dto.DadosAtualizarEnderecoRequest;
import br.com.fsales.eletrotech.dominio.endereco.dto.EnderecoRequest;
import br.com.fsales.eletrotech.dominio.endereco.dto.ListarEnderecoRequest;
import br.com.fsales.eletrotech.dominio.endereco.entitie.Endereco;
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
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j

public class EnderecoServiceImpl implements EnderecoService {

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

        return enderecoRepository.save(
                estado
        );
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Endereco detalhar(final UUID id) {

        return enderecoRepository.findById(id)
                .orElseThrow(
                        () -> new NotFoundException("Endere\u00E7o n\u00E3o encontrado.")
                );
    }

    /**
     * @param id
     */
    @Override
    @Transactional
    public void excluir(UUID id) {
        enderecoRepository
                .deleteById(id);
    }

    /**
     * @param enderecoRequest
     * @return
     */
    @Override
    @Transactional
    public Endereco atualizar(DadosAtualizarEnderecoRequest enderecoRequest) {

        validadores.forEach(v -> v.validar(enderecoRequest));
        var enderecoExistente = enderecoRepository.getReferenceById(enderecoRequest.id());


        enderecoMapper.update(enderecoRequest, enderecoExistente);

        return enderecoExistente;
    }
}
