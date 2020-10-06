package com.melquias.lojaapi.domain;

import java.util.Date;

import javax.persistence.Entity;

import com.melquias.lojaapi.domain.enums.EstadoPagamento;

@Entity
public class PagamentoComBoleto extends Pagamento {
	private static final long serialVersionUID = 1L;

	private Date datavencimento;
	private Date dataPagamento;
	
	
	public PagamentoComBoleto() {
		
	}


	public PagamentoComBoleto(Integer id, EstadoPagamento estado, Pedido pedido, Date dataPagamento,Date datavencimento) {
		super(id, estado, pedido);
		
		this.dataPagamento=dataPagamento;
		this.datavencimento=datavencimento;
	}


	public Date getDatavencimento() {
		return datavencimento;
	}


	public void setDatavencimento(Date datavencimento) {
		this.datavencimento = datavencimento;
	}


	public Date getDataPagamento() {
		return dataPagamento;
	}


	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}
	
	
	
	
}
