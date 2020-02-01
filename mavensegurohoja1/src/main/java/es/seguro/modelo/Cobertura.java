package es.seguro.modelo;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.Type;


/**
 * The persistent class for the cobertura database table.
 * 
 */
@Entity
@Table(name="cobertura")
@NamedQuery(name="Cobertura.findAll", query="SELECT c FROM Cobertura c")
public class Cobertura implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Type(type="true_false")
	private String dental;

	private String fecundacionInVitro;

	private String oftalmologia;

	//bi-directional one-to-one association to Seguro
	@OneToOne(mappedBy="cobertura")
	private Seguro seguro;

	public Cobertura() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDental() {
		return this.dental;
	}

	public void setDental(String dental) {
		this.dental = dental;
	}

	public String getFecundacionInVitro() {
		return this.fecundacionInVitro;
	}

	public void setFecundacionInVitro(String fecundacionInVitro) {
		this.fecundacionInVitro = fecundacionInVitro;
	}

	public String getOftalmologia() {
		return this.oftalmologia;
	}

	public void setOftalmologia(String oftalmologia) {
		this.oftalmologia = oftalmologia;
	}

	public Seguro getSeguro() {
		return this.seguro;
	}

	public void setSeguro(Seguro seguro) {
		this.seguro = seguro;
	}

}