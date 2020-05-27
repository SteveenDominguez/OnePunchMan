package OnePunchManWeb.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="monstruo")
public class Monstruo {
	@Id
	private int ID;
	private String nombre;
	private String amenaza;
	private String tiene_celula;
	
	
	public Monstruo(int iD, String nombre, String amenaza, String tiene_celula) {
		super();
		ID = iD;
		this.nombre = nombre;
		this.amenaza = amenaza;
		this.tiene_celula = tiene_celula;
	}
	public String getAmenaza() {
		return amenaza;
	}
	public void setAmenaza(String amenaza) {
		this.amenaza = amenaza;
	}
	public String getTiene_celula() {
		return tiene_celula;
	}
	public void setTiene_celula(String tiene_celula) {
		this.tiene_celula = tiene_celula;
	}
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
	public Monstruo() {
		super();
	}
	
	
	
}
