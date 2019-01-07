package com.multisistemas.dao.entity;

import java.util.Date;

/**
 * Tabla FAC_VENTAS
 * @author Pablo Villagrán
 */
public class Venta {

	private long idVenta;//	ID_VENTAS	NUMBER
	private String direccionCliente;//	DIRECCION_CLIENTE	VARCHAR2(50 BYTE)
	private String serie;//	SERIE	VARCHAR2(30 BYTE)
	private long numero;//	NUMERO	NUMBER
	private Date fecha;//	FECHA	DATE
	private double total;//	TOTAL	NUMBER(10,2)
	private double valorTotal;//	VALOR_TOTAL	NUMBER(10,2)
	private String nit;//	NIT	VARCHAR2(30 BYTE)
	private String nombreCliente;//	NOMBRE_CLIENTE	VARCHAR2(50 BYTE)
	private double subtotal;//	SUBTOTAL	NUMBER(10,2)
	private double descuento;//	DESCUENTO	NUMBER(10,2)
	private double iva;//	IVA	NUMBER(10,2)
	private long idCliente;//	ID_CLIENTE	NUMBER
	private long idEmpleado;//	ID_EMPLEADO	NUMBER
	private int idTipoVenta;//	ID_TIPO_VENTA	NUMBER
	private long idHistoricoImpuesto;//	ID_HISTORICO_IMPUESTO	NUMBER
	private long idOrganizacion;//	ID_ORGANIZACION	NUMBER
	private long idTipoTransaccion;//	ID_TIPO_TRANSACCION	NUMBER
	private String observacion;//	OBSERVACION	VARCHAR2(100 BYTE)
	private long idEstatusVentas;//	ID_ESTATUS_VENTAS	NUMBER
	private String usuarioIngreso;//	USUARIO_INGRESO	VARCHAR2(30 BYTE)
	private Date fechaIngreso;//	FECHA_INGRESO	DATE
	private String usuarioModifico;//	USUARIO_MODIFICO	VARCHAR2(30 BYTE)
	private Date fechaModifico;//	FECHA_MODIFICO	DATE
	public long getIdVenta() {
		return idVenta;
	}
	public void setIdVenta(long idVenta) {
		this.idVenta = idVenta;
	}
	public String getDireccionCliente() {
		return direccionCliente;
	}
	public void setDireccionCliente(String direccionCliente) {
		this.direccionCliente = direccionCliente;
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
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
	public String getNit() {
		return nit;
	}
	public void setNit(String nit) {
		this.nit = nit;
	}
	public String getNombreCliente() {
		return nombreCliente;
	}
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
	public double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
	public double getDescuento() {
		return descuento;
	}
	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}
	public double getIva() {
		return iva;
	}
	public void setIva(double iva) {
		this.iva = iva;
	}
	public long getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(long idCliente) {
		this.idCliente = idCliente;
	}
	public long getIdEmpleado() {
		return idEmpleado;
	}
	public void setIdEmpleado(long idEmpleado) {
		this.idEmpleado = idEmpleado;
	}
	public int getIdTipoVenta() {
		return idTipoVenta;
	}
	public void setIdTipoVenta(int idTipoVenta) {
		this.idTipoVenta = idTipoVenta;
	}
	public long getIdHistoricoImpuesto() {
		return idHistoricoImpuesto;
	}
	public void setIdHistoricoImpuesto(long idHistoricoImpuesto) {
		this.idHistoricoImpuesto = idHistoricoImpuesto;
	}
	public long getIdOrganizacion() {
		return idOrganizacion;
	}
	public void setIdOrganizacion(long idOrganizacion) {
		this.idOrganizacion = idOrganizacion;
	}
	public long getIdTipoTransaccion() {
		return idTipoTransaccion;
	}
	public void setIdTipoTransaccion(long idTipoTransaccion) {
		this.idTipoTransaccion = idTipoTransaccion;
	}
	public String getObservacion() {
		return observacion;
	}
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	public long getIdEstatusVentas() {
		return idEstatusVentas;
	}
	public void setIdEstatusVentas(long idEstatusVentas) {
		this.idEstatusVentas = idEstatusVentas;
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
