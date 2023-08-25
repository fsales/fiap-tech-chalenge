package br.com.fsales.eletrotech.dominio.pessoa.service;

import br.com.fsales.eletrotech.dominio.pessoa.dto.DadosAtualizarPessoaRequest;
import br.com.fsales.eletrotech.dominio.pessoa.dto.ListarPessoaRequest;
import br.com.fsales.eletrotech.dominio.pessoa.dto.PessoaRequest;
import br.com.fsales.eletrotech.dominio.pessoa.entitie.Pessoa;
import br.com.fsales.eletrotech.dominio.pessoa.enumeration.ParentescoEnum;
import br.com.fsales.eletrotech.dominio.pessoa.enumeration.SexoEnum;
import br.com.fsales.eletrotech.dominio.pessoa.repository.IPessoaRepository;
import br.com.fsales.eletrotech.dominio.pessoa.util.PessoaCustomerMapper;
import br.com.fsales.eletrotech.dominio.pessoa.validacao.ValidarPessoa;
import br.com.fsales.eletrotech.infrastructure.exception.NotFoundException;
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
public class PessoaServiceImpl implements PessoaService {

    public static final String PESSOA_NAO_ENCONTRADA = "Pessoa não encontrada.";

    private final IPessoaRepository repository;

    private final PessoaCustomerMapper pessoaCustomerMapper;

    private final List<ValidarPessoa> validadores;

    @Override
    public Page<Pessoa> consultaPaginada(
            final ListarPessoaRequest pessoaRequest,
            Pageable pageable
    ) {

        return repository.consultarPessoaPaginada(
                pessoaRequest,
                pageable
        );
    }

    @Override
    @Transactional
    public Pessoa save(
            final PessoaRequest pessoaRequest
    ) {
        log.debug("Salvando a pessoa");
        List<Pessoa> dependentes = null;

        // validar
        validadores.forEach(v -> {
            v.validar(
                    pessoaRequest
            );
            v.validar(
                    pessoaRequest
                            .dependentes()
            );
        });

        var pessoaEntitie = PessoaMapper
                .fromRequestToPessoa(
                        pessoaRequest
                );

        var pessoa = repository.save(
                pessoaEntitie
        );


        if (Objects.nonNull(
                pessoaRequest
                        .dependentes()
        )
        )
            dependentes = salvarDependentes(
                    pessoaRequest.dependentes(),
                    pessoa
            );

        return pessoa.addDependentes(
                dependentes
        );
    }

    @Override
    public Pessoa detalhar(final UUID id) {

        return repository
                .findById(id)
                .orElseThrow(
                        () -> new NotFoundException("Pessoa não encontrada.")
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
     * @param pessoaRequest
     * @return
     */
    @Transactional
    @Override
    public Pessoa atualizar(
            DadosAtualizarPessoaRequest pessoaRequest
    ) {

        var pessoaExistente = repository.getReferenceById(pessoaRequest.id());

        // copiando o valor recebido por parametro para a entidade consulta no banco
        pessoaCustomerMapper.updatePessoaFromPessoaRequest(pessoaRequest, pessoaExistente);

        var parentescoEnum = ParentescoEnum.getEnum(pessoaRequest.siglaParentesco());

        if (parentescoEnum != null)
            pessoaExistente.setParentesco(parentescoEnum);

        var sexoEnum = SexoEnum.getEnum(pessoaRequest.siglaSexo());

        if (sexoEnum != null)
            pessoaExistente.setSexo(sexoEnum);


        if (pessoaRequest.dependentes() != null &&
                !pessoaRequest.dependentes().isEmpty()) {

            pessoaExistente
                    .getDependentes()
                    .clear();

            pessoaRequest.dependentes().forEach(depenteRequest -> {
                var dep = repository.getReferenceById(depenteRequest.id());
                pessoaCustomerMapper.updatePessoaFromPessoaRequest(depenteRequest, dep);

                pessoaExistente
                        .getDependentes().add(dep);
            });

        }

        return pessoaExistente;
    }

    /**
     * @param pessoasRequest
     * @param parent
     * @return
     */
    private List<Pessoa> salvarDependentes(
            final Collection<PessoaRequest> pessoasRequest,
            final Pessoa parent
    ) {
        log.debug("Salvando dependentes da pessoa");

        var dependentes = PessoaMapper
                .fromRequestToPessoa(
                        pessoasRequest
                )
                .map(p ->
                        addParentToPessoa(parent, p)
                )
                .collect(Collectors.toList());

        return repository.saveAll(dependentes);
    }

    private Pessoa addParentToPessoa(Pessoa parent, Pessoa pessoa) {

        return pessoa.setParent(parent);
    }
}
