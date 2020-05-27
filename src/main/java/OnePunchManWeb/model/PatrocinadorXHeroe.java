package OnePunchManWeb.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import javax.persistence.CascadeType;

@Entity
@Table(name="patrocinadorxheroe")
public class PatrocinadorXHeroe {
	@Id
	private int ID;
	@JoinColumn(name = "ID_Patrocinador", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private Patrocinador patrocinador;
	@JoinColumn(name = "ID_Heroe", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private Heroe heroe;
	
	public int getId() {
		return ID;
	}
	public void setId(int iD) {
		ID = iD;
	}
	public int getPatrocinador() {
		return patrocinador.getId();
	}
	public void setPatrocinador(Patrocinador patrocinador) {
		this.patrocinador = patrocinador;
	}
	public String getHeroe() {
		return heroe.getNombre();
	}
	public void setHeroe(Heroe heroe) {
		this.heroe = heroe;
	}
	public PatrocinadorXHeroe(int id, Patrocinador patrocinador, Heroe heroe) {
		super();
		this.patrocinador = patrocinador;
		this.heroe = heroe;
	}
	public PatrocinadorXHeroe() {
		super();
	}
	
	
}
