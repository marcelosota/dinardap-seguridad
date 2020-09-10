package ec.gob.dinardap.seguridad.dao;

import javax.ejb.Local;

import ec.gob.dinardap.persistence.dao.GenericDao;
import ec.gob.dinardap.seguridad.modelo.Institucion;
import java.util.List;

@Local
public interface InstitucionDao extends GenericDao<Institucion, Integer> {

    public List<Institucion> obtenerInstitucionPorCantonEstado(Integer cantonId, Short estado, List<Integer> tipoInstitucionId);
    
    public List<Institucion> obtenerHijosPorInstitucion(List <Integer> institucionIdList, Integer tipoInstitucion);
    
    public List<Institucion> obtenerInstitucionesActivasSistema(Integer sistemaId);

}
