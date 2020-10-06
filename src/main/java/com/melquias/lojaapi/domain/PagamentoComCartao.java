package com.melquias.lojaapi.domain;

import javax.persistence.Entity;

import com.melquias.lojaapi.domain.enums.EstadoPagamento;

@Entity
public class PagamentoComCartao extends Pagamento {
	private static final long serialVersionUID = 1L;

	private Integer NumeroDeParcelas;
	
	public  PagamentoComCartao() {
		
	}

	public PagamentoComCartao(Integer id, EstadoPagamento estado, Pedido pedido,Integer NumeroDeParcelas) {
		super(id, estado, pedido);
		this.NumeroDeParcelas = NumeroDeParcelas;
	}

	public Integer getNumeroDeParcelas() {
		return NumeroDeParcelas;
	}

	public void setNumeroDeParcelas(Integer numeroDeParcelas) {
		NumeroDeParcelas = numeroDeParcelas;
	}
	
	
	
}
