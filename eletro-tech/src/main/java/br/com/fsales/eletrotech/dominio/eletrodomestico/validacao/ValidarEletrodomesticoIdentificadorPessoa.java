package br.com.fsales.eletrotech.dominio.eletrodomestico.validacao;


import br.com.fsales.eletrotech.dominio.endereco.validacao.exception.ValidarEnderecoException;
import br.com.fsales.eletrotech.dominio.pessoa.repository.IPessoaRepository;
import org.springframework.stereotype.Component;

@Component
public class ValidarEletrodomesticoIdentificadorPessoa implements ValidarEletrodomestico {
    private final IPessoaRepository pessoaRepository;

    public ValidarEletrodomesticoIdentificadorPessoa(IPessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    /**
     * @param eletrodomestico
     */
    @Override
    public void validar(IEletrodomestico eletrodomestico) {
        if (eletrodomestico.idPessoa() != null &&
            !pessoaRepository.existsById(eletrodomestico.idPessoa())
        )
            throw new ValidarEnderecoException(
                    String.format(
                            "Não foi localizado a pessoa de id: %s ",
                            eletrodomestico.idPessoa()
                    )
            );
    }
}
