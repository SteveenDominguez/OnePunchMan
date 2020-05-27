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
@Table(name="combatexheroe")
public class CombateXHeroe {
	@Id
	private int ID;
	@JoinColumn(name = "ID_Combate", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private Combate combate;
	@JoinColumn(name = "ID_Heroe", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private Heroe heroe;
	
	public int getId() {
		return ID;
	}
	public void setId(int iD) {
		ID = iD;
	}
	public int getCombate() {
		return combate.getId();
	}
	public void setCombate(Combate combate) {
		this.combate = combate;
	}
	public String getHeroe() {
		return heroe.getNombre();
	}
	public void setHeroe(Heroe heroe) {
		this.heroe = heroe;
	}
	public CombateXHeroe(int id, Combate combate, Heroe heroe) {
		super();
		this.combate = combate;
		this.heroe = heroe;
	}
	public CombateXHeroe() {
		super();
	}
	
	
}
