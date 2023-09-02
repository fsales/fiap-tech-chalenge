package br.com.fsales.eletrotech.eletrodomestico.aplication.service;

import br.com.fsales.eletrotech.eletrodomestico.aplication.dto.EletrodomesticoAtualizarDTO;
import br.com.fsales.eletrotech.eletrodomestico.aplication.dto.EletrodomesticoCadastroDTO;
import br.com.fsales.eletrotech.eletrodomestico.aplication.dto.EletrodomesticoDTO;
import br.com.fsales.eletrotech.eletrodomestico.aplication.dto.FiltroListarEletrodomesticoDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface EletrodomesticoService {


    /**
     * @param pageable
     * @param filtroListarEletrodomestico
     * @return
     */
    Page<EletrodomesticoDTO> consultaPaginada(final Pageable pageable, final FiltroListarEletrodomesticoDTO filtroListarEletrodomestico);

    /**
     * @param eletrodomesticoCadastro
     * @return
     */
    EletrodomesticoDTO cadastrar(final EletrodomesticoCadastroDTO eletrodomesticoCadastro);

    /**
     * @param id
     * @return
     */
    EletrodomesticoDTO detalhar(final UUID id);

    /**
     * @param id
     */
    void excluir(final UUID id);

    /**
     * @param eletrodomesticoAtualizar
     * @return
     */
    EletrodomesticoDTO atualizar(final EletrodomesticoAtualizarDTO eletrodomesticoAtualizar);

}
