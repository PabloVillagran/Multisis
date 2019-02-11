package com.multisistemas.core.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.MenuModel;

@Named
@SessionScoped
public class MainBean implements Serializable{

	private static final long serialVersionUID = 17592972040174L;
	
	private String dirxhtml;
	private String descripcion;
	private MenuModel menu;
	
	public MainBean() {
		setDescripcion("main");
		populateMenu();
	}
	
	@PostConstruct
	public void init() {
		setDescripcion("main");
		populateMenu();
	}

	public void exit(){
		try{
			ExternalContext ex = FacesContext.getCurrentInstance().getExternalContext();
			ex.invalidateSession();
			FacesContext.getCurrentInstance().getApplication().getNavigationHandler().handleNavigation(FacesContext.getCurrentInstance(), null, "/index.xhtml");
			System.out.println("IndexBean.exit()");
		}catch(NullPointerException e){
			System.err.println("IndexBean.exit() exception " + e.getMessage());
		}
	}
	
	public void redirect(String where, String descripcion){
		if(where==null || where.equals("")) {
			setDirxhtml(null);
			setDescripcion("main");
		}else {
			FacesContext.getCurrentInstance().getViewRoot().getViewMap().clear();
			setDirxhtml("vistas/"+where+".xhtml");
			setDescripcion(descripcion);
		}
	}

	private void populateMenu() {
		this.menu = new DefaultMenuModel();
		DefaultMenuItem ventas = new DefaultMenuItem("Ventas");
		ventas.setAjax(false);
		ventas.setCommand("#{mainBean.redirect('ventas', 'Ventas')}");
		this.menu.addElement(ventas);
		
		DefaultMenuItem ajustes = new DefaultMenuItem("Ajustes");
		ajustes.setAjax(false);
		ajustes.setCommand("#{mainBean.redirect('ajustes', 'Ajustes')}");
		this.menu.addElement(ajustes);
		// TODO	
	}

	public String getDirxhtml() {
		return dirxhtml;
	}

	public void setDirxhtml(String dirxhtml) {
		this.dirxhtml = dirxhtml;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public MenuModel getMenu() {
		return menu;
	}

	public void setMenu(MenuModel menu) {
		this.menu = menu;
	}
	
}
