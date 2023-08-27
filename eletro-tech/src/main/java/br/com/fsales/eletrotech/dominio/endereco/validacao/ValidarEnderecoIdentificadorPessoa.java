package br.com.fsales.eletrotech.dominio.endereco.validacao;

import br.com.fsales.eletrotech.dominio.endereco.validacao.exception.ValidarEnderecoException;
import br.com.fsales.eletrotech.dominio.pessoa.repository.IPessoaRepository;
import org.springframework.stereotype.Component;

@Component
public class ValidarEnderecoIdentificadorPessoa implements ValidarEndereco {

    private final IPessoaRepository pessoaRepository;

    public ValidarEnderecoIdentificadorPessoa(IPessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    /**
     * @param endereco
     */
    @Override
    public void validar(IEndereco endereco) {
        if (endereco.idPessoa() != null &&
            !pessoaRepository.existsById(endereco.idPessoa())
        )
            throw new ValidarEnderecoException(
                    String.format(
                            "Não foi localizado a pessoa de id: %s ",
                            endereco.idPessoa()
                    )
            );


    }
}
