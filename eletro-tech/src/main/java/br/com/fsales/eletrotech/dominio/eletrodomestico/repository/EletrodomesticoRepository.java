package br.com.fsales.eletrotech.dominio.eletrodomestico.repository;

import br.com.fsales.eletrotech.dominio.eletrodomestico.entitie.Eletrodomestico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 *
 */
public interface EletrodomesticoRepository extends JpaRepository<Eletrodomestico, UUID> {
}
