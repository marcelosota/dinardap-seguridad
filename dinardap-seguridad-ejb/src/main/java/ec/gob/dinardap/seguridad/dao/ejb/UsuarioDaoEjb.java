package ec.gob.dinardap.seguridad.dao.ejb;

import javax.ejb.Stateless;

import ec.gob.dinardap.persistence.dao.ejb.GenericDaoEjb;
import ec.gob.dinardap.seguridad.dao.UsuarioDao;
import ec.gob.dinardap.seguridad.modelo.Usuario;

@Stateless(name="UsuarioDao")
public class UsuarioDaoEjb extends GenericDaoEjb<Usuario, Integer> implements UsuarioDao {

	public UsuarioDaoEjb() {
		super(Usuario.class);
	}

}
