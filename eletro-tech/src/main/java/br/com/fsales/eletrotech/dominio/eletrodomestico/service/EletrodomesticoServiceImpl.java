package br.com.fsales.eletrotech.dominio.eletrodomestico.service;

import br.com.fsales.eletrotech.dominio.eletrodomestico.dto.DadosAtualizarEletrodomesticoRequest;
import br.com.fsales.eletrotech.dominio.eletrodomestico.dto.EletrodomesticoRequest;
import br.com.fsales.eletrotech.dominio.eletrodomestico.entitie.Eletrodomestico;
import br.com.fsales.eletrotech.dominio.eletrodomestico.repository.EletrodomesticoRepository;
import br.com.fsales.eletrotech.dominio.eletrodomestico.util.EletrodomesticoCustomerMapper;
import br.com.fsales.eletrotech.dominio.eletrodomestico.validacao.ValidarEletrodomestico;
import br.com.fsales.eletrotech.infrastructure.exception.NotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor

@Slf4j
public class EletrodomesticoServiceImpl implements EletrodomesticoService {

    private final EletrodomesticoRepository eletrodomesticoRepository;

    private final EletrodomesticoCustomerMapper eletrodomesticoCustomerMapper;

    private final List<ValidarEletrodomestico> validadores;

    /**
     * @param pageable
     * @return
     */
    @Override
    public Page<Eletrodomestico> consultaPaginada(final Pageable pageable) {
        log.debug("Consulta Paginada");

        return eletrodomesticoRepository.findAll(pageable);
    }

    /**
     * @param eletrodomesticoRequest
     * @return
     */
    @Override
    @Transactional
    public Eletrodomestico cadastrar(final EletrodomesticoRequest eletrodomesticoRequest) {
        log.debug("Salvando eletrodomestico");

        validadores.forEach(v -> v.validar(eletrodomesticoRequest));
        var eletrodomestico = eletrodomesticoCustomerMapper
                .eletrodomesticoRequestToEletrodomestico(
                        eletrodomesticoRequest
                );

        return eletrodomesticoRepository.save(eletrodomestico);
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Eletrodomestico detalhar(final UUID id) {
        log.debug("Detalhar");

        return eletrodomesticoRepository
                .findById(id)
                .orElseThrow(
                        () -> new NotFoundException("Electrodoméstico  n\u00E3o encontrado.")
                );
    }

    /**
     * @param id
     */
    @Override
    @Transactional
    public void excluir(final UUID id) {

        log.debug("excluir");

        eletrodomesticoRepository.deleteById(id);
    }

    /**
     * @param eletrodomesticoRequest
     * @return
     */
    @Override
    @Transactional
    public Eletrodomestico atualizar(final DadosAtualizarEletrodomesticoRequest eletrodomesticoRequest) {
        log.debug("Atualizando eletrodomestico");

        var eletrodomesticoExistente = eletrodomesticoRepository
                .getReferenceById(eletrodomesticoRequest.id());

        eletrodomesticoCustomerMapper.update(eletrodomesticoRequest, eletrodomesticoExistente);

        eletrodomesticoRepository.saveAndFlush(eletrodomesticoExistente);

        return eletrodomesticoExistente;
    }
}
