package ec.gob.dinardap.seguridad.dao;

import javax.ejb.Local;

import ec.gob.dinardap.persistence.dao.GenericDao;
import ec.gob.dinardap.seguridad.modelo.Parametro;

@Local
public interface ParametroDao extends GenericDao<Parametro, String> {

}
