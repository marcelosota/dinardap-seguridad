package ec.gob.dinardap.seguridad.servicio.impl;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.gob.dinardap.persistence.dao.GenericDao;
import ec.gob.dinardap.persistence.servicio.impl.GenericServiceImpl;
import ec.gob.dinardap.seguridad.dao.UsuarioPerfilDao;
import ec.gob.dinardap.seguridad.modelo.UsuarioPerfil;
import ec.gob.dinardap.seguridad.servicio.UsuarioPerfilServicio;

@Stateless(name = "UsuarioPerfilServicio")
public class UsuarioPerfilServicioImpl extends GenericServiceImpl<UsuarioPerfil, Integer> implements UsuarioPerfilServicio {

    @EJB
    private UsuarioPerfilDao usuarioPerfilDao;

    @Override
    public GenericDao<UsuarioPerfil, Integer> getDao() {
        return usuarioPerfilDao;
    }

}
