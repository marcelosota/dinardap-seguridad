package ec.gob.dinardap.seguridad.dao.ejb;

import javax.ejb.Stateless;

import ec.gob.dinardap.persistence.dao.ejb.GenericDaoEjb;
import ec.gob.dinardap.seguridad.dao.AsignacionInstitucionDao;
import ec.gob.dinardap.seguridad.modelo.AsignacionInstitucion;

@Stateless(name="AsignacionInstitucionDao")
public class AsignacionInstitucionDaoEjb extends GenericDaoEjb<AsignacionInstitucion, Integer> implements AsignacionInstitucionDao {

	public AsignacionInstitucionDaoEjb() {
		super(AsignacionInstitucion.class);
	}

	
}
