package br.com.fsales.eletrotech.dominio.pessoa.service;

import br.com.fsales.eletrotech.dominio.pessoa.dto.DadosAtualizarPessoaRequest;
import br.com.fsales.eletrotech.dominio.pessoa.dto.ListarPessoaRequest;
import br.com.fsales.eletrotech.dominio.pessoa.dto.PessoaRequest;
import br.com.fsales.eletrotech.dominio.pessoa.entitie.Pessoa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface PessoaService {


    /**
     * @param pessoaRequest
     * @param pageable
     * @return
     */
    Page<Pessoa> consultaPaginada(
            final ListarPessoaRequest pessoaRequest,
            Pageable pageable
    );

    /**
     * @param pessoaRequest
     * @return Pessoa
     */
    Pessoa save(final PessoaRequest pessoaRequest);

    /**
     * @param id
     */
    Pessoa detalhar(final UUID id);

    /**
     * @param id
     */
    void excluir(final UUID id);

    /**
     * @param pessoaRequest
     * @return
     */
    Pessoa atualizar(
            DadosAtualizarPessoaRequest pessoaRequest
    );
}
