package OnePunchManWeb.service;

import java.util.List;

import OnePunchManWeb.model.Patrocinador;

public interface IPatrocinadorService {
	List<Patrocinador> listarPatrocinadores();
	Patrocinador encontrarPorId(int id);
	void guardar(Patrocinador patrocinador);
	void eliminar(int id);
	List<Patrocinador> listarPatrocinadoresPorHeroe(int id_heroe);
	List<Patrocinador> listarPatrocinadoresPorMonstruo(int id_monstruo);
}
