package br.com.fsales.eletrotech.dominio.eletrodomestico.validacao;


import br.com.fsales.eletrotech.dominio.endereco.repository.IEnderecoRepository;
import br.com.fsales.eletrotech.dominio.endereco.validacao.exception.ValidarEnderecoException;
import org.springframework.stereotype.Component;

@Component
public class ValidarEletrodomesticoIdentificadorEndereco implements ValidarEletrodomestico {

    private final IEnderecoRepository enderecoRepository;

    public ValidarEletrodomesticoIdentificadorEndereco(IEnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }

    /**
     * @param eletrodomestico
     */
    @Override
    public void validar(IEletrodomestico eletrodomestico) {
        if (eletrodomestico.idEndereco() != null &&
            !enderecoRepository.existsById(eletrodomestico.idEndereco())
        )
            throw new ValidarEnderecoException(
                    String.format(
                            "Não foi localizado o endereço de id: %s ",
                            eletrodomestico.idEndereco()
                    )
            );
    }
}
