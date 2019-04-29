package ec.gob.dinardap.seguridad.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the institucion database table.
 * 
 */
@Entity
@Table(name="institucion", schema="ec_dinardap_seguridad")
@NamedQuery(name="Institucion.findAll", query="SELECT i FROM Institucion i")
public class Institucion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="INSTITUCION_INSTITUCIONID_GENERATOR", sequenceName="INSTITUCION_INSTITUCION_ID_SEQ", schema="ec_dinardap_seguridad", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="INSTITUCION_INSTITUCIONID_GENERATOR")
	@Column(name="institucion_id")
	private Integer institucionId;

	@Column(name="codigo_is")
	private Integer codigoIs;

	@Column(name="estado")
	private Short estado;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_modificacion")
	private Date fechaModificacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_registro")
	private Date fechaRegistro;

	@Column(name="nombre", length = 128)
	private String nombre;

	@Column(name="siglas", length = 16)
	private String siglas;

	//bi-directional many-to-one association to Fuente
	@OneToMany(mappedBy="institucion")
	private List<Fuente> fuentes;

	public Institucion() {
	}

	public Integer getInstitucionId() {
		return this.institucionId;
	}

	public void setInstitucionId(Integer institucionId) {
		this.institucionId = institucionId;
	}

	public Integer getCodigoIs() {
		return this.codigoIs;
	}

	public void setCodigoIs(Integer codigoIs) {
		this.codigoIs = codigoIs;
	}

	public Short getEstado() {
		return this.estado;
	}

	public void setEstado(Short estado) {
		this.estado = estado;
	}

	public Date getFechaModificacion() {
		return this.fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public Date getFechaRegistro() {
		return this.fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getSiglas() {
		return this.siglas;
	}

	public void setSiglas(String siglas) {
		this.siglas = siglas;
	}

	public List<Fuente> getFuentes() {
		return this.fuentes;
	}

	public void setFuentes(List<Fuente> fuentes) {
		this.fuentes = fuentes;
	}

	public Fuente addFuente(Fuente fuente) {
		getFuentes().add(fuente);
		fuente.setInstitucion(this);

		return fuente;
	}

	public Fuente removeFuente(Fuente fuente) {
		getFuentes().remove(fuente);
		fuente.setInstitucion(null);

		return fuente;
	}

}