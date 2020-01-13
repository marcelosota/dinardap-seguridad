package ec.gob.dinardap.seguridad.dao.ejb;

import javax.ejb.Stateless;

import ec.gob.dinardap.persistence.dao.ejb.GenericDaoEjb;
import ec.gob.dinardap.seguridad.dao.TipoDatoDao;
import ec.gob.dinardap.seguridad.modelo.TipoDato;

@Stateless(name="TipoDatoDao")
public class TipoDatoDaoEjb extends GenericDaoEjb<TipoDato, Short> implements TipoDatoDao {

	public TipoDatoDaoEjb() {
		super(TipoDato.class);
	}

}
