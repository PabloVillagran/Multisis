package com.multisistemas.dao.entity;

import java.util.Date;

/**
 * Tabla INV_TRANSACCION
 * @author Pablo Villagrán
 *
 */
public class Transaccion {

	private String serie;//	SERIE	VARCHAR2(30 BYTE)
	private Long numero;//	NUMERO	NUMBER
	private Date fechaTransaccion;//	FECHA_TRANSACCION	DATE
	private Long idTransaccion;//	ID_TRANSACCION	NUMBER
	private Long idTipoTransaccion;//	ID_TIPO_TRANSACCION	NUMBER
	private String usuarioIngreso;//	USUARIO_INGRESO	VARCHAR2(20 BYTE)
	private Date fechaIngreso;//	FECHA_INGRESO	DATE
	private String usuarioModifico;//	USUARIO_MODIFICO	VARCHAR2(20 BYTE)
	private Date fechaModifico;//	FECHA_MODIFICO	DATE
	private Long idEmpleado;//	ID_EMPLEADO	NUMBER
	private Long idOrganizacional;//	ID_ORGANIZACIONAL	NUMBER
	public String getSerie() {
		return serie;
	}
	public void setSerie(String serie) {
		this.serie = serie;
	}
	public Long getNumero() {
		return numero;
	}
	public void setNumero(Long numero) {
		this.numero = numero;
	}
	public Date getFechaTransaccion() {
		return fechaTransaccion;
	}
	public void setFechaTransaccion(Date fechaTransaccion) {
		this.fechaTransaccion = fechaTransaccion;
	}
	public Long getIdTransaccion() {
		return idTransaccion;
	}
	public void setIdTransaccion(Long idTransaccion) {
		this.idTransaccion = idTransaccion;
	}
	public Long getIdTipoTransaccion() {
		return idTipoTransaccion;
	}
	public void setIdTipoTransaccion(Long idTipoTransaccion) {
		this.idTipoTransaccion = idTipoTransaccion;
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
	public Long getIdEmpleado() {
		return idEmpleado;
	}
	public void setIdEmpleado(Long idEmpleado) {
		this.idEmpleado = idEmpleado;
	}
	public Long getIdOrganizacional() {
		return idOrganizacional;
	}
	public void setIdOrganizacional(Long idOrganizacional) {
		this.idOrganizacional = idOrganizacional;
	}
	
}
