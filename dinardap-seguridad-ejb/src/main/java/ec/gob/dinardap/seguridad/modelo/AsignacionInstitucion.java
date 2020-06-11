package ec.gob.dinardap.seguridad.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the asignacion_institucion database table.
 * 
 */
@Entity
@Table(name="asignacion_institucion", schema="ec_dinardap_seguridad")
@NamedQuery(name="AsignacionInstitucion.findAll", query="SELECT a FROM AsignacionInstitucion a")
public class AsignacionInstitucion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ASIGNACION_INSTITUCION_ASIGNACIONINSTITUCIONID_GENERATOR", sequenceName="ASIGNACION_INSTITUCION_ASIGNACION_INSTITUCION_ID_SEQ", schema="ec_dinardap_seguridad", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ASIGNACION_INSTITUCION_ASIGNACIONINSTITUCIONID_GENERATOR")
	@Column(name="asignacion_institucion_id")
	private Integer asignacionInstitucionId;

	private Short estado;

	@Column(name="fecha_creacion")
	private Timestamp fechaCreacion;

	@Column(name="fecha_modificacion")
	private Timestamp fechaModificacion;

	//bi-directional many-to-one association to Institucion
	@ManyToOne
	@JoinColumn(name="institucion_id")
	private Institucion institucion;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="usuario_id")
	private Usuario usuario;

	public AsignacionInstitucion() {
	}

	public Integer getAsignacionInstitucionId() {
		return this.asignacionInstitucionId;
	}

	public void setAsignacionInstitucionId(Integer asignacionInstitucionId) {
		this.asignacionInstitucionId = asignacionInstitucionId;
	}

	public Short getEstado() {
		return this.estado;
	}

	public void setEstado(Short estado) {
		this.estado = estado;
	}

	public Timestamp getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Timestamp fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Timestamp getFechaModificacion() {
		return this.fechaModificacion;
	}

	public void setFechaModificacion(Timestamp fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public Institucion getInstitucion() {
		return this.institucion;
	}

	public void setInstitucion(Institucion institucion) {
		this.institucion = institucion;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}