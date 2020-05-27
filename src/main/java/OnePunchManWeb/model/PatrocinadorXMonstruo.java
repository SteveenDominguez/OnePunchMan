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
@Table(name="patrocinadorxmonstruo")
public class PatrocinadorXMonstruo {
	@Id
	private int ID;
	@JoinColumn(name = "ID_Patrocinador", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private Patrocinador patrocinador;
	@JoinColumn(name = "ID_Monstruo", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private Monstruo monstruo;
	
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
	public int getMonstruo() {
		return monstruo.getId();
	}
	public void setHeroe(Monstruo monstruo) {
		this.monstruo = monstruo;
	}
	public PatrocinadorXMonstruo(int id, Patrocinador patrocinador, Monstruo monstruo) {
		super();
		this.patrocinador = patrocinador;
		this.monstruo = monstruo;
	}
	public PatrocinadorXMonstruo() {
		super();
	}
	
	
}
