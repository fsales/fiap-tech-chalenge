package br.com.fsales.eletrotech.pessoa.application.service;

import br.com.fsales.eletrotech.infrastructure.exception.NotFoundException;
import br.com.fsales.eletrotech.pessoa.application.dto.PessoaAtualizarDTO;
import br.com.fsales.eletrotech.pessoa.application.dto.PessoaCadastroDTO;
import br.com.fsales.eletrotech.pessoa.application.dto.PessoaDTO;
import br.com.fsales.eletrotech.pessoa.application.dto.PessoaListarDTO;
import br.com.fsales.eletrotech.pessoa.application.integracao.IValidarPessaoIntegracao;
import br.com.fsales.eletrotech.pessoa.application.util.PessoaCustomerMapper;
import br.com.fsales.eletrotech.pessoa.application.validacao.ValidarPessoa;
import br.com.fsales.eletrotech.pessoa.domain.entity.PessoaEntity;
import br.com.fsales.eletrotech.pessoa.domain.repository.IPessoaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 *
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class PessoaServiceImpl implements PessoaService, IValidarPessaoIntegracao {

    public static final String PESSOA_NAO_ENCONTRADA = "PessoaEntity não encontrada.";

    private final IPessoaRepository repository;

    private final PessoaCustomerMapper pessoaCustomerMapper;

    private final List<ValidarPessoa> validadores;

    @Override
    public Page<PessoaDTO> consultaPaginada(
            final PessoaListarDTO pessoaListar,
            Pageable pageable
    ) {

        var page = repository.consultarPessoaPaginada(
                pessoaListar,
                pageable
        );

        return page.map(p -> pessoaCustomerMapper.pessoaCadastroToPessoaEntity(p, PessoaCustomerMapper.CYCLE_AVOIDING_MAPPING_CONTEXT));
    }

    @Override
    @Transactional
    public PessoaDTO cadastrar(
            final PessoaCadastroDTO pessoaCadastro
    ) {
        log.debug("Salvando a pessoa");
        List<PessoaEntity> dependentes = null;

        // validar
        validadores.forEach(v -> v.validar(pessoaCadastro));

        var pessoaEntitie = pessoaCustomerMapper.pessoaCadastroToPessoaEntity(
                pessoaCadastro,
                PessoaCustomerMapper.CYCLE_AVOIDING_MAPPING_CONTEXT
        );

        var pessoa = repository.save(
                pessoaEntitie
        );


        if (Objects.nonNull(
                pessoaCadastro
                        .dependentes()
        )
        )
            dependentes = salvarDependentes(
                    pessoaEntitie.getDependentes(),
                    pessoa
            );


        return pessoaCustomerMapper.pessoaCadastroToPessoaEntity(
                pessoa.addDependentes(
                        dependentes
                ),
                PessoaCustomerMapper.CYCLE_AVOIDING_MAPPING_CONTEXT
        );
    }

    @Override
    public PessoaDTO detalhar(final UUID id) {

        var pessoa = repository
                .findById(id)
                .orElseThrow(
                        () -> new NotFoundException("PessoaEntity não encontrada.")
                );

        return pessoaCustomerMapper.pessoaCadastroToPessoaEntity(
                pessoa,
                PessoaCustomerMapper.CYCLE_AVOIDING_MAPPING_CONTEXT
        );
    }

    @Override
    @Transactional
    public void excluir(
            final UUID id
    ) {
        var pessoa = repository
                .findById(id).orElseThrow(
                        () -> new NotFoundException(PESSOA_NAO_ENCONTRADA)
                );

        repository.deleteAll(
                pessoa.getDependentes()
        );

        repository.delete(
                pessoa
        );
    }

    /**
     * @param pessoaAtualizar
     * @return
     */
    @Transactional
    @Override
    public PessoaDTO atualizar(
            PessoaAtualizarDTO pessoaAtualizar
    ) {
        // validar
        validadores.forEach(v -> v.validar(pessoaAtualizar));

        var pessoaExistente = repository.getReferenceById(pessoaAtualizar.id());

        // copiando o valor recebido por parametro para a entidade consulta no banco
        pessoaCustomerMapper.updatePessoaFromPessoaRequest(pessoaAtualizar, pessoaExistente);

        if (pessoaAtualizar.dependentes() != null &&
            !pessoaAtualizar.dependentes().isEmpty()) {

            pessoaExistente
                    .getDependentes()
                    .clear();

            pessoaAtualizar.dependentes().forEach(depenteRequest -> {
                var dep = repository.getReferenceById(depenteRequest.id());
                pessoaCustomerMapper.updatePessoaFromPessoaRequest(depenteRequest, dep);

                pessoaExistente
                        .getDependentes().add(dep);
            });

        }

        return pessoaCustomerMapper.pessoaCadastroToPessoaEntity(
                pessoaExistente,
                PessoaCustomerMapper.CYCLE_AVOIDING_MAPPING_CONTEXT
        );
    }

    /**
     * @param dependentes
     * @param parent
     * @return
     */
    private List<PessoaEntity> salvarDependentes(
            final Collection<PessoaEntity> dependentes,
            final PessoaEntity parent
    ) {
        log.debug("Salvando dependentes da pessoa");

        return repository.saveAllAndFlush(
                dependentes
                        .stream().map(d -> addParentToPessoa(parent, d))
                        .collect(Collectors.toList())
        );
    }

    private PessoaEntity addParentToPessoa(final PessoaEntity parent, PessoaEntity pessoa) {

        return pessoa.setParent(parent);
    }

    /**
     * @param id
     * @return
     */
    @Override
    public boolean verificarSeIdExiste(final UUID id) {

        return Objects.nonNull(id) &&
               repository.existsById(id);
    }
}
