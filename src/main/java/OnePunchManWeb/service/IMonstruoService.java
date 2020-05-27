package OnePunchManWeb.service;

import java.util.List;

import OnePunchManWeb.model.Monstruo;


public interface IMonstruoService {
	List<Monstruo> listarMonstruos();
	Monstruo encontrarPorId(int id);
	void guardar(Monstruo patrocinador);
	void eliminar(int id);
	
}
