package br.com.fsales.eletrotech.pessoa.application.service;

import br.com.fsales.eletrotech.pessoa.application.dto.PessoaAtualizarDTO;
import br.com.fsales.eletrotech.pessoa.application.dto.PessoaCadastroDTO;
import br.com.fsales.eletrotech.pessoa.application.dto.PessoaDTO;
import br.com.fsales.eletrotech.pessoa.application.dto.PessoaListarDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface PessoaService {


    /**
     * @param pessoaListar
     * @param pageable
     * @return
     */
    Page<PessoaDTO> consultaPaginada(
            final PessoaListarDTO pessoaListar,
            Pageable pageable
    );

    /**
     * @param pessoaCadastro
     * @return PessoaEntity
     */
    PessoaDTO cadastrar(final PessoaCadastroDTO pessoaCadastro);

    /**
     * @param id
     */
    PessoaDTO detalhar(final UUID id);

    /**
     * @param id
     */
    void excluir(final UUID id);

    /**
     * @param pessoaAtualizar
     * @return
     */
    PessoaDTO atualizar(
            PessoaAtualizarDTO pessoaAtualizar
    );
}
