package br.com.desafios.controledeorcamentofamiliar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafios.controledeorcamentofamiliar.dto.ReceitaDto;
import br.com.desafios.controledeorcamentofamiliar.modelo.Receita;
import br.com.desafios.controledeorcamentofamiliar.repository.ReceitaRepository;
import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/receita")
public class ReceitaController {

	@Autowired
	private ReceitaRepository receitaRepository;
	private Receita receita= new Receita();
	private ReceitaDto receitaDto= new ReceitaDto();

	@PostMapping
	public void cadastro(@RequestBody   ReceitaDto receitaDto) {
		 List<ReceitaDto>lista= listagemDeReceita();
		if(!lista.contains(receitaDto)) {
			Receita receita = receitaDto.converteEmReceita(receitaDto);
			receitaRepository.save(receita);
			}
		

	}
	
	@GetMapping
	public List<ReceitaDto> listagemDeReceita() {
		List<Receita> receitas= receitaRepository.findAll();
		return ReceitaDto.converte(receitas);
	}
	
	@GetMapping("/{id}")
	public  ReceitaDto detalhe(@PathVariable Long id) {
		Receita receita= receitaRepository.findById(id).orElseThrow();
		
		
		return receitaDto= receitaDto.converteEmReceitaDto(receita);
		
	}
	@PutMapping("/{id}")
	@Transactional
	public ReceitaDto atualizar(@PathVariable Long id,@RequestBody ReceitaDto receitaDto) {
		receita= receitaRepository.findById(id).orElseThrow();
		
//		receita.setId(receitaDto.getId());
		receita.setDescricao(receitaDto.getDescricao());
		receita.setValor(receitaDto.getValor());
		receita.setData(receitaDto.getData());
//		receitaRepository.save(receita);
		
		ReceitaDto receitaDtoAtualizada= new ReceitaDto(receitaRepository.save(receita));
		
		return receitaDtoAtualizada;
	}
	
	@DeleteMapping("/{id}")
	public void deletar(@PathVariable Long id) {
		receita= receitaRepository.findById(id).orElseThrow();
		receitaRepository.delete(receita);
		
		
	}

	

}
