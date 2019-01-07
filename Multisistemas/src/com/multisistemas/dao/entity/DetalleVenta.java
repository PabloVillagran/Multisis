package com.multisistemas.dao.entity;

import java.util.Date;

/**
 * Tabla FAC_DETALLE_VENTA
 * @author Pablo Villagrán
 *
 */
public class DetalleVenta {

	private double valor;//	VALOR	NUMBER(10,2)
	private long cantidad;//	CANTIDAD	NUMBER
	private long idDetalleVenta;//	ID_DETALLE_VENTA	NUMBER
	private long idProducto;//	ID_PRODUCTO	NUMBER
	private long idVentas;//	ID_VENTAS	NUMBER
	private double precioTotal;//	PRECIO_TOTAL	NUMBER(10,2)
	private double precioUnitario;//	PRECIO_UNITARIO	NUMBER(10,2)
	private String usuarioIngreso;//	USUARIO_INGRESO	VARCHAR2(30 BYTE)
	private Date fechaIngreso;//	FECHA_INGRESO	DATE
	private String usuarioModifico;//	USUARIO_MODIFICO	VARCHAR2(30 BYTE)
	private Date fechaModifico;//	FECHA_MODIFICO	DATE
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public long getCantidad() {
		return cantidad;
	}
	public void setCantidad(long cantidad) {
		this.cantidad = cantidad;
	}
	public long getIdDetalleVenta() {
		return idDetalleVenta;
	}
	public void setIdDetalleVenta(long idDetalleVenta) {
		this.idDetalleVenta = idDetalleVenta;
	}
	public long getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(long idProducto) {
		this.idProducto = idProducto;
	}
	public long getIdVentas() {
		return idVentas;
	}
	public void setIdVentas(long idVentas) {
		this.idVentas = idVentas;
	}
	public double getPrecioTotal() {
		return precioTotal;
	}
	public void setPrecioTotal(double precioTotal) {
		this.precioTotal = precioTotal;
	}
	public double getPrecioUnitario() {
		return precioUnitario;
	}
	public void setPrecioUnitario(double precioUnitario) {
		this.precioUnitario = precioUnitario;
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
