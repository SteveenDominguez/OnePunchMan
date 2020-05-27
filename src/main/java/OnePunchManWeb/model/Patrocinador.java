package OnePunchManWeb.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="patrocinador")
public class Patrocinador {
	@Id
	private int ID;
	private String nombre;
	private int dinero;
	
	public int getId() {
		return ID;
	}
	public void setId(int iD) {
		ID = iD;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getDinero() {
		return dinero;
	}
	public void setDinero(int dinero) {
		this.dinero = dinero;
	}
	public Patrocinador(int iD, String nombre, int dinero) {
		super();
		ID = iD;
		this.nombre = nombre;
		this.dinero = dinero;
	}
	public Patrocinador() {
		super();
	}
	
	
	
}
