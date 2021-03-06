package com.multisistemas.core.bean.vistas;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.PrimeFaces;

import com.multisistemas.dao.entity.Cliente;
import com.multisistemas.dao.entity.DetallePagosVentas;
import com.multisistemas.dao.entity.DetalleVenta;
import com.multisistemas.dao.entity.EntidadFinanciera;
import com.multisistemas.dao.entity.Producto;
import com.multisistemas.dao.entity.TipoPago;
import com.multisistemas.dao.entity.Venta;
import com.multisistemas.dao.service.ClienteService;
import com.multisistemas.dao.service.DetallePagosVentaService;
import com.multisistemas.dao.service.DetalleVentaService;
import com.multisistemas.dao.service.EntidadFinancieraService;
import com.multisistemas.dao.service.ProductoService;
import com.multisistemas.dao.service.TipoPagoService;
import com.multisistemas.dao.service.VentasService;

@Named
@ViewScoped
public class VentasBean implements Serializable{

	private static final long serialVersionUID = 8021262959365365424L;

	private double saldo;
	private double total;
	private Cliente datosCliente;
	private List<DetalleVenta> detalleFactura;
	private String direccion;
	private Date fecha;
	private List<DetallePagosVentas> pagos;
	
	private List<TipoPago> tipoPagoDisp;
	private List<EntidadFinanciera> entsFinan;
	private boolean clienteExistente;
	
	ProductoService productoService;
	
//	private List<Producto> productosDisponibles;
	
	@PostConstruct
	public void init() {
		tipoPagoDisp = new TipoPagoService().select();
		entsFinan = new EntidadFinancieraService().select();
		limpiarDatos();
	}
	
	public void agregarTipoPago() {
		if(pagos==null)pagos = new ArrayList<DetallePagosVentas>();
		pagos.add(new DetallePagosVentas());
	}
	
	public void removerPago(int position) {
		pagos.remove(position);
		if(pagos.isEmpty())agregarTipoPago();
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
	
	public void buscarCliente() {
		ClienteService clienteService = new ClienteService();
		datosCliente = clienteService.buscarCliente(datosCliente);
		clienteExistente = datosCliente.getNombre()!=null && datosCliente.getNombre().length()>0;
	}
	
//	public void calcularSaldos() {
//		double totalPagos = 0;
//		for(DetallePagosVentas pago : pagos) {
//			totalPagos += pago.getValor();
//		}
//		saldo = total - totalPagos;
//	}
	
	public void remover(int position) {
		detalleFactura.remove(position);
		if(detalleFactura.size()==0) {
			agregarFila();
		}
		calcularTotal();
	}
	
	public void completarTransaccion() {
		if(saldo<=0) {
			VentasService ventasService = new VentasService();
			Venta venta = prepararVenta();
			venta.setIdVenta(ventasService.insertVenta(venta));
			DetalleVentaService detalleVentaService = new DetalleVentaService();
			detalleVentaService.insertDetalle(detalleFactura, venta);
			
			DetallePagosVentaService detPagosVentaService = new DetallePagosVentaService();
			detPagosVentaService.insertDetalle(pagos, venta);
			limpiarDatos();
			
			if(!clienteExistente) {
				
				ClienteService clienteService = new ClienteService();
				clienteService.insertarCliente(datosCliente);
			}
			PrimeFaces.current().executeScript("PF('formas-pago').hide(); ");
		}else {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Saldo pendiente.", "");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
	}
	
	private Venta prepararVenta() {
		Venta tmp = new Venta();
		tmp.setDireccionCliente(direccion);
		tmp.setSerie("A");
		tmp.setNumero(1);
		tmp.setFecha(new java.sql.Date(new Date().getTime()));
		tmp.setTotal(total);
		tmp.setValorTotal(total);
		tmp.setNit(datosCliente.getNit());
		tmp.setNombreCliente((datosCliente.getNombre() + " " + datosCliente.getApellido()).trim());
		tmp.setSubtotal(total);
		tmp.setDescuento(0);
		tmp.setIva(total-(total/1.12));
		tmp.setIdCliente(datosCliente.getIdCliente());
		tmp.setIdEmpleado(0);
		tmp.setIdTipoVenta(0);
		tmp.setIdHistoricoImpuesto(0);
		tmp.setIdOrganizacion(0);
		tmp.setIdTipoTransaccion(0);
		tmp.setObservacion("");
		tmp.setIdEstatusVentas(0);
//		tmp.setUsuarioIngreso(usuarioIngreso);
		tmp.setFechaIngreso(new java.sql.Date(new Date().getTime()));
		return tmp;
	}

	public void limpiarDatos() {
		datosCliente = new Cliente();
		if(detalleFactura!=null) {
			detalleFactura.clear();			
		}
		detalleFactura = new ArrayList<DetalleVenta>();
		if(pagos!=null) {
			pagos.clear();			
		}
		pagos = new ArrayList<DetallePagosVentas>();
		direccion = null;
		fecha = new Date();
		total = 0;
		agregarTipoPago();
		agregarFila();
	}
	
	public void calcularTotal() {
		total = 0;
		for(DetalleVenta det : detalleFactura) {
			total+=det.getValor();
		}
		double totalPagos = 0;
		for(DetallePagosVentas pago : pagos) {
			totalPagos += pago.getValor();
		}
		saldo = total - totalPagos;
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

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public List<TipoPago> getTipoPagoDisp() {
		return tipoPagoDisp;
	}

	public void setTipoPagoDisp(List<TipoPago> tipoPagoDisp) {
		this.tipoPagoDisp = tipoPagoDisp;
	}

	public List<DetallePagosVentas> getPagos() {
		return pagos;
	}

	public void setPagos(List<DetallePagosVentas> pagos) {
		this.pagos = pagos;
	}
	
	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public List<EntidadFinanciera> getEntsFinan() {
		return entsFinan;
	}

	public void setEntsFinan(List<EntidadFinanciera> entsFinan) {
		this.entsFinan = entsFinan;
	}

	public boolean isClienteExistente() {
		return clienteExistente;
	}

	public void setClienteExistente(boolean clienteExistente) {
		this.clienteExistente = clienteExistente;
	}
	
}
