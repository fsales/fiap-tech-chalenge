package br.com.fsales.eletrotech.dominio.endereco.service;

import br.com.fsales.eletrotech.dominio.endereco.dto.DadosAtualizarEnderecoRequest;
import br.com.fsales.eletrotech.dominio.endereco.dto.EnderecoRequest;
import br.com.fsales.eletrotech.dominio.endereco.dto.ListarEnderecoRequest;
import br.com.fsales.eletrotech.dominio.endereco.entitie.Endereco;
import br.com.fsales.eletrotech.dominio.endereco.projection.EnderecoProjection;
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
    Endereco detalhar(final UUID id);

    /**
     * @param id
     */
    void excluir(final UUID id);

    /**
     * @param enderecoRequest
     * @return
     */
    Endereco atualizar(final DadosAtualizarEnderecoRequest enderecoRequest);
}
