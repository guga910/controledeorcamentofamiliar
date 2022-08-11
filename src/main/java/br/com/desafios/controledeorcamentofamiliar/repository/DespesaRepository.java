package br.com.desafios.controledeorcamentofamiliar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.desafios.controledeorcamentofamiliar.modelo.Despesa;

public interface DespesaRepository extends JpaRepository<Despesa, Long>{

	
//	@Query("SELECT d FROM Despesa d WHERE data= :data")
//	@Query("SELECT d FROM Despesa d WHERE databetween intervalo")
//	 List<Despesa> despesaDoMes(String intervalo);	
//	2019-05-05	
//	 @Query("SELECT t FROM Topico t WHERE t.curso.nome = :nomeCurso")
//     List<Topico> carregarPorNomeDoCurso(String nomeCurso);
	
//	 SELECT * FROM TABELA WHERE  data between '2017-01-13' and '2017-01-20'
	 
}
