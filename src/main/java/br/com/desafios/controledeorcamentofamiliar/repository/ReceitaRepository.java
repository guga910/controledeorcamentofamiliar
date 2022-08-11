package br.com.desafios.controledeorcamentofamiliar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.desafios.controledeorcamentofamiliar.modelo.Receita;

public interface ReceitaRepository extends JpaRepository<Receita, Long> {

}
