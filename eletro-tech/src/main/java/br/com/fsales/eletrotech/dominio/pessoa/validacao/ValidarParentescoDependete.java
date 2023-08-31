package br.com.fsales.eletrotech.dominio.pessoa.validacao;

import br.com.fsales.eletrotech.dominio.pessoa.repository.IPessoaRepository;
import br.com.fsales.eletrotech.dominio.pessoa.validacao.exception.ValidaPessoaException;
import org.springframework.stereotype.Component;

@Component
public class ValidarParentescoDependete implements ValidarPessoa {

    private final IPessoaRepository pessoaRepository;

    private ValidaPessoaException vpException = null;


    public ValidarParentescoDependete(IPessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    /**
     * @param pessoa
     */
    @Override
    public void validar(final IPessoa pessoa) {
        this.vpException = new ValidaPessoaException();

        validarDependete(pessoa);

        validaDependenteAlteracao(pessoa);

    }

    private void validaDependenteAlteracao(IPessoa pessoa) {
        if (pessoa.id() == null) {
            return;
        }
        var pessoaExistene = pessoaRepository.getReferenceById(pessoa.id());
        if (
                pessoaExistene.parent() != null &&
                pessoa.siglaParentesco() == null)
            addMensagemValidacao(pessoa);

        if (this.vpException.lancarErro())
            throw vpException;

    }

    private void validarDependete(IPessoa pessoa) {
        if (pessoa.dependentes() != null &&
            !pessoa.dependentes().isEmpty()) {
            pessoa.dependentes().forEach(d -> {
                if (d.siglaParentesco() == null)
                    addMensagemValidacao(d);
            });
        }
        if (this.vpException.lancarErro())
            throw vpException;
    }

    private void addMensagemValidacao(IPessoa pessoa) {

        this.vpException.addMensagem(
                String.format(
                        "Deve ser informado o parentesco do dependente: %s %s",
                        pessoa.nome(),
                        pessoa.sobrenome()
                )
        );
    }


}
