package br.com.fsales.eletrotech.dominio.eletrodomestico.service;

import br.com.fsales.eletrotech.dominio.eletrodomestico.dto.DadosAtualizarEletrodomesticoRequest;
import br.com.fsales.eletrotech.dominio.eletrodomestico.dto.EletrodomesticoRequest;
import br.com.fsales.eletrotech.dominio.eletrodomestico.entitie.Eletrodomestico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface EletrodomesticoService {


    /**
     * @param pageable
     * @return
     */
    Page<Eletrodomestico> consultaPaginada(final Pageable pageable);

    /**
     * @param eletrodomesticoRequest
     * @return
     */
    Eletrodomestico cadastrar(final EletrodomesticoRequest eletrodomesticoRequest);

    /**
     * @param id
     * @return
     */
    Eletrodomestico detalhar(final UUID id);

    /**
     * @param id
     */
    void excluir(final UUID id);

    /**
     * @param eletrodomesticoRequest
     * @return
     */
    Eletrodomestico atualizar(final DadosAtualizarEletrodomesticoRequest eletrodomesticoRequest);

}
