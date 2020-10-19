package ec.gob.dinardap.seguridad.servicio.impl;

import ec.gob.dinardap.persistence.constante.CriteriaTypeEnum;
import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.gob.dinardap.persistence.dao.GenericDao;
import ec.gob.dinardap.persistence.servicio.impl.GenericServiceImpl;
import ec.gob.dinardap.persistence.util.Criteria;
import ec.gob.dinardap.seguridad.dao.UsuarioDao;
import ec.gob.dinardap.seguridad.dto.UsuarioDto;
import ec.gob.dinardap.seguridad.dto.ValidacionDto;
import ec.gob.dinardap.seguridad.modelo.Usuario;
import ec.gob.dinardap.seguridad.servicio.AsignacionInstitucionServicio;
import ec.gob.dinardap.seguridad.servicio.UsuarioServicio;
import ec.gob.dinardap.util.constante.EstadoEnum;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Stateless(name = "UsuarioServicio")
public class UsuarioServicioImpl extends GenericServiceImpl<Usuario, Integer> implements UsuarioServicio {

    @EJB
    private UsuarioDao usuarioDao;

    @EJB
    private AsignacionInstitucionServicio asignacionInstitucion;

    @Override
    public GenericDao<Usuario, Integer> getDao() {
        return usuarioDao;
    }

    @Override
    public Usuario obtenerUsuarioPorIdentificacion(String identificacion) {
        String[] criteriaNombres = {"cedula"};
        CriteriaTypeEnum[] criteriaTipos = {CriteriaTypeEnum.STRING_EQUALS};
        Object[] criteriaValores = {identificacion};

        Criteria criteria = new Criteria(criteriaNombres, criteriaTipos, criteriaValores);
        List<Usuario> lista = findByCriterias(criteria);
        if (lista != null && !lista.isEmpty()) {
            return lista.get(0);
        } else {
            return null;
        }
    }

    @Override
    public UsuarioDto crearUsuario(UsuarioDto usuarioDto) {
        Usuario usuario = new Usuario();
        usuario.setCedula(usuarioDto.getCedula());
        usuario.setNombre(usuarioDto.getNombre());
        usuario.setCargo(usuarioDto.getCargo());
        usuario.setCorreoElectronico(usuarioDto.getCorreoElectronico());
        usuario.setTelefono(usuarioDto.getTelefono());
        usuario.setContrasena(usuarioDto.getContrasena());
        usuario.setEstado(EstadoEnum.ACTIVO.getEstado());
        usuario.setFechaCreacion(new Timestamp(new Date().getTime()));
        create(usuario);
        usuarioDto.setUsuarioId(usuario.getUsuarioId());
        return usuarioDto;
    }

    @Override
    public Usuario crearUsuario(Usuario usuario) {
        create(usuario);
        return usuario;
    }

    @Override
    public void modificarUsuario(UsuarioDto usuarioDto) {
        Usuario usuario = new Usuario();
        //usuario = findByPk(usuarioDto.getUsuarioId());
        usuario.setUsuarioId(usuarioDto.getUsuarioId());
        usuario.setCedula(usuarioDto.getCedula());
        usuario.setNombre(usuarioDto.getNombre());
        usuario.setCargo(usuarioDto.getCargo());
        usuario.setCorreoElectronico(usuarioDto.getCorreoElectronico());
        usuario.setTelefono(usuarioDto.getTelefono());
        usuario.setContrasena(usuarioDto.getContrasena());
        usuario.setEstado(usuarioDto.getEstado());
        usuario.setFechaCreacion(usuarioDto.getFechaCreacion());
        usuario.setFechaModificacion(new Timestamp(new Date().getTime()));
        update(usuario);
        if (usuarioDto.getInstitucionId() != null) {
            asignacionInstitucion.asignarUsuarioInstitucion(usuarioDto.getUsuarioId(), usuarioDto.getInstitucionId());
        }
    }

    @Override
    public ValidacionDto validarUsuario(String identificacion, String contrasena, Integer sistemaId) {
        return usuarioDao.validarUsuarioArreglo(identificacion, contrasena, sistemaId);
    }

    @Override
    public void actualizarContrasena(String identificacion, String contrasena) {
        Usuario usuario = new Usuario();
        usuario = obtenerUsuarioPorIdentificacion(identificacion);
        usuario.setContrasena(contrasena);
        usuario.setFechaModificacion(new Timestamp(new Date().getTime()));
        update(usuario);
    }

    @Override
    public Usuario verificarCredenciales(String cedula, String contrasena) {
        String[] criteriaNombres = {"cedula", "contrasena"};
        CriteriaTypeEnum[] criteriaTipos = {CriteriaTypeEnum.STRING_EQUALS, CriteriaTypeEnum.STRING_EQUALS};
        Object[] criteriaValores = {cedula, contrasena};

        Criteria criteria = new Criteria(criteriaNombres, criteriaTipos, criteriaValores);
        List<Usuario> listado = findByCriterias(criteria);
        if (listado != null && listado.size() == 1) {
            return listado.get(0);
        } else {
            return null;
        }
    }
}
