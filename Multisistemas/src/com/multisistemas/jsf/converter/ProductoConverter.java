package com.multisistemas.jsf.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.multisistemas.dao.entity.Producto;
import com.multisistemas.dao.service.ProductoService;

@FacesConverter("ProductoConverter")
public class ProductoConverter implements Converter<Producto>{

	ProductoService service;
	
	@Override
	public Producto getAsObject(FacesContext context, UIComponent component, String value) {
		if(value==null || value.equals(""))
			return null;
		service = new ProductoService();
		try {
			Long valueLong = Long.valueOf(value);			
			return service.findById(valueLong);
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Producto producto) {
		if(producto==null) return null;
		else return String.valueOf(producto.getIdProducto());
	}
	
}
