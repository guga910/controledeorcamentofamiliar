package br.com.desafios.controledeorcamentofamiliar.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

import br.com.desafios.controledeorcamentofamiliar.dto.DespesaDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "despesas")
public class Despesa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String descricao;
	@Column(nullable = false)
	private BigDecimal valor;
	@Column(nullable = false)
	private LocalDate data;

	@Enumerated(EnumType.STRING) // sera usado o valor de string ao inves do valor int da enum
	private Categoria categoria = Categoria.OUTROS;

	public Despesa() {
	}

	public Despesa(DespesaDto despesa) {
		super();
		this.id = despesa.getId();
		this.descricao = despesa.getDescricao();
		this.valor = despesa.getValor();
		this.data = despesa.getData();
		this.categoria = despesa.getCategoria();
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
		Despesa other = (Despesa) obj;
		return Objects.equals(data, other.data) && Objects.equals(descricao, other.descricao)
				&& Objects.equals(valor, other.valor);
	}

	public static Despesa converter(DespesaDto despesaDto) {
		Despesa despesa = new Despesa();

		despesa.setId(despesaDto.getId());
		despesa.setDescricao(despesaDto.getDescricao());
		despesa.setValor(despesaDto.getValor());
		despesa.setData(despesaDto.getData());
		if(despesaDto.getCategoria()== null) {
			
		}else {
			despesa.setCategoria(despesaDto.getCategoria());
		}

		return despesa;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

}
