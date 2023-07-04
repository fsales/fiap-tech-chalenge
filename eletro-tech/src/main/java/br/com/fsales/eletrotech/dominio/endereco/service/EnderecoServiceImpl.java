package br.com.fsales.eletrotech.dominio.endereco.service;

import br.com.fsales.eletrotech.dominio.endereco.dto.DadosAtualizarEnderecoRequest;
import br.com.fsales.eletrotech.dominio.endereco.dto.EnderecoRequest;
import br.com.fsales.eletrotech.dominio.endereco.entitie.Endereco;
import br.com.fsales.eletrotech.dominio.endereco.enumeration.EstadoEnum;
import br.com.fsales.eletrotech.dominio.endereco.repository.EnderecoRepository;
import br.com.fsales.eletrotech.dominio.endereco.util.EnderecoCustomerMapper;
import br.com.fsales.eletrotech.infrastructure.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j

public class EnderecoServiceImpl implements EnderecoService {

    private final EnderecoRepository enderecoRepository;

    private final EnderecoCustomerMapper enderecoMapper;

    /**
     * @param pageable
     * @return
     */
    @Override
    public Page<Endereco> consultaPaginada(
            final Pageable pageable
    ) {
        return enderecoRepository.findAll(pageable);
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

        var estado = enderecoMapper.enderecoRequestToEndereco(
                enderecoRequest
        );

        estado.setEstado(
                EstadoEnum.getEnum(enderecoRequest.siglaEstado())
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

        var enderecoExistente = enderecoRepository.getReferenceById(enderecoRequest.id());


        enderecoMapper.update(enderecoRequest, enderecoExistente);

        return enderecoExistente;
    }
}
