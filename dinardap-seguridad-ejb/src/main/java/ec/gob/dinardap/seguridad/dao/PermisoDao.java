package ec.gob.dinardap.seguridad.dao;

import javax.ejb.Local;

import ec.gob.dinardap.persistence.dao.GenericDao;
import ec.gob.dinardap.seguridad.modelo.Permiso;

@Local
public interface PermisoDao extends GenericDao<Permiso, Integer> {

}
