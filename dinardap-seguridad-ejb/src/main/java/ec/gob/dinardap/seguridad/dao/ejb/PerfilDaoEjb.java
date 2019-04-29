package ec.gob.dinardap.seguridad.dao.ejb;

import javax.ejb.Stateless;

import ec.gob.dinardap.seguridad.dao.PerfilDao;
import ec.gob.dinardap.seguridad.modelo.Perfil;

@Stateless(name="PerfilDao")
public class PerfilDaoEjb extends SeguridadGenericDao<Perfil, Integer> implements PerfilDao {

	public PerfilDaoEjb() {
		super(Perfil.class);
	}

}
