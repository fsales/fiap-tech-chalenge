package br.com.fsales.eletrotech.endereco.application.service;

import br.com.fsales.eletrotech.endereco.application.dto.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface EnderecoService {

    /**
     * @param filtro
     * @param pageable
     * @return
     */
    Page<EnderecoListar> consultaPaginada(
            final FiltroEnderecoListar filtro,
            final Pageable pageable
    );

    /**
     * @param enderecoDTO
     * @return
     */
    EnderecoDTO cadastrar(final EnderecoCadastroDTO enderecoDTO);

    /**
     * @param id
     * @return
     */
    EnderecoDTO detalhar(
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
     * @param enderecoDTO
     * @return
     */
    EnderecoDTO atualizar(final EnderecoAtualizarDTO enderecoDTO);
}
