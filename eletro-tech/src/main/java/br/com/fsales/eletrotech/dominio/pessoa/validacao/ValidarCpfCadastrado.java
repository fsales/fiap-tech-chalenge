package br.com.fsales.eletrotech.dominio.pessoa.validacao;

import br.com.fsales.eletrotech.dominio.pessoa.dto.IPessoa;
import br.com.fsales.eletrotech.dominio.pessoa.repository.IPessoaRepository;
import br.com.fsales.eletrotech.dominio.pessoa.validacao.exception.ValidaPessoaException;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class ValidarCpfCadastrado implements ValidarPessoa {

    private final IPessoaRepository pessoaRepository;

    public ValidarCpfCadastrado(IPessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    @Override
    public void validar(Collection<? extends IPessoa> pessoas) {
        ValidaPessoaException vpException = new ValidaPessoaException();

        pessoas.forEach(iPessoa -> {
            if (pessoaRepository.existsByCpf(iPessoa.cpf()))
                vpException.addMensagem(
                        String.format(
                                "O CPF de número %s já existe.",
                                iPessoa.cpf()
                        )
                );
        });

        if (vpException.lancarErro())
            throw vpException;

    }


}
