package ec.gob.dinardap.seguridad.dao.ejb;

import javax.ejb.Stateless;

import ec.gob.dinardap.persistence.dao.ejb.GenericDaoEjb;
import ec.gob.dinardap.seguridad.dao.UsuarioPerfilDao;
import ec.gob.dinardap.seguridad.modelo.UsuarioPerfil;

@Stateless(name = "UsuarioPerfilDao")
public class UsuarioPerfilDaoEjb extends GenericDaoEjb<UsuarioPerfil, Integer> implements UsuarioPerfilDao {

    public UsuarioPerfilDaoEjb() {
        super(UsuarioPerfil.class);
    }

}
