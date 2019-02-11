package com.multisistemas.dao.entity;

import java.util.Date;

/**
 * Tabla INV_DETALLE_TRANSACCION
 * @author Pablo Villagrán
 *
 */
public class DetalleTransaccion {

	private Long idDetalleTransaccion;//	ID_DETALLE_TRANSACCION	NUMBER
	private double valor;//	VALOR	NUMBER(10,2)
	private Long idTransaccion;//	ID_TRANSACCION	NUMBER
	private Long idProducto;//	ID_PRODUCTO	NUMBER
	private int cantidad;//	CANTIDAD	NUMBER
	private String usuarioIngreso;//	USUARIO_INGRESO	VARCHAR2(30 BYTE)
	private Date fechaIngreso;//	FECHA_INGRESO	DATE
	private String UsuarioModifico;//	USUARIO_MODIFICO	VARCHAR2(30 BYTE)
	private Date fechaModifico;//	FECHA_MODIFICO	DATE
	
	private String descProducto;
	
	public Long getIdDetalleTransaccion() {
		return idDetalleTransaccion;
	}
	public void setIdDetalleTransaccion(Long idDetalleTransaccion) {
		this.idDetalleTransaccion = idDetalleTransaccion;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public Long getIdTransaccion() {
		return idTransaccion;
	}
	public void setIdTransaccion(Long idTransaccion) {
		this.idTransaccion = idTransaccion;
	}
	public Long getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(Long idProducto) {
		this.idProducto = idProducto;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
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
		return UsuarioModifico;
	}
	public void setUsuarioModifico(String usuarioModifico) {
		UsuarioModifico = usuarioModifico;
	}
	public Date getFechaModifico() {
		return fechaModifico;
	}
	public void setFechaModifico(Date fechaModifico) {
		this.fechaModifico = fechaModifico;
	}
	public String getDescProducto() {
		return descProducto;
	}
	public void setDescProducto(String descProducto) {
		this.descProducto = descProducto;
	}
	
}
