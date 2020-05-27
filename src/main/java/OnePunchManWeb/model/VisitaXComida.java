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
@Table(name="visitaxcomida")
public class VisitaXComida {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int ID;
	@JoinColumn(name = "ID_Visita", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private Visita visita;
	@JoinColumn(name = "ID_Comida", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private Comida comida;
	
	public int getId() {
		return ID;
	}
	public void setId(int iD) {
		ID = iD;
	}
	public int getVisita() {
		return visita.getId();
	}
	public void setVisita(Visita visita) {
		this.visita = visita;
	}
	public int getComida() {
		return comida.getId();
	}
	public void setComida(Comida comida) {
		this.comida = comida;
	}
	public VisitaXComida(Visita visita, Comida comida) {
		super();
		this.visita = visita;
		this.comida = comida;
	}
	public VisitaXComida() {
		super();
	}
	
	
}
