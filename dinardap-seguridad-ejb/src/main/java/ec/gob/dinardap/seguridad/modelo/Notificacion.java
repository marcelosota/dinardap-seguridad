package ec.gob.dinardap.seguridad.modelo;

import ec.gob.dinardap.seguridad.modelo.Institucion;
import ec.gob.dinardap.seguridad.modelo.Sistema;
import java.io.Serializable;
import java.lang.Integer;
import java.lang.Short;
import java.lang.String;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Notificacion
 *
 */
@Entity
@Table(name="notificacion", schema="ec_dinardap_seguridad")
@NamedQuery(name="Notificacion.findAll", query="SELECT n FROM Notificacion n")
public class Notificacion implements Serializable {
	private static final long serialVersionUID = 1L;
	   
	@Id
	@SequenceGenerator(name="NOTIFICACION_NOTIFICACIONID_GENERATOR", sequenceName="NOTIFICACION_NOTIFICACION_ID_SEQ", schema = "ec_dinardap_seguridad", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="NOTIFICACION_NOTIFICACIONID_GENERATOR")
	@Column(name="notificacion_id")
	private Integer notificacionId;
	
	@Column(name="correo_electronico")
	private String correoElectronico;
	
	private Short estado;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_registro")
	private Date fechaRegistro;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_modificacion")
	private Date fechaModificacion;
	
	//bi-directional many-to-one association to Perfil
	@ManyToOne
	@JoinColumn(name="institucion_id")
	private Institucion institucion;
	
	//bi-directional many-to-one association to Perfil
	@ManyToOne
	@JoinColumn(name="sistema_id")
	private Sistema sistema;
	

	public Notificacion() {
	}   
	public Integer getNotificacionId() {
		return this.notificacionId;
	}

	public void setNotificacionId(Integer notificacionId) {
		this.notificacionId = notificacionId;
	}   
	public String getCorreoElectronico() {
		return this.correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}   
	public Date getFechaRegistro() {
		return this.fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}   
	public Date getFechaModificacion() {
		return this.fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}   
	public Short getEstado() {
		return this.estado;
	}

	public void setEstado(Short estado) {
		this.estado = estado;
	}   
	public Institucion getInstitucion() {
		return this.institucion;
	}

	public void setInstitucion(Institucion institucion) {
		this.institucion = institucion;
	}   
	public Sistema getSistemaId() {
		return this.sistema;
	}

	public void setSistemaId(Sistema sistema) {
		this.sistema = sistema;
	}
   
}
