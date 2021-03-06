package ec.gob.dinardap.seguridad.dao;

import javax.ejb.Local;

import ec.gob.dinardap.persistence.dao.GenericDao;
import ec.gob.dinardap.seguridad.modelo.Pregunta;

@Local
public interface PreguntaDao extends GenericDao<Pregunta, Integer> {

}
