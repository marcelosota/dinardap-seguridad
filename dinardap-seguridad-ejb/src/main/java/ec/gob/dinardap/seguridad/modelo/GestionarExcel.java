package ec.gob.dinardap.seguridad.modelo;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.Short;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: GestionarExcel
 *
 */
@Entity
@Table(name="gestionar_excel", schema="ec_dinardap_seguridad")
@NamedQuery(name="GestionarExcel.findAll", query="SELECT g FROM GestionarExcel g")
public class GestionarExcel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="GESTIONAREXCEL_GESTIONAREXCELID_GENERATOR", sequenceName="gestionar_excel_gestionar_excel_id_seq", schema="ec_dinardap_seguridad", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="GESTIONAREXCEL_GESTIONAREXCELID_GENERATOR")
	@Column(name="gestinar_excel_id")
	private Integer gestionarExcelId;
	
	@Column(name="columna")
	private String columna;
	
	@Column(name="estado")
	private Short estado;
	
	@Column(name="fila")
	private Integer fila;
	
	@Column(name="hoja")
	private String hoja;
	
	@Column(name="longitud")
	private Integer longitud;
	
	@Column(name="nombre_campo")
	private String nombreCampo;
	
	@Column(name="orden_campo")
	private Short ordenCampo;
	
	@Column(name="orden_hoja")
	private Short ordenHoja;
	
	@Column(name="tipo_documento")
	private Short tipoDocumento;
	
	//bi-directional many-to-one association to Opcion
	@ManyToOne
	@JoinColumn(name="tipo_dato_id")
	private TipoDato tipoDato;
	
	//bi-directional many-to-one association to Sistema
	@ManyToOne
	@JoinColumn(name="sistema_id")
	private Sistema sistema;
	
	public GestionarExcel() {
		super();
	}

	public Integer getGestionarExcelId() {
		return gestionarExcelId;
	}

	public void setGestionarExcelId(Integer gestionarExcelId) {
		this.gestionarExcelId = gestionarExcelId;
	}

	public String getColumna() {
		return columna;
	}

	public void setColumna(String columna) {
		this.columna = columna;
	}

	public Short getEstado() {
		return estado;
	}

	public void setEstado(Short estado) {
		this.estado = estado;
	}

	public Integer getFila() {
		return fila;
	}

	public void setFila(Integer fila) {
		this.fila = fila;
	}

	public String getHoja() {
		return hoja;
	}

	public void setHoja(String hoja) {
		this.hoja = hoja;
	}

	public Integer getLongitud() {
		return longitud;
	}

	public void setLongitud(Integer longitud) {
		this.longitud = longitud;
	}

	public String getNombreCampo() {
		return nombreCampo;
	}

	public void setNombreCampo(String nombreCampo) {
		this.nombreCampo = nombreCampo;
	}

	public Short getOrdenCampo() {
		return ordenCampo;
	}

	public void setOrdenCampo(Short ordenCampo) {
		this.ordenCampo = ordenCampo;
	}

	public Short getOrdenHoja() {
		return ordenHoja;
	}

	public void setOrdenHoja(Short ordenHoja) {
		this.ordenHoja = ordenHoja;
	}

	public Short getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(Short tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public TipoDato getTipoDato() {
		return tipoDato;
	}

	public void setTipoDato(TipoDato tipoDato) {
		this.tipoDato = tipoDato;
	}

	public Sistema getSistema() {
		return this.sistema;
	}

	public void setSistema(Sistema sistema) {
		this.sistema = sistema;
	}  
	
   
}
