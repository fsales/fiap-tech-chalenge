package br.com.fsales.eletrotech.eletrodomestico.aplication.service;

import br.com.fsales.eletrotech.eletrodomestico.aplication.dto.Eletrodomestico;
import br.com.fsales.eletrotech.eletrodomestico.aplication.dto.EletrodomesticoAtualizar;
import br.com.fsales.eletrotech.eletrodomestico.aplication.dto.EletrodomesticoCadastro;
import br.com.fsales.eletrotech.eletrodomestico.aplication.dto.FiltroListarEletrodomestico;
import br.com.fsales.eletrotech.eletrodomestico.aplication.util.EletrodomesticoMapper;
import br.com.fsales.eletrotech.eletrodomestico.aplication.validacao.ValidarEletrodomestico;
import br.com.fsales.eletrotech.eletrodomestico.domain.repository.IEletrodomesticoRepository;
import br.com.fsales.eletrotech.eletrodomestico.presentation.util.EletrodomesticoCustomerMapper;
import br.com.fsales.eletrotech.endereco.domain.repository.IEnderecoRepository;
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
    private final EletrodomesticoCustomerMapper eletrodomesticoCustomerMapper;

    private final IEletrodomesticoRepository eletrodomesticoRepository;

    private final IEnderecoRepository enderecoRepository;

    private final EletrodomesticoMapper eletrodomesticoMapper;

    private final List<ValidarEletrodomestico> validadores;

    /**
     * @param pageable
     * @return
     */
    @Override
    public Page<Eletrodomestico> consultaPaginada(final Pageable pageable, final FiltroListarEletrodomestico filtroListarEletrodomestico) {
        log.debug("Consulta Paginada");

        var page = eletrodomesticoRepository.consultarEnderecoPaginado(
                pageable,
                filtroListarEletrodomestico
        );

        return page.map(
                eletrodomesticoCustomerMapper::eletrodomesticoToEletrodomestico
        );
    }

    /**
     * @param eletrodomesticoCadastro
     * @return
     */
    @Override
    @Transactional
    public Eletrodomestico cadastrar(final EletrodomesticoCadastro eletrodomesticoCadastro) {
        log.debug("Salvando eletrodomestico");

        validadores.forEach(v -> v.validar(eletrodomesticoCadastro));

        var eletrodomesticoSalvar = eletrodomesticoMapper
                .eletrodomesticoCadastroToEletrodomestico(
                        eletrodomesticoCadastro
                );

        var endereco = enderecoRepository.getReferenceById(
                eletrodomesticoSalvar.getEndereco().getEnderecoId()
        );
        eletrodomesticoSalvar.setEndereco(endereco);

        var eletrodomestico = eletrodomesticoRepository.save(
                eletrodomesticoSalvar
        );

        return detalhar(eletrodomestico.getId());
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Eletrodomestico detalhar(final UUID id) {
        log.debug("Detalhar");

        var eletrodomestico = eletrodomesticoRepository
                .findById(id)
                .orElseThrow(
                        () -> new NotFoundException("Electrodoméstico  n\u00E3o encontrado.")
                );

        return eletrodomesticoMapper
                .eletrodomesticoToEletrodomestico(
                        eletrodomestico
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
     * @param eletrodomesticoAtualizar
     * @return
     */
    @Override
    @Transactional
    public Eletrodomestico atualizar(final EletrodomesticoAtualizar eletrodomesticoAtualizar) {
        log.debug("Atualizando eletrodomestico");

        validadores.forEach(v -> v.validar(eletrodomesticoAtualizar));

        var eletrodomesticoExistente = eletrodomesticoRepository
                .getReferenceById(eletrodomesticoAtualizar.id());

        eletrodomesticoMapper.update(eletrodomesticoAtualizar, eletrodomesticoExistente);

        return detalhar(eletrodomesticoExistente.getId());
    }
}
