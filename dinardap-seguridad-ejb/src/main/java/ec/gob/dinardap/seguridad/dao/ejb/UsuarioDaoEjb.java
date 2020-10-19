package ec.gob.dinardap.seguridad.dao.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.gob.dinardap.persistence.dao.ejb.GenericDaoEjb;
import ec.gob.dinardap.seguridad.dao.UsuarioDao;
import ec.gob.dinardap.seguridad.dto.ValidacionDto;
import ec.gob.dinardap.seguridad.modelo.AsignacionInstitucion;
import ec.gob.dinardap.seguridad.modelo.Respuesta;
import ec.gob.dinardap.seguridad.modelo.Usuario;
import ec.gob.dinardap.seguridad.modelo.UsuarioPerfil;
import ec.gob.dinardap.util.constante.EstadoEnum;
import java.util.ArrayList;

@Stateless(name = "UsuarioDao")
public class UsuarioDaoEjb extends GenericDaoEjb<Usuario, Integer> implements UsuarioDao {

    public UsuarioDaoEjb() {
        super(Usuario.class);
    }

    @SuppressWarnings("unchecked")
    @Override
    public ValidacionDto validarUsuario(String identificacion, String contrasena, Integer sistemaId) {
        ValidacionDto validacion = null;

        StringBuilder sql = new StringBuilder("select u.usuario_id, ai.institucion_id, p.perfil_id, p.nombre from ec_dinardap_seguridad.usuario u ");
        sql.append("inner join ec_dinardap_seguridad.usuario_perfil up on u.usuario_id = up.usuario_id ");
        sql.append("inner join ec_dinardap_seguridad.perfil p on p.perfil_id = up.perfil_id ");
        sql.append("inner join ec_dinardap_seguridad.asignacion_institucion ai on u.usuario_id = ai.usuario_id  ");
        sql.append("inner join ec_dinardap_seguridad.institucion i on i.institucion_id = ai.institucion_id ");
        sql.append("where ");
        sql.append(" u.cedula = '").append(identificacion).append("'");
        sql.append(" and u.contrasena = '").append(contrasena).append("'");
        sql.append(" and p.sistema_id = ").append(sistemaId);
        sql.append(" and u.estado = ").append(EstadoEnum.ACTIVO.getEstado());
        sql.append(" and p.estado = ").append(EstadoEnum.ACTIVO.getEstado());
        sql.append(" and up.estado = ").append(EstadoEnum.ACTIVO.getEstado());
        sql.append(" and ai.estado = ").append(EstadoEnum.ACTIVO.getEstado());
        sql.append(" and i.estado = ").append(EstadoEnum.ACTIVO.getEstado());
        sql.append(" ORDER BY p.perfil_id asc");

        Query query = em.createNativeQuery(sql.toString());
        List<Object[]> lista = query.getResultList();
        if (lista != null && lista.size() > 0) {
            validacion = new ValidacionDto();
            boolean flag = true;
            for (Object[] item : lista) {
                if (flag) {
                    validacion.setUsuarioId(Integer.parseInt(item[0].toString()));
                    validacion.setInstitucionId(Integer.parseInt(item[1].toString()));
                    validacion.setPerfil(item[2].toString().replace("\"", "'"));
                    flag = false;
                } else {
                    validacion.setPerfil(validacion.getPerfil().concat(",").concat(item[3].toString().replace("\"", "'")));
                }
            }
        }
        return validacion;
    }

    @SuppressWarnings("unchecked")
    @Override
    public ValidacionDto validarUsuarioArreglo(String identificacion, String contrasena, Integer sistemaId) {
        ValidacionDto validacion = null;

        StringBuilder sql = new StringBuilder("select u.usuario_id, ");
        sql.append("array_to_string(array_agg(distinct ai.institucion_id), ',') miinstitucion, ");
        sql.append("array_to_string(array_agg(distinct p.perfil_id order by p.perfil_id asc), ',') miperfil, ");
        sql.append("array_to_string(array_agg(distinct p.nombre), ',') nombre ");
        sql.append("from ec_dinardap_seguridad.usuario u ");
        sql.append("inner join ec_dinardap_seguridad.usuario_perfil up on u.usuario_id = up.usuario_id ");
        sql.append("inner join ec_dinardap_seguridad.perfil p on p.perfil_id = up.perfil_id ");
        sql.append("inner join ec_dinardap_seguridad.asignacion_institucion ai on u.usuario_id = ai.usuario_id  ");
        sql.append("inner join ec_dinardap_seguridad.institucion i on i.institucion_id = ai.institucion_id ");
        sql.append("where ");
        sql.append(" u.cedula = '").append(identificacion).append("'");
        sql.append(" and u.contrasena = '").append(contrasena).append("'");
        sql.append(" and p.sistema_id = ").append(sistemaId);
        sql.append(" and u.estado = ").append(EstadoEnum.ACTIVO.getEstado());
        sql.append(" and p.estado = ").append(EstadoEnum.ACTIVO.getEstado());
        sql.append(" and up.estado = ").append(EstadoEnum.ACTIVO.getEstado());
        sql.append(" and ai.estado = ").append(EstadoEnum.ACTIVO.getEstado());
        sql.append(" and i.estado = ").append(EstadoEnum.ACTIVO.getEstado());
        sql.append(" group by 1");

        Query query = em.createNativeQuery(sql.toString());
        List<Object[]> lista = query.getResultList();

        if (lista != null && lista.size() > 0) {
            validacion = new ValidacionDto();
            for (Object[] item : lista) {
                validacion.setUsuarioId(Integer.parseInt(item[0].toString()));
                validacion.setInstitucion(item[1].toString());
                validacion.setPerfil(item[2].toString());
            }
        }
        return validacion;
    }

    @Override
    public List<Usuario> obtenerUsuariosActivosSistema(Integer sistemaId) {
        List<UsuarioPerfil> usuarioPerfilList = new ArrayList<UsuarioPerfil>();
        Query query = em.createQuery("SELECT up FROM UsuarioPerfil up WHERE up.perfil.sistema.sistemaId=:sistemaId AND up.usuario.estado=:estado");
        query.setParameter("sistemaId", sistemaId);
        query.setParameter("estado", EstadoEnum.ACTIVO.getEstado());
        usuarioPerfilList = query.getResultList();
        List<Usuario> usuarioList = new ArrayList<Usuario>();
        for (UsuarioPerfil usuarioPerfil : usuarioPerfilList) {
            usuarioPerfil.getUsuario().getUsuarioId();
            usuarioList.add(usuarioPerfil.getUsuario());
        }
        for (Usuario u : usuarioList) {
            for (AsignacionInstitucion ai : u.getAsignacionInstitucions()) {
                ai.getAsignacionInstitucionId();
            }
            for (UsuarioPerfil up : u.getUsuarioPerfilList()) {
                up.getUsuarioPerfilId();
            }
            for (Respuesta r : u.getRespuestas()) {
                r.getRespuestaId();
            }
        }
        return usuarioList;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Usuario> obtenerUsuariosPorInstitucionTipoPerfil(List<Integer> institucionIdList, List<Integer> tipoInstitucionList, Integer perfilId) {
        String separador = ",";
        String instituciones = String.join(separador, institucionIdList.toString());
        String tiposInstitucion = String.join(separador, tipoInstitucionList.toString());
        StringBuilder sql = new StringBuilder("SELECT u.usuario_id, u.cedula, u.nombre, u.correo_electronico ");
        sql.append("FROM ec_dinardap_seguridad.usuario u ");
        sql.append("INNER JOIN ec_dinardap_seguridad.usuario_perfil up ON u.usuario_id = up.usuario_id ");
        sql.append("INNER JOIN ec_dinardap_seguridad.perfil p ON up.perfil_id = p.perfil_id ");
        sql.append("INNER JOIN ec_dinardap_seguridad.asignacion_institucion ai ON u.usuario_id = ai.usuario_id ");
        sql.append("INNER JOIN ec_dinardap_seguridad.institucion i ON ai.institucion_id = i.institucion_id ");
        sql.append("WHERE i.institucion_id IN (").append(instituciones).append(") ");
        sql.append("AND i.tipo_institucion_id IN (").append(tiposInstitucion).append(") ");
        sql.append("AND p.perfil_id = ").append(perfilId);
        sql.append(" AND ai.estado = ").append(EstadoEnum.ACTIVO.getEstado());
        sql.append(" AND u.estado = ").append(EstadoEnum.ACTIVO.getEstado());
        sql.append(" AND up.estado = ").append(EstadoEnum.ACTIVO.getEstado());
        sql.append(" AND p.estado = ").append(EstadoEnum.ACTIVO.getEstado());

        Query query = em.createNativeQuery(sql.toString(), Usuario.class);
        return query.getResultList();
    }

}
