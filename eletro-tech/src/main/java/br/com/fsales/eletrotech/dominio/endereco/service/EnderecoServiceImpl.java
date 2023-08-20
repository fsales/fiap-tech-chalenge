package br.com.fsales.eletrotech.dominio.endereco.service;

import br.com.fsales.eletrotech.dominio.endereco.dto.DadosAtualizarEnderecoRequest;
import br.com.fsales.eletrotech.dominio.endereco.dto.EnderecoRequest;
import br.com.fsales.eletrotech.dominio.endereco.dto.ListarEnderecoRequest;
import br.com.fsales.eletrotech.dominio.endereco.entitie.Endereco;
import br.com.fsales.eletrotech.dominio.endereco.repository.IEnderecoRepository;
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

    private final IEnderecoRepository IEnderecoRepository;

    private final EnderecoCustomerMapper enderecoMapper;

    /**
     * @param request
     * @param pageable
     * @return
     */
    @Override
    public Page<Endereco> consultaPaginada(
            final ListarEnderecoRequest request,
            final Pageable pageable
    ) {
        return IEnderecoRepository.findAll(pageable);
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

        return IEnderecoRepository.save(
                estado
        );
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Endereco detalhar(final UUID id) {

        return IEnderecoRepository.findById(id)
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
        IEnderecoRepository
                .deleteById(id);
    }

    /**
     * @param enderecoRequest
     * @return
     */
    @Override
    @Transactional
    public Endereco atualizar(DadosAtualizarEnderecoRequest enderecoRequest) {

        var enderecoExistente = IEnderecoRepository.getReferenceById(enderecoRequest.id());


        enderecoMapper.update(enderecoRequest, enderecoExistente);

        return enderecoExistente;
    }
}
