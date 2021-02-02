package ec.gob.dinardap.seguridad.servicio.impl;

import ec.gob.dinardap.persistence.constante.CriteriaTypeEnum;
import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.gob.dinardap.persistence.dao.GenericDao;
import ec.gob.dinardap.persistence.servicio.impl.GenericServiceImpl;
import ec.gob.dinardap.persistence.util.Criteria;
import ec.gob.dinardap.seguridad.dao.RespuestaDao;
import ec.gob.dinardap.seguridad.modelo.Respuesta;
import ec.gob.dinardap.seguridad.servicio.RespuestaServicio;
import ec.gob.dinardap.util.constante.EstadoEnum;
import java.util.List;

@Stateless(name = "RespuestaServicio")
public class RespuestaServicioImpl extends GenericServiceImpl<Respuesta, Integer> implements RespuestaServicio {

    @EJB
    private RespuestaDao respuestaDao;

    @Override
    public GenericDao<Respuesta, Integer> getDao() {
        return respuestaDao;
    }

    @Override
    public List<Respuesta> getRespuestasActivas(Integer usuarioId) {
        String[] criteriaNombres = {"estado", "usuario.usuarioId"};
        CriteriaTypeEnum[] criteriaTipos = {CriteriaTypeEnum.SHORT_EQUALS, CriteriaTypeEnum.INTEGER_EQUALS};
        Object[] criteriaValores = {EstadoEnum.ACTIVO.getEstado(), usuarioId};
        String[] orderBy = {"respuestaId"};
        boolean[] asc = {false};
        Criteria criteria = new Criteria(criteriaNombres, criteriaTipos, criteriaValores, orderBy, asc);
        return findByCriterias(criteria);
        
    }

    @Override
    public Respuesta getRespuestaByUsuario(Integer idUsuario, Integer idPregunta) {
        Respuesta respuesta = new Respuesta();
        String[] criteriaNombres = {"usuario.usuarioId", "pregunta.preguntaId", "estado"};
        CriteriaTypeEnum[] criteriaTipos = {CriteriaTypeEnum.INTEGER_EQUALS, CriteriaTypeEnum.INTEGER_EQUALS, CriteriaTypeEnum.SHORT_EQUALS};
        Object[] criteriaValores = {idUsuario, idPregunta, EstadoEnum.ACTIVO.getEstado()};
        String[] orderBy = {"respuestaId"};
        boolean[] asc = {false};
        Criteria criteria = new Criteria(criteriaNombres, criteriaTipos, criteriaValores, orderBy, asc);
        if (!findByCriterias(criteria).isEmpty()){
            respuesta = findByCriterias(criteria).get(0);
        }
        return respuesta;
    }

}
