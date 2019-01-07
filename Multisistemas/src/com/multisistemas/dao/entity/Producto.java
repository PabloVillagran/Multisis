package com.multisistemas.dao.entity;

import java.util.Date;

/**
 * Tabla INV_PRODUCTO
 * @author Pablo Villagrán
 *
 */
public class Producto {

	private long idProducto;//	ID_PRODUCTO	NUMBER
	private String descripcion;//	DESCRIPCION	VARCHAR2(50 BYTE)
	private String descripcionAlternativa;//	DESCRIPCION_ALTERNATIVA	VARCHAR2(30 BYTE)
	private long fkIdProducto;//	FK_ID_PRODUCTO	NUMBER
	private long idPresentacion;//	ID_PRESENTACION	NUMBER
	private long idCategorizacion;//	ID_CATEGORIZACION	NUMBER
	private long idEstatusProducto;//	ID_ESTATUS_PRODUCTO	NUMBER
	private long existencia;//	EXISTENCIA	NUMBER
	private long precioCompra;//	PRECIO_COMPRA	NUMBER(10,2)
	private long precioVenta;//	PRECIO_VENTA	NUMBER(10,2)
	private byte[] imagen;//	IMAGEN	LONG RAW
	private String serie;//	SERIE	VARCHAR2(50 BYTE)
	private String codigoBarras;//	CODIGO_BARRAS	VARCHAR2(30 BYTE)
	private long cantidadMinima;//	CANTIDAD_MINIMA	NUMBER
	private String usuarioIngreso;//	USUARIO_INGRESO	VARCHAR2(30 BYTE)
	private Date fechaIngreso;//	FECHA_INGRESO	DATE
	private Date usuarioModifico;//	USUARIO_MODIFICO	VARCHAR2(30 BYTE)
	private Date fechaModifico;//	FECHA_MODIFICO	DATE
	private long idUnidadMedida;//	ID_UNIDAD_MEDIDA	NUMBER
	public long getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(long idProducto) {
		this.idProducto = idProducto;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getDescripcionAlternativa() {
		return descripcionAlternativa;
	}
	public void setDescripcionAlternativa(String descripcionAlternativa) {
		this.descripcionAlternativa = descripcionAlternativa;
	}
	public long getFkIdProducto() {
		return fkIdProducto;
	}
	public void setFkIdProducto(long fkIdProducto) {
		this.fkIdProducto = fkIdProducto;
	}
	public long getIdPresentacion() {
		return idPresentacion;
	}
	public void setIdPresentacion(long idPresentacion) {
		this.idPresentacion = idPresentacion;
	}
	public long getIdCategorizacion() {
		return idCategorizacion;
	}
	public void setIdCategorizacion(long idCategorizacion) {
		this.idCategorizacion = idCategorizacion;
	}
	public long getIdEstatusProducto() {
		return idEstatusProducto;
	}
	public void setIdEstatusProducto(long idEstatusProducto) {
		this.idEstatusProducto = idEstatusProducto;
	}
	public long getExistencia() {
		return existencia;
	}
	public void setExistencia(long existencia) {
		this.existencia = existencia;
	}
	public long getPrecioCompra() {
		return precioCompra;
	}
	public void setPrecioCompra(long precioCompra) {
		this.precioCompra = precioCompra;
	}
	public long getPrecioVenta() {
		return precioVenta;
	}
	public void setPrecioVenta(long precioVenta) {
		this.precioVenta = precioVenta;
	}
	public byte[] getImagen() {
		return imagen;
	}
	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
	}
	public String getSerie() {
		return serie;
	}
	public void setSerie(String serie) {
		this.serie = serie;
	}
	public String getCodigoBarras() {
		return codigoBarras;
	}
	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}
	public long getCantidadMinima() {
		return cantidadMinima;
	}
	public void setCantidadMinima(long cantidadMinima) {
		this.cantidadMinima = cantidadMinima;
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
	public Date getUsuarioModifico() {
		return usuarioModifico;
	}
	public void setUsuarioModifico(Date usuarioModifico) {
		this.usuarioModifico = usuarioModifico;
	}
	public Date getFechaModifico() {
		return fechaModifico;
	}
	public void setFechaModifico(Date fechaModifico) {
		this.fechaModifico = fechaModifico;
	}
	public long getIdUnidadMedida() {
		return idUnidadMedida;
	}
	public void setIdUnidadMedida(long idUnidadMedida) {
		this.idUnidadMedida = idUnidadMedida;
	}
	
}
