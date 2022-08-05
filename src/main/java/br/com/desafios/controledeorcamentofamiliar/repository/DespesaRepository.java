package br.com.desafios.controledeorcamentofamiliar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.desafios.controledeorcamentofamiliar.modelo.Despesa;

public interface DespesaRepository extends JpaRepository<Despesa, Long>{

}
