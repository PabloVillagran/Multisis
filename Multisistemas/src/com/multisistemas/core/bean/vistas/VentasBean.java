package com.multisistemas.core.bean.vistas;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;

import javax.inject.Named;

import com.multisistemas.dao.entity.Cliente;
import com.multisistemas.dao.entity.DetalleVenta;
import com.multisistemas.dao.entity.Producto;
import com.multisistemas.dao.service.ProductoService;

@Named
@SessionScoped
public class VentasBean implements Serializable{

	private static final long serialVersionUID = 8021262959365365424L;

	private double total;
	private Cliente datosCliente;
	private List<DetalleVenta> detalleFactura;
	
	ProductoService productoService;
	
//	private List<Producto> productosDisponibles;
	
	@PostConstruct
	public void init() {
		detalleFactura = new ArrayList<DetalleVenta>();
		agregarFila();
	}
	
	public List<String> completeCodigo(String codigo){
		productoService = new ProductoService();
//		return productoService.getByCodigo(codigo);
		return productoService.getCodigosLike(codigo);
	}
	
	public List<String> completeDesc(String desc){
		productoService = new ProductoService();
//		return productoService.getByDescripcion(desc);
		return productoService.getDescripcionLike(desc);
	}
	
	public void completeById(int position){
		productoService = new ProductoService();
		DetalleVenta actual = detalleFactura.get(position);
		Producto tmp = productoService.findById(actual.getIdProducto());
		actual.setDescripcionProducto(tmp.getDescripcion());
		actual.setPrecioUnitario(tmp.getPrecioVenta());
//		PrimeFaces.current().executeScript("alert(document.getElementById('factura-detalles-"+position+"-q_input'));");
//		PrimeFaces.current().executeScript("document.getElementById('factura-detalles-"+position+"-q_input').focus();");
	}
	
	public void completeByDesc(int position){
		productoService = new ProductoService();
		DetalleVenta actual = detalleFactura.get(position);
		Producto tmp = productoService.findByDesc(actual.getDescripcionProducto());
		actual.setIdProducto(tmp.getIdProducto());
		actual.setPrecioUnitario(tmp.getPrecioVenta());
	}
	
	public void calcular(int position) {
		DetalleVenta actual = detalleFactura.get(position);
		if(actual.getCantidad()>0) {
			actual.setValor(actual.getCantidad()*actual.getPrecioUnitario());
			calcularTotal();
			agregarFila();
//			PrimeFaces.current().executeScript("$(function(){PrimeFaces.focus('factura-detalles-"+(position+1)+"-c_input');});");			
		}
	}
	
	public void remover(int position) {
		detalleFactura.remove(position);
		if(detalleFactura.size()==0) {
			agregarFila();
		}
		calcularTotal();
	}
	
	private void calcularTotal() {
		total = 0;
		for(DetalleVenta det : detalleFactura) {
			total+=det.getValor();
		}
	}

	private void agregarFila() {
		DetalleVenta elemento = new DetalleVenta();
		detalleFactura.add(elemento);
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

}
