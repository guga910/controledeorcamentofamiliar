package br.com.desafios.controledeorcamentofamiliar.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import br.com.desafios.controledeorcamentofamiliar.modelo.Despesa;

public class DespesaDto {
private Long id;
	
	private String descricao;
	private BigDecimal valor;
	private LocalDateTime data;
	
	public DespesaDto() {
		// TODO Auto-generated constructor stub
	}
	public DespesaDto(Despesa despesa) {
		
		this.id = despesa.getId();
		this.descricao = despesa.getDescricao();
		this.valor = despesa.getValor();
		this.data = despesa.getData();
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
	public LocalDateTime getData() {
		return data;
	}
	public void setData(LocalDateTime data) {
		this.data = data;
	}
	@Override
	public int hashCode() {
		return Objects.hash(data, descricao, id, valor);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DespesaDto other = (DespesaDto) obj;
		return Objects.equals(data, other.data) && Objects.equals(descricao, other.descricao)
				 && Objects.equals(valor, other.valor);
	}
	public static  DespesaDto converter(Despesa despesa) {
		DespesaDto despesaDto= new DespesaDto();
		despesaDto.setId(despesa.getId());
		despesaDto.setDescricao(despesa.getDescricao());
		despesaDto.setData(despesa.getData());
		despesaDto.setValor(despesa.getValor());

		return despesaDto;
	}
	public static List<DespesaDto> converter(List<Despesa> despesas) {
		List<DespesaDto> despesasDto= new ArrayList<>();
		despesas.forEach(d->{
			DespesaDto dto= new DespesaDto(d);
			despesasDto.add(dto);
		});
		
		return despesasDto;
	}
	
	

}
