package br.com.fsales.eletrotech.pessoa.application.validacao;

import br.com.fsales.eletrotech.pessoa.application.validacao.exception.ValidaPessoaException;
import br.com.fsales.eletrotech.pessoa.domain.repository.IPessoaRepository;
import org.springframework.stereotype.Component;

@Component
public class ValidarCpfCadastrado implements ValidarPessoa {

    private final IPessoaRepository pessoaRepository;
    private ValidaPessoaException vpException = null;

    public ValidarCpfCadastrado(IPessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    @Override
    public void validar(IPessoa pessoa) {
        this.vpException = new ValidaPessoaException();

        validaCpfTitularEDependente(pessoa);

        if (this.vpException.lancarErro())
            throw vpException;

    }

    private void validaCpfTitularEDependente(IPessoa pessoa) {
        verificarCpfExistente(pessoa);
        if (pessoa.dependentes() != null &&
            !pessoa.dependentes().isEmpty())
            pessoa
                    .dependentes()
                    .forEach(this::verificarCpfExistente);
    }

    private void verificarCpfExistente(IPessoa pessoa) {


        var existeCpf = pessoaRepository.existsByCpfAndIdDifference(
                pessoa.cpf(),
                pessoa.id()
        );
        if (existeCpf)
            this.vpException.addMensagem(
                    String.format(
                            "O CPF de número %s já existe.",
                            pessoa.cpf()
                    )
            );
    }


}
