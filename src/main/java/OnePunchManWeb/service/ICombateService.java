package OnePunchManWeb.service;

import java.util.List;

import OnePunchManWeb.model.Combate;
import OnePunchManWeb.model.Patrocinador;



public interface ICombateService {
	List<Combate> listarCombates();
	Combate encontrarPorId(int id);
	void guardar(Combate combate);
	void eliminar(int id);
	List<Combate> listarCombatesPorHeroe(int id_heroe);
	List<Combate> listarCombatesPorMonstruo(int id_monstruo);
}
