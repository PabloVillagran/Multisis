package com.multisistemas.core.bean.vistas;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import com.multisistemas.dao.entity.Cliente;
import com.multisistemas.dao.entity.DetalleVenta;
import com.multisistemas.dao.entity.Producto;

@Named
@ViewScoped
public class VentasBean implements Serializable{

	private static final long serialVersionUID = 8021262959365365424L;

	private double total;
	private Cliente datosCliente;
	private List<DetalleVenta> detalleFactura;
	
	private List<Producto> productosDisponibles;
	
	@PostConstruct
	public void init() {
		
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Cliente getDatosCliente() {
		return datosCliente;
	}

	public void setDatosCliente(Cliente datosCliente) {
		this.datosCliente = datosCliente;
	}

	public List<DetalleVenta> getDetalleFactura() {
		return detalleFactura;
	}

	public void setDetalleFactura(List<DetalleVenta> detalleFactura) {
		this.detalleFactura = detalleFactura;
	}

	public List<Producto> getProductosDisponibles() {
		return productosDisponibles;
	}

	public void setProductosDisponibles(List<Producto> productosDisponibles) {
		this.productosDisponibles = productosDisponibles;
	}
}
