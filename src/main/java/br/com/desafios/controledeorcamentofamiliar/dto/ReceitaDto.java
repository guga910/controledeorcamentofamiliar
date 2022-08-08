package br.com.desafios.controledeorcamentofamiliar.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import br.com.desafios.controledeorcamentofamiliar.modelo.Receita;
import jakarta.validation.Valid;

public class ReceitaDto {
	private Long id;
	private String descricao;
	private BigDecimal valor;
	
	private LocalDate data;
	
	public ReceitaDto(Receita receita) {
		
		this.id= receita.getId();
		this.descricao= receita.getDescricao();
		this.valor= receita.getValor();
		this.data= receita.getData();
	}
	 
public ReceitaDto() {
	// TODO Auto-generated constructor stub
}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(data, descricao, valor);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReceitaDto other = (ReceitaDto) obj;
		return Objects.equals(data, other.data) && Objects.equals(descricao, other.descricao)
				&& Objects.equals(valor, other.valor);
	}

	public ReceitaDto converteEmReceitaDto(Receita receita) {
		ReceitaDto receitaDto= new ReceitaDto();
		receitaDto.setId(receita.getId());
		receitaDto.setDescricao(receita.getDescricao());
		receitaDto.setValor(receita.getValor());
		receitaDto.setData(receita.getData());
		
		
		return receitaDto;
		
	}


	public Receita converteEmReceita(@Valid ReceitaDto receitaDto) {
		Receita receita= new Receita();
		receita.setId(receitaDto.getId());
		receita.setDescricao(receitaDto.getDescricao());
		receita.setValor(receitaDto.getValor());
		receita.setData(receitaDto.getData());
		
		return receita;
	}


	public static List<ReceitaDto> converte(List<Receita> receitas) {
		// recebo uma lista de receitas e converto em dto
		List<ReceitaDto> receitasDto= new ArrayList<ReceitaDto>();
		receitas.forEach(item->{
			ReceitaDto rdto= new ReceitaDto(item);
			receitasDto.add(rdto);
			
		});
		
		return receitasDto;
	}
	

}
