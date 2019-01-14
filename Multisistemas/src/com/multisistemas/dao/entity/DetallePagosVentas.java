package com.multisistemas.dao.entity;

import java.sql.Date;

public class DetallePagosVentas {
	
	private long idDetallePagosVentas;//	ID_DETALLE_PAGOS_VENTAS	NUMBER
	private String serie;//	SERIE	VARCHAR2(30 BYTE)
	private long numero;//	NUMERO	NUMBER
	private double valor;//	VALOR	NUMBER(10,2)
	private String usuarioIngreso;//	USUARIO_INGRESO	VARCHAR2(30 BYTE)
	private Date fechaIngreso;//	FECHA_INGRESO	DATE
	private String usuarioModifico;//	USUARIO_MODIFICO	VARCHAR2(30 BYTE)
	private Date fechaModifico;//	FECHA_MODIFICO	DATE
	private long idVentas;//	ID_VENTAS	NUMBER
	private Date fechaAutorizacion;//	FECHA_AUTORIZACION	DATE
	private long numeroAutorizacion;//	NUMERO_AUTORIZACION	NUMBER
	private long idEntidadFinanciera;//	ID_ENTIDAD_FINANCIERA	NUMBER
	private long idTiposDePago;//	ID_TIPOS_DE_PAGO	NUMBER
	
	public long getIdDetallePagosVentas() {
		return idDetallePagosVentas;
	}
	public void setIdDetallePagosVentas(long idDetallePagosVentas) {
		this.idDetallePagosVentas = idDetallePagosVentas;
	}
	public String getSerie() {
		return serie;
	}
	public void setSerie(String serie) {
		this.serie = serie;
	}
	public long getNumero() {
		return numero;
	}
	public void setNumero(long numero) {
		this.numero = numero;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public String getUsuarioIngreso() {
		return usuarioIngreso;
	}
	public void setUsuarioIngreso(String usuarioIngreso) {
		this.usuarioIngreso = usuarioIngreso;
	}
	public Date getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	public String getUsuarioModifico() {
		return usuarioModifico;
	}
	public void setUsuarioModifico(String usuarioModifico) {
		this.usuarioModifico = usuarioModifico;
	}
	public Date getFechaModifico() {
		return fechaModifico;
	}
	public void setFechaModifico(Date fechaModifico) {
		this.fechaModifico = fechaModifico;
	}
	public long getIdVentas() {
		return idVentas;
	}
	public void setIdVentas(long idVentas) {
		this.idVentas = idVentas;
	}
	public Date getFechaAutorizacion() {
		return fechaAutorizacion;
	}
	public void setFechaAutorizacion(Date fechaAutorizacion) {
		this.fechaAutorizacion = fechaAutorizacion;
	}
	public long getNumeroAutorizacion() {
		return numeroAutorizacion;
	}
	public void setNumeroAutorizacion(long numeroAutorizacion) {
		this.numeroAutorizacion = numeroAutorizacion;
	}
	public long getIdEntidadFinanciera() {
		return idEntidadFinanciera;
	}
	public void setIdEntidadFinanciera(long idEntidadFinanciera) {
		this.idEntidadFinanciera = idEntidadFinanciera;
	}
	public long getIdTiposDePago() {
		return idTiposDePago;
	}
	public void setIdTiposDePago(long idTiposDePago) {
		this.idTiposDePago = idTiposDePago;
	}
	
}
