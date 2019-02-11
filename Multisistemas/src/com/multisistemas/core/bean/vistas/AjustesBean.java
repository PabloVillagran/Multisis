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

import com.multisistemas.dao.entity.DetalleTransaccion;
import com.multisistemas.dao.entity.Producto;
import com.multisistemas.dao.entity.TipoTransaccion;
import com.multisistemas.dao.entity.Transaccion;
import com.multisistemas.dao.service.DetalleTransaccionService;
import com.multisistemas.dao.service.ProductoService;
import com.multisistemas.dao.service.TipoTransaccionService;
import com.multisistemas.dao.service.TransaccionService;

@Named
@ViewScoped
public class AjustesBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private List<TipoTransaccion> tiposTransaccion;
	private Transaccion datosGenerales;
	private Long tipoSeleccionado;
	private Date fecha;
	private List<DetalleTransaccion> detalleTransaccion;

	private ProductoService productoService;
	private TransaccionService transaccionService;	
	private DetalleTransaccionService detalleTransaccionService;
	
	@PostConstruct
	public void init() {
		fecha = new Date();
		TipoTransaccionService tipoTransaccionService = new TipoTransaccionService();
		tiposTransaccion = tipoTransaccionService.selectTipos();
		datosGenerales = new Transaccion();
		agregarProducto();
	}
	
	public void agregarFila(int position) {
		DetalleTransaccion tmp = detalleTransaccion.get(position);
		if(tmp.getCantidad()>0) {
			agregarProducto();
		}
	}

	private void agregarProducto() {
		if(detalleTransaccion==null) {
			detalleTransaccion = new ArrayList<DetalleTransaccion>();
		}
		detalleTransaccion.add(new DetalleTransaccion());
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
		DetalleTransaccion actual = detalleTransaccion.get(position);
		Producto tmp = productoService.findById(actual.getIdProducto());
		actual.setDescProducto(tmp.getDescripcion());
	}
	
	public void completeByDesc(int position){
		productoService = new ProductoService();
		DetalleTransaccion actual = detalleTransaccion.get(position);
		Producto tmp = productoService.findByDesc(actual.getDescProducto());
		actual.setIdProducto(tmp.getIdProducto());
	}
	
	public void remover(int position) {
		detalleTransaccion.remove(position);
		if(detalleTransaccion.size()==0) {
			agregarProducto();
		}
	}
	
	public void guardar() {
		transaccionService = new TransaccionService();
		datosGenerales.setIdOrganizacional(0L);
		datosGenerales.setIdTipoTransaccion(tipoSeleccionado);
		Long idTransaccion = transaccionService.insertTransaccion(datosGenerales);
		datosGenerales.setIdTransaccion(idTransaccion);
		detalleTransaccionService = new DetalleTransaccionService();
		detalleTransaccionService.insert(detalleTransaccion, datosGenerales);
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Transacción satisfactoria!", "");
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

/////////////////////////////////////////////////////////////////////////////////////////////
	public List<TipoTransaccion> getTiposTransaccion() {
		return tiposTransaccion;
	}

	public void setTiposTransaccion(List<TipoTransaccion> tiposTransaccion) {
		this.tiposTransaccion = tiposTransaccion;
	}

	public Long getTipoSeleccionado() {
		return tipoSeleccionado;
	}

	public void setTipoSeleccionado(Long tipoSeleccionado) {
		this.tipoSeleccionado = tipoSeleccionado;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public List<DetalleTransaccion> getDetalleTransaccion() {
		return detalleTransaccion;
	}

	public void setDetalleTransaccion(List<DetalleTransaccion> detalleTransaccion) {
		this.detalleTransaccion = detalleTransaccion;
	}
	
	public Transaccion getDatosGenerales() {
		return datosGenerales;
	}

	public void setDatosGenerales(Transaccion datosGenerales) {
		this.datosGenerales = datosGenerales;
	}
}
