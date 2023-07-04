package br.com.fsales.eletrotech.dominio.endereco.service;

import br.com.fsales.eletrotech.dominio.endereco.dto.DadosAtualizarEnderecoRequest;
import br.com.fsales.eletrotech.dominio.endereco.dto.EnderecoRequest;
import br.com.fsales.eletrotech.dominio.endereco.entitie.Endereco;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface EnderecoService {

    /**
     * @param pageable
     * @return
     */
    Page<Endereco> consultaPaginada(final Pageable pageable);

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
