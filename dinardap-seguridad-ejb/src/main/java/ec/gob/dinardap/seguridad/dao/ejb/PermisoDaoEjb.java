package ec.gob.dinardap.seguridad.dao.ejb;

import javax.ejb.Stateless;

import ec.gob.dinardap.seguridad.dao.PermisoDao;
import ec.gob.dinardap.seguridad.modelo.Permiso;

@Stateless(name="PermisoDao")
public class PermisoDaoEjb extends SeguridadGenericDao<Permiso, Integer> implements PermisoDao {

	public PermisoDaoEjb() {
		super(Permiso.class);
	}

}
