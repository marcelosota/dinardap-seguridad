package ec.gob.dinardap.seguridad.dao.ejb;

import javax.ejb.Stateless;

import ec.gob.dinardap.persistence.dao.ejb.GenericDaoEjb;
import ec.gob.dinardap.seguridad.dao.AsignacionUsuarioDao;
import ec.gob.dinardap.seguridad.modelo.AsignacionUsuario;

@Stateless(name="AsignacionUsuarioDao")
public class AsignacionUsuarioDaoEjb extends GenericDaoEjb<AsignacionUsuario, Integer> implements AsignacionUsuarioDao {

	public AsignacionUsuarioDaoEjb() {
		super(AsignacionUsuario.class);
	}

	
}
