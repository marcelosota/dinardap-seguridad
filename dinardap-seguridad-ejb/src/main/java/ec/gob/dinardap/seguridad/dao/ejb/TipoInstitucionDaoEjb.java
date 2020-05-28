package ec.gob.dinardap.seguridad.dao.ejb;

import javax.ejb.Stateless;

import ec.gob.dinardap.persistence.dao.ejb.GenericDaoEjb;
import ec.gob.dinardap.seguridad.dao.TipoInstitucionDao;
import ec.gob.dinardap.seguridad.modelo.TipoInstitucion;

@Stateless(name="TipoInstitucionDao")
public class TipoInstitucionDaoEjb extends GenericDaoEjb<TipoInstitucion, Integer> implements TipoInstitucionDao {

	public TipoInstitucionDaoEjb() {
		super(TipoInstitucion.class);
	}

}
