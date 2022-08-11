package br.com.desafios.controledeorcamentofamiliar.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.desafios.controledeorcamentofamiliar.dto.DespesaDto;
import br.com.desafios.controledeorcamentofamiliar.modelo.Despesa;
import br.com.desafios.controledeorcamentofamiliar.repository.DespesaRepository;
import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/despesa")
public class DespesaController {

	@Autowired
	private DespesaRepository repositoryDespesas;
	private Despesa despesa;
//	private DespesaDto despesaDto;

	@PostMapping
	@Transactional
	public ResponseEntity<DespesaDto> cadastrar(@RequestBody DespesaDto despesaDto, UriComponentsBuilder uriBuilder) {

		despesa = Despesa.converter(despesaDto);
		List<Despesa> despesas = repositoryDespesas.findAll();
		 
		if (!despesas.contains(despesa)) {
			repositoryDespesas.save(despesa);
			URI uri = uriBuilder.path("/despesa/{id}").buildAndExpand(despesa.getId()).toUri();
			return ResponseEntity.created(uri).body(new DespesaDto(despesa));
		}
		return ResponseEntity.notFound().build();
	}

	@GetMapping
	public List<DespesaDto> listagem() {
		List<Despesa> despesas = repositoryDespesas.findAll();

		return DespesaDto.converter(despesas);
	}

	@GetMapping("/{id}")
	public ResponseEntity<DespesaDto> detalhe(@PathVariable("id") Long id) {
		Optional<Despesa> despesa = repositoryDespesas.findById(id);
		return ResponseEntity.ok(new DespesaDto(despesa.get()));
	}
	
	@GetMapping("/descricao/{descricao}")
	public List<DespesaDto> bustaDeDespesas(@PathVariable("descricao") String despesa){
		Set<DespesaDto> despesas= new LinkedHashSet<>(listagem());
		List<DespesaDto> descricoes= new ArrayList<>();
		despesas.forEach(r->{
			if(r.getDescricao().contains(despesa)) {
				descricoes.add(r);
			}
		});
		
		return descricoes;
	}
	
//	@GetMapping("/mes/{mes}")
//	public List<DespesaDto> despesaDoMes(@PathVariable("mes") Integer mes){
//		
//		LocalDate inicio=LocalDate.of(2022, mes, 1);
//		LocalDate fim=LocalDate.of(2022, mes+1, 1);
//		String intervalo= " '"+inicio+"' and '"+fim+"' ";
//		List<Despesa> despesas= repositoryDespesas.despesaDoMes(intervalo);
//		List<DespesaDto> dtos= DespesaDto.converter(despesas);
//		
//		
//		return dtos;
//	}
	
	

	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<DespesaDto> atualizar(@RequestBody DespesaDto despesaDto, @PathVariable("id") Long id) {
		List<Despesa> despesas= repositoryDespesas.findAll();
		 despesa = repositoryDespesas.findById(id).orElseThrow();

		if(!despesas.contains(new Despesa(despesaDto))) {
			
		despesa.setDescricao(despesaDto.getDescricao());
		despesa.setValor(despesaDto.getValor());
		despesa.setData(despesaDto.getData());
		DespesaDto despesaAtualizada = new DespesaDto(repositoryDespesas.save(despesa));

		return ResponseEntity.ok(despesaAtualizada);
		}
		return ResponseEntity.notFound().build();
		
	}

	@DeleteMapping("/{id}")
	@Transactional
	public void deletar(@PathVariable Long id) {
		repositoryDespesas.deleteById(id);

	}

}
