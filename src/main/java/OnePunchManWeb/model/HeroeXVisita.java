package OnePunchManWeb.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="heroexvisita")
public class HeroeXVisita {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID;
	@JoinColumn(name = "ID_Visita", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private Visita visita;
	@JoinColumn(name = "ID_Heroe", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private Heroe heroe;
	
	public int getId() {
		return ID;
	}
	public void setId(int iD) {
		ID = iD;
	}
	public int getHeroe() {
		return heroe.getId();
	}
	public void setHeroe(Heroe heroe) {
		this.heroe = heroe;
	}
	public int getVisita() {
		return visita.getId();
	}
	public void setVisita(Visita visita) {
		this.visita = visita;
	}
	
	public HeroeXVisita(Visita visita, Heroe heroe) {
		super();
		this.heroe = heroe;
		this.visita = visita;
	}
	public HeroeXVisita() {
		super();
	}
	
	
}
