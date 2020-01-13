package ec.gob.dinardap.seguridad.dao.ejb;

import javax.ejb.Stateless;

import ec.gob.dinardap.persistence.dao.ejb.GenericDaoEjb;
import ec.gob.dinardap.seguridad.dao.GestionarExcelDao;
import ec.gob.dinardap.seguridad.modelo.GestionarExcel;

@Stateless(name="GestionarExcelDao")
public class GestionarExcelDaoEjb extends GenericDaoEjb<GestionarExcel, Integer> implements GestionarExcelDao {

	public GestionarExcelDaoEjb() {
		super(GestionarExcel.class);
	}

}
