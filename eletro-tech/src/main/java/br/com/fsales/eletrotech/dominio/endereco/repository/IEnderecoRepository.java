package br.com.fsales.eletrotech.dominio.endereco.repository;

import br.com.fsales.eletrotech.dominio.endereco.entitie.Endereco;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IEnderecoRepository extends JpaRepository<Endereco, UUID> {

    Page<>
}