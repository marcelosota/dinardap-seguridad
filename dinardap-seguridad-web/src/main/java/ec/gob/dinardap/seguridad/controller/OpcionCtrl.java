package ec.gob.dinardap.seguridad.controller;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.Application;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import ec.gob.dinardap.seguridad.dao.OpcionDao;
import ec.gob.dinardap.seguridad.modelo.Opcion;
import net.bootsfaces.component.dropMenu.DropMenu;
import net.bootsfaces.component.navBar.NavBar;
import net.bootsfaces.component.navBarLinks.NavBarLinks;
import net.bootsfaces.component.navLink.NavLink;

@Named(value="opcionCtrl")
@RequestScoped
public class OpcionCtrl {

	@EJB
	private OpcionDao opcionDao;
	
	private List<Opcion> menu;
	private NavBar navBar;
	private String valor1;
	private String valor2;
	
	public void consultarMenu() {
		navBar = new NavBar();
		Application application = FacesContext.getCurrentInstance().getApplication();		
		NavBarLinks navBarLinks = (NavBarLinks)application.createComponent(NavBarLinks.COMPONENT_TYPE);
		
		menu = opcionDao.obtenerOpciones(1);
		
		for(Opcion item : menu) {
			if(!item.getOpcions().isEmpty() && item.getOpcions().size() > 0) {
				DropMenu dropMenu = (DropMenu)application.createComponent(DropMenu.COMPONENT_TYPE);
				submenu(item.getOpcions(), dropMenu, application);
				dropMenu.setIconAwesome("birthday-cake");
				dropMenu.setDisplay("display");
				dropMenu.getAttributes().put("value", item.getNombre());
				navBarLinks.getChildren().add(dropMenu);
			}else {
				navBarLinks.getChildren().add(enlace(item, application));
			}
		}
		navBar.getChildren().add(navBarLinks);
		navBar.setBrand("Dinardap");
	}
	
	private DropMenu submenu(List<Opcion> item, DropMenu menuPadre, Application application) {
		for(int i = item.size() - 1; i >= 0; i--) {
			if(item.get(i).getOpcions().size() > 0) {
				DropMenu menuHijo = (DropMenu)application.createComponent(DropMenu.COMPONENT_TYPE);
				menuHijo = submenu(item.get(i).getOpcions(), menuHijo, application);
				menuHijo.setIconAwesome("birthday-cake");
				menuHijo.setDisplay("display");
				menuHijo.getAttributes().put("value", item.get(i).getNombre());
				menuPadre.getChildren().add(menuHijo);
				
			}else {
				menuPadre.getChildren().add(enlace(item.get(i), application));
			}
		}
		return menuPadre;
	}
	
	private NavLink enlace(Opcion item, Application application) {
		NavLink opcion = (NavLink)application.createComponent(NavLink.COMPONENT_TYPE);
		opcion.setValue(item.getNombre());
		opcion.setHref(item.getUrl());
		return opcion;
	}

	public List<Opcion> getMenu() {
		return menu;
	}

	public void setMenu(List<Opcion> menu) {
		this.menu = menu;
	}
	
	public NavBar getNavBar() {
		if(navBar == null)
			consultarMenu();
		return navBar;
	}

	public void setNavBar(NavBar navBar) {
		this.navBar = navBar;
	}

	public String getValor1() {
		return valor1;
	}

	public void setValor1(String valor1) {
		this.valor1 = valor1;
	}

	public String getValor2() {
		return valor2;
	}

	public void setValor2(String valor2) {
		this.valor2 = valor2;
	}
}
