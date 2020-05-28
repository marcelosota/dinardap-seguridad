package ec.gob.dinardap.seguridad.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	@SequenceGenerator(name="INSTITUCION_INSTITUCIONID_GENERATOR", sequenceName="institucion_institucion_id_seq", schema="ec_dinardap_seguridad", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="INSTITUCION_INSTITUCIONID_GENERATOR")
	@Column(name="institucion_id")
	private Integer institucionId;

	@Column(name="canton_id")
	private Integer cantonId;

	@Column(name="codigo_is")
	private Integer codigoIs;

	private Short estado;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_modificacion")
	private Date fechaModificacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_registro")
	private Date fechaRegistro;

	private String nombre;

	private String ruc;

	private String siglas;

	//bi-directional many-to-one association to AsignacionUsuario
	@OneToMany(mappedBy="institucion")
	private List<AsignacionUsuario> asignacionUsuarios;

	//bi-directional many-to-one association to Fuente
	@OneToMany(mappedBy="institucion")
	private List<Fuente> fuentes;

	//bi-directional many-to-one association to Institucion
	@ManyToOne
	@JoinColumn(name="ins_institucion_id")
	private Institucion institucion;

	//bi-directional many-to-one association to Institucion
	@OneToMany(mappedBy="institucion")
	private List<Institucion> institucions;

	//bi-directional many-to-one association to TipoInstitucion
	@ManyToOne
	@JoinColumn(name="tipo_institucion_id")
	private TipoInstitucion tipoInstitucion;

	public Institucion() {
	}

	public Integer getInstitucionId() {
		return this.institucionId;
	}

	public void setInstitucionId(Integer institucionId) {
		this.institucionId = institucionId;
	}

	public Integer getCantonId() {
		return this.cantonId;
	}

	public void setCantonId(Integer cantonId) {
		this.cantonId = cantonId;
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

	public String getRuc() {
		return this.ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	public String getSiglas() {
		return this.siglas;
	}

	public void setSiglas(String siglas) {
		this.siglas = siglas;
	}

	public List<AsignacionUsuario> getAsignacionUsuarios() {
		return this.asignacionUsuarios;
	}

	public void setAsignacionUsuarios(List<AsignacionUsuario> asignacionUsuarios) {
		this.asignacionUsuarios = asignacionUsuarios;
	}

	public AsignacionUsuario addAsignacionUsuario(AsignacionUsuario asignacionUsuario) {
		getAsignacionUsuarios().add(asignacionUsuario);
		asignacionUsuario.setInstitucion(this);

		return asignacionUsuario;
	}

	public AsignacionUsuario removeAsignacionUsuario(AsignacionUsuario asignacionUsuario) {
		getAsignacionUsuarios().remove(asignacionUsuario);
		asignacionUsuario.setInstitucion(null);

		return asignacionUsuario;
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

	public Institucion getInstitucion() {
		return this.institucion;
	}

	public void setInstitucion(Institucion institucion) {
		this.institucion = institucion;
	}

	public List<Institucion> getInstitucions() {
		return this.institucions;
	}

	public void setInstitucions(List<Institucion> institucions) {
		this.institucions = institucions;
	}

	public Institucion addInstitucion(Institucion institucion) {
		getInstitucions().add(institucion);
		institucion.setInstitucion(this);

		return institucion;
	}

	public Institucion removeInstitucion(Institucion institucion) {
		getInstitucions().remove(institucion);
		institucion.setInstitucion(null);

		return institucion;
	}

	public TipoInstitucion getTipoInstitucion() {
		return this.tipoInstitucion;
	}

	public void setTipoInstitucion(TipoInstitucion tipoInstitucion) {
		this.tipoInstitucion = tipoInstitucion;
	}

}