package ec.gob.dinardap.seguridad.dao.ejb;

import javax.ejb.Stateless;

import ec.gob.dinardap.persistence.dao.ejb.GenericDaoEjb;
import ec.gob.dinardap.seguridad.dao.SistemaDao;
import ec.gob.dinardap.seguridad.modelo.Sistema;

@Stateless(name="SistemaDao")
public class SistemaDaoEjb extends GenericDaoEjb<Sistema, Integer> implements SistemaDao {

	public SistemaDaoEjb() {
		super(Sistema.class);
	}

}
