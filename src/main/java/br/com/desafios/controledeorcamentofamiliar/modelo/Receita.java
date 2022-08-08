package br.com.desafios.controledeorcamentofamiliar.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

import br.com.desafios.controledeorcamentofamiliar.dto.ReceitaDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
public class Receita {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull @NotEmpty
	private String descricao;
	@Column(nullable = false)
	private BigDecimal valor;
	@Column(nullable = false)
	private LocalDate data;
	
	
	public Receita() {	}
	
	public Receita( String descricao, BigDecimal valor, LocalDate data) {
		this.descricao = descricao;
		this.valor = valor;
		this.data = data;
	}



	public Receita(ReceitaDto receitaDto) {
		this.descricao = receitaDto.getDescricao();
		this.valor = receitaDto.getValor();
		this.data = receitaDto.getData();
		this.id = receitaDto.getId();
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
		Receita other = (Receita) obj;
		return Objects.equals(data, other.data) && Objects.equals(descricao, other.descricao)
				&& Objects.equals(valor, other.valor);
	}

	public  Receita converter(ReceitaDto receitaDto) {
		Receita receita= new Receita();
		receita.setId(receitaDto.getId());
		receita.setDescricao(receitaDto.getDescricao());
		receita.setData(receitaDto.getData());
		receita.setValor(receitaDto.getValor());
		
		return receita;
	}

	
	
	

}
