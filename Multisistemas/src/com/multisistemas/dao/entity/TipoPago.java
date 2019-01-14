package com.multisistemas.dao.entity;

import java.util.Date;

/**
 * Tabla FAC_TIPO_DE_PAGO
 * @author Pablo Villagrán
 *
 */
public class TipoPago {
	
	private long idTipoDePago;//	ID_TIPOS_DE_PAGO	NUMBER
	private String descripcion; //	DESCRIPCION	VARCHAR2(30 BYTE)
	private String usuarioIngreso;//	USUARIO_INGRESO	VARCHAR2(30 BYTE)
	private Date fechaIngreso;//	FECHA_INGRESO	DATE
	private String usuarioModifico;//	USUARIO_MODIFICO	VARCHAR2(30 BYTE)
	private Date fechaModifico;//	FECHA_MODIFICO	DATE
	public long getIdTipoDePago() {
		return idTipoDePago;
	}
	public void setIdTipoDePago(long idTipoDePago) {
		this.idTipoDePago = idTipoDePago;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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
}
