package br.com.fsales.eletrotech.dominio.eletrodomestico.projection;

import br.com.fsales.eletrotech.dominio.endereco.enumeration.EstadoEnum;
import org.springframework.beans.factory.annotation.Value;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

public interface EletrodomesticoProjection extends Serializable {

    UUID getId();

    String getNome();

    String getModelo();

    String getFabricante();

    String getPotencia();

    String getVoltagem();

    String getTempoUsoDiario();

    @Value("#{new br.com.fsales.eletrotech.dominio.eletrodomestico.projection.EletrodomesticoProjection.PessoaProjection(target.pId, target.pNome, target.pSobrenome, target.pParentesco, new br.com.fsales.eletrotech.dominio.eletrodomestico.projection.EletrodomesticoProjection.Parent(target.parentId, target.parentNome, target.parentSobrenome))}")
    PessoaProjection getPessoa();

    @Value("#{new br.com.fsales.eletrotech.dominio.eletrodomestico.projection.EletrodomesticoProjection.EnderecoProjection(target.eId, target.eCep, target.eRua, target.eComplemento, target.eNumero, target.eBairro, target.eCidade, target.eEstado, target.eNomeEndereco)}")
    EnderecoProjection getEndereco();

    /***** *******************/
    public record Parent(
            UUID id,
            String nome,
            String sobrenome
    ) {
    }

    public record PessoaProjection(
            UUID id,
            String nome,
            String sobrenome,
            String parentesco,
            Parent parent
    ) {
        /**
         * retorna o tipo da pessoa conforme a hierarquia
         *
         * @return
         */
        public String getTipoPessoa() {
            return Objects.isNull(parent)
                   || Objects.isNull(parent.id()) ? "Titular" : "Dependente";
        }
    }

    record EnderecoProjection(
            UUID id,
            String cep,
            String rua,
            String complemento,
            String numero,
            String bairro,
            String cidade,
            String siglaEstado,

            String nomeEndereco
    ) {
        /**
         * retorna o nome do estado com base no {@link EstadoEnum}
         *
         * @return
         */
        public String getNomeEstado() {
            return Objects.nonNull(siglaEstado) ? EstadoEnum.getEnum(siglaEstado).nome() : null;
        }
    }
}


