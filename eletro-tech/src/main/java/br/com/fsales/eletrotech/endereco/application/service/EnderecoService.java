package br.com.fsales.eletrotech.endereco.application.service;

import br.com.fsales.eletrotech.endereco.domain.entity.Endereco;
import br.com.fsales.eletrotech.endereco.domain.projection.EnderecoProjection;
import br.com.fsales.eletrotech.endereco.presentation.dto.DadosAtualizarEnderecoRequest;
import br.com.fsales.eletrotech.endereco.presentation.dto.EnderecoRequest;
import br.com.fsales.eletrotech.endereco.presentation.dto.ListarEnderecoRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface EnderecoService {

    /**
     * @param filtro
     * @param pageable
     * @return
     */
    Page<EnderecoProjection> consultaPaginada(
            final ListarEnderecoRequest filtro,
            final Pageable pageable
    );

    /**
     * @param enderecoRequest
     * @return
     */
    Endereco cadastrar(final EnderecoRequest enderecoRequest);

    /**
     * @param id
     * @return
     */
    Endereco detalhar(
            final UUID id,
            final UUID idPessoa
    );

    /**
     * @param id
     */
    void excluir(
            final UUID id,
            final UUID idPessoa
    );

    /**
     * @param enderecoRequest
     * @return
     */
    Endereco atualizar(final DadosAtualizarEnderecoRequest enderecoRequest);
}
