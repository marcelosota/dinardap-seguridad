package ec.gob.dinardap.seguridad.servicio.impl;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.gob.dinardap.persistence.dao.GenericDao;
import ec.gob.dinardap.persistence.servicio.impl.GenericServiceImpl;
import ec.gob.dinardap.seguridad.dao.GestionarExcelDao;
import ec.gob.dinardap.seguridad.modelo.GestionarExcel;
import ec.gob.dinardap.seguridad.servicio.GestionarExcelServicio;

@Stateless(name="GestionarExcelServicio")
public class GestionarExcelServicioImpl extends GenericServiceImpl<GestionarExcel, Integer>
		implements GestionarExcelServicio {

	@EJB
	private GestionarExcelDao gestionarExcelDao;
	
	@Override
	public GenericDao<GestionarExcel, Integer> getDao() {
		return gestionarExcelDao;
	}

}
