package ec.gob.dinardap.seguridad.modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the usuario_perfil database table.
 * 
 */
@Entity
@Table(name="usuario_perfil", schema = "ec_dinardap_seguridad")
@NamedQuery(name="UsuarioPerfil.findAll", query="SELECT u FROM UsuarioPerfil u")
public class UsuarioPerfil implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="USUARIO_PERFIL_USUARIOPERFILID_GENERATOR", sequenceName="USUARIO_PERFIL_USUARIO_PERFIL_ID_SEQ", schema = "ec_dinardap_seguridad", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="USUARIO_PERFIL_USUARIOPERFILID_GENERATOR")
	@Column(name="usuario_perfil_id")
	private Integer usuarioPerfilId;

	private Short estado;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_asignacion")
	private Date fechaAsignacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_modificacion")
	private Date fechaModificacion;

	//bi-directional many-to-one association to Perfil
	@ManyToOne
	@JoinColumn(name="perfil_id")
	private Perfil perfil;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="usuario_id")
	private Usuario usuario;

	public UsuarioPerfil() {
	}

	public Integer getUsuarioPerfilId() {
		return this.usuarioPerfilId;
	}

	public void setUsuarioPerfilId(Integer usuarioPerfilId) {
		this.usuarioPerfilId = usuarioPerfilId;
	}

	public Short getEstado() {
		return this.estado;
	}

	public void setEstado(Short estado) {
		this.estado = estado;
	}

	public Date getFechaAsignacion() {
		return this.fechaAsignacion;
	}

	public void setFechaAsignacion(Date fechaAsignacion) {
		this.fechaAsignacion = fechaAsignacion;
	}

	public Date getFechaModificacion() {
		return this.fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public Perfil getPerfil() {
		return this.perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}