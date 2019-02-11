package com.multisistemas.dao.entity;

import java.sql.Date;

/**
 * Tabla INV_TIPO_TRANSACCION
 * @author Pablo Villagrán
 *
 */
public class TipoTransaccion {
	
	private Long idTipoTransaccion;//	ID_TIPO_TRANSACCION	NUMBER
	private String descripcion;//	DESCRIPCION	VARCHAR2(50 BYTE)
	private Object formula;//	FORMULA	XMLTYPE
	private String usuarioIngreso;//	USUARIO_INGRESO	VARCHAR2(30 BYTE)
	private Date fechaIngreso;//	FECHA_INGRESO	DATE
	private String usuarioModifico;//	USUARIO_MODIFICO	VARCHAR2(30 BYTE)
	private Date fechaModifico;//	FECHA_MODIFICO	DATE
	
	public Long getIdTipoTransaccion() {
		return idTipoTransaccion;
	}
	public void setIdTipoTransaccion(Long idTipoTransaccion) {
		this.idTipoTransaccion = idTipoTransaccion;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Object getXmltype() {
		return formula;
	}
	public void setXmltype(Object formula) {
		this.formula = formula;
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
