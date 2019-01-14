package com.multisistemas.dao.entity;

import java.util.Date;

/**
 * Tabla CC_CLIENTE
 * @author Pablo Villagrán
 */
public class Cliente {

	private long idCliente;//	ID_CLIENTE	NUMBER
	private String nombre;//	NOMBRE	VARCHAR2(50 BYTE)
	private String apellido;//	APELLIDO	CHAR(20 BYTE)
	private String nit;//	NIT	CHAR(20 BYTE)
	private long dpi;//	DPI	NUMBER
	private String telefono;//	TELEFONO	CHAR(20 BYTE)
	private String correoElectronico;//	CORREO_ELECTRONICO	CHAR(20 BYTE)
	private char sexo;//	SEXO	CHAR(1 BYTE)
	private Date fechaCumpleanos;//	FECHA_CUMPLEAÃ‘OS	DATE
	private double montoDeCredito;//	MONTO_DE_CREDITO	NUMBER(10,2)
	private long cantidadTecho;//	CANTIDAD_TECHO	NUMBER
	private Date fechaIngreso;//	FECHA_INGRESO	DATE
	private String usuarioIngreso;//	USUARIO_INGRESO	VARCHAR2(30 BYTE)
	private String usuarioModifico;//	USUARIO_MODIFICO	VARCHAR2(30 BYTE)
	private Date fechaModifico;//	FECHA_MODIFICO	DATE
	private long idARPU;//	ID_ARPU	NUMBER
	private long idGeografia;//	ID_GEOGRAFIA	NUMBER
	
	public long getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(long idCliente) {
		this.idCliente = idCliente;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getNit() {
		return nit;
	}
	public void setNit(String nit) {
		this.nit = nit;
	}
	public long getDpi() {
		return dpi;
	}
	public void setDpi(long dpi) {
		this.dpi = dpi;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getCorreoElectronico() {
		return correoElectronico;
	}
	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}
	public char getSexo() {
		return sexo;
	}
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	public Date getFechaCumpleanos() {
		return fechaCumpleanos;
	}
	public void setFechaCumpleanos(Date fechaCumpleanos) {
		this.fechaCumpleanos = fechaCumpleanos;
	}
	public double getMontoDeCredito() {
		return montoDeCredito;
	}
	public void setMontoDeCredito(double montoDeCredito) {
		this.montoDeCredito = montoDeCredito;
	}
	public long getCantidadTecho() {
		return cantidadTecho;
	}
	public void setCantidadTecho(long cantidadTecho) {
		this.cantidadTecho = cantidadTecho;
	}
	public Date getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	public String getUsuarioIngreso() {
		return usuarioIngreso;
	}
	public void setUsuarioIngreso(String usuarioIngreso) {
		this.usuarioIngreso = usuarioIngreso;
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
	public long getIdARPU() {
		return idARPU;
	}
	public void setIdARPU(long idARPU) {
		this.idARPU = idARPU;
	}
	public long getIdGeografia() {
		return idGeografia;
	}
	public void setIdGeografia(long idGeografia) {
		this.idGeografia = idGeografia;
	}
	
}
