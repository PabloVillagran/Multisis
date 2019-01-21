package com.multisistemas.dao.entity;

import java.sql.Date;

/**
 * Tabla CC_ENTIDAD_FINANCIERA
 * @author Pablo Villagrán
 *
 */
public class EntidadFinanciera {

	private long idEntidadFinanciera;//	ID_ENTIDAD_FINANCIERA	NUMBER
	private String nombre;//	NOMBRE	VARCHAR2(50 BYTE)
	private String usuarioIngreso;//	USUARIO_INGRESO	VARCHAR2(30 BYTE)
	private Date fechaIngreso;//	FECHA_INGRESO	DATE
	private String usuarioModifico;//	USUARIO_MODIFICO	VARCHAR2(30 BYTE)
	private Date fechaModifico;//	FECHA_MODIFICO	DATE
	private long idTipoEntidadFinanciera;//	ID_TIPO_ENTIDAD_FINANCIERA	NUMBER
	
	public long getIdEntidadFinanciera() {
		return idEntidadFinanciera;
	}
	public void setIdEntidadFinanciera(long idEntidadFinanciera) {
		this.idEntidadFinanciera = idEntidadFinanciera;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
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
	public long getIdTipoEntidadFinanciera() {
		return idTipoEntidadFinanciera;
	}
	public void setIdTipoEntidadFinanciera(long idTipoEntidadFinanciera) {
		this.idTipoEntidadFinanciera = idTipoEntidadFinanciera;
	}
	
}
