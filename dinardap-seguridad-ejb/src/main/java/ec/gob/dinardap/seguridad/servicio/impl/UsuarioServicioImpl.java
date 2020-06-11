package ec.gob.dinardap.seguridad.servicio.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.gob.dinardap.persistence.constante.CriteriaTypeEnum;
import ec.gob.dinardap.persistence.dao.GenericDao;
import ec.gob.dinardap.persistence.servicio.impl.GenericServiceImpl;
import ec.gob.dinardap.persistence.util.Criteria;
import ec.gob.dinardap.seguridad.dao.UsuarioDao;
import ec.gob.dinardap.seguridad.modelo.Usuario;
import ec.gob.dinardap.seguridad.servicio.UsuarioServicio;

@Stateless(name="UsuarioServicio")
public class UsuarioServicioImpl extends GenericServiceImpl<Usuario, Integer> implements UsuarioServicio {

	@EJB
	private UsuarioDao usuarioDao;
	@Override
	public GenericDao<Usuario, Integer> getDao() {
		return usuarioDao;
	}
	@SuppressWarnings("null")
	@Override
	public Usuario obtenerUsuarioPorIdentificacion(String identificacion) {
		String[] criteriaNombres = {"cedula"};
		CriteriaTypeEnum[] criteriaTipos = {CriteriaTypeEnum.STRING_EQUALS};
		Object[] criteriaValores = {identificacion};
		
		Criteria criteria = new Criteria(criteriaNombres, criteriaTipos, criteriaValores);
		List<Usuario> lista = findByCriterias(criteria);
		if(lista != null && !lista.isEmpty())
			return lista.get(0);
		else
			return null;
	}

}
