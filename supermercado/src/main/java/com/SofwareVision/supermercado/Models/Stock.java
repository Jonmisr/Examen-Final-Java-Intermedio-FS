package com.SofwareVision.supermercado.Models;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Entity
public class Stock {

	@Id
	@Column (name = "idstock")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idstock;

	private Date fechadelcomprobante;

	private Long numerodelcomprobante;
	private BigDecimal totalenpesosdelacompra;

	public Long getIdStock() {
		return idstock;
	}

	public void setIdStock(Long idstock) {
		this.idstock = idstock;
	}

	public Date getFechaDelComprobante() {
		return fechadelcomprobante;
	}

	public void setFechaDelComprobante(Date fechadelcomprobante) {
		this.fechadelcomprobante = fechadelcomprobante;
	}

	public long getNumeroDelComprobante() {
		return numerodelcomprobante;
	}

	public void setNumeroDelComprobante(long numeroDelComprobante) {
		this.numerodelcomprobante = numeroDelComprobante;
	}

	public BigDecimal getTotalEnPesosDeLaCompra() {
		return totalenpesosdelacompra;
	}

	public void setTotalEnPesosDeLaCompra(BigDecimal totalEnPesosDeLaCompra) {
		this.totalenpesosdelacompra = totalEnPesosDeLaCompra;
	}
}
