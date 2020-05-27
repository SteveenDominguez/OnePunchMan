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
@Table(name="combatexmonstruo")
public class CombateXMonstruo {
	@Id
	private int ID;
	@JoinColumn(name = "ID_Combate", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private Combate combate;
	@JoinColumn(name = "ID_Monstruo", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private Monstruo monstruo;
	
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
	public String getMonstruo() {
		return monstruo.getNombre();
	}
	public void setMonstruo(Monstruo monstruo) {
		this.monstruo = monstruo;
	}
	public CombateXMonstruo(int id, Combate combate, Monstruo monstruo) {
		super();
		this.combate = combate;
		this.monstruo = monstruo;
	}
	public CombateXMonstruo() {
		super();
	}
	
	
}
