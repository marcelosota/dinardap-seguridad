package ec.gob.dinardap.seguridad.modelo;

import java.io.Serializable;
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

/**
 * Entity implementation class for Entity: TipoDato
 *
 */
@Entity
@Table(name="tipo_dato", schema="ec_dinardap_seguridad")
@NamedQuery(name="TipoDato.findAll", query="SELECT t FROM TipoDato t")
public class TipoDato implements Serializable {

	private static final long serialVersionUID = 1L;
	   
	@Id
	@SequenceGenerator(name="TIPODATO_TIPODATOID_GENERATOR", sequenceName="tipo_dato_tipo_dato_id_seq", schema="ec_dinardap_seguridad", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TIPODATO_TIPODATOID_GENERATOR")
	@Column(name="tipo_dato_id")
	private Short tipoDatoId;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="estado")
	private Short estado;
	
	//bi-directional many-to-one association to Fuente
	@OneToMany(mappedBy="tipoDato")
	private List<GestionarExcel> gestionarExcels;
	
	public TipoDato() {
		super();
	}   
	public Short getTipoDatoId() {
		return this.tipoDatoId;
	}

	public void setTipoDatoId(Short tipoDatoId) {
		this.tipoDatoId = tipoDatoId;
	}   
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}   
	public Short getEstado() {
		return this.estado;
	}

	public void setEstado(Short estado) {
		this.estado = estado;
	}
	
	public List<GestionarExcel> getGestionarExcels() {
		return gestionarExcels;
	}
	public void setGestionarExcels(List<GestionarExcel> gestionarExcels) {
		this.gestionarExcels = gestionarExcels;
	}
	
	public GestionarExcel addGestionarExcel(GestionarExcel gestionarExcel) {
		getGestionarExcels().add(gestionarExcel);
		gestionarExcel.setTipoDato(this);

		return gestionarExcel;
	}

	public GestionarExcel removeGestionarExcel(GestionarExcel gestionarExcel) {
		getGestionarExcels().remove(gestionarExcel);
		gestionarExcel.setTipoDato(null);

		return gestionarExcel;
	}   
}
