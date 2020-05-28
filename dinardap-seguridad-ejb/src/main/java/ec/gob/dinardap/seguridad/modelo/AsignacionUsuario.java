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
 * The persistent class for the asignacion_usuario database table.
 * 
 */
@Entity
@Table(name="asignacion_usuario", schema="ec_dinardap_seguridad")
@NamedQuery(name="AsignacionUsuario.findAll", query="SELECT a FROM AsignacionUsuario a")
public class AsignacionUsuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ASIGNACION_USUARIO_ASIGNACION_USUARIO_ID_GENERATOR", sequenceName="asignacion_usuario_asignacion_usuario_id_seq", schema="ec_dinardap_seguridad", allocationSize = 1 )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ASIGNACION_USUARIO_ASIGNACION_USUARIO_ID_GENERATOR")
	@Column(name="asignacion_usuario_id")
	private Integer asignacionUsuarioId;

	private Short estado;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_creacion")
	private Date fechaCreacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_modificacion")
	private Date fechaModificacion;

	//bi-directional many-to-one association to Institucion
	@ManyToOne
	@JoinColumn(name="institucion_id")
	private Institucion institucion;

	//bi-directional many-to-one association to Sistema
	@ManyToOne
	@JoinColumn(name="sistema_id")
	private Sistema sistema;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="usuario_id")
	private Usuario usuario;

	public AsignacionUsuario() {
	}

	public Integer getAsignacionUsuarioId() {
		return this.asignacionUsuarioId;
	}

	public void setAsignacionUsuarioId(Integer asignacionUsuarioId) {
		this.asignacionUsuarioId = asignacionUsuarioId;
	}

	public Short getEstado() {
		return this.estado;
	}

	public void setEstado(Short estado) {
		this.estado = estado;
	}

	public Date getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaModificacion() {
		return this.fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public Institucion getInstitucion() {
		return this.institucion;
	}

	public void setInstitucion(Institucion institucion) {
		this.institucion = institucion;
	}

	public Sistema getSistema() {
		return this.sistema;
	}

	public void setSistema(Sistema sistema) {
		this.sistema = sistema;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}