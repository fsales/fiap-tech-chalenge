package br.com.fsales.eletrotech.eletrodomestico.aplication.service;

import br.com.fsales.eletrotech.eletrodomestico.aplication.dto.Eletrodomestico;
import br.com.fsales.eletrotech.eletrodomestico.aplication.dto.EletrodomesticoAtualizar;
import br.com.fsales.eletrotech.eletrodomestico.aplication.dto.EletrodomesticoCadastro;
import br.com.fsales.eletrotech.eletrodomestico.aplication.dto.FiltroListarEletrodomestico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface EletrodomesticoService {


    /**
     * @param pageable
     * @param filtroListarEletrodomestico
     * @return
     */
    Page<Eletrodomestico> consultaPaginada(final Pageable pageable, final FiltroListarEletrodomestico filtroListarEletrodomestico);

    /**
     * @param eletrodomesticoCadastro
     * @return
     */
    Eletrodomestico cadastrar(final EletrodomesticoCadastro eletrodomesticoCadastro);

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
     * @param eletrodomesticoAtualizar
     * @return
     */
    Eletrodomestico atualizar(final EletrodomesticoAtualizar eletrodomesticoAtualizar);

}
