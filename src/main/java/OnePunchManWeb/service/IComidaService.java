package OnePunchManWeb.service;

import java.util.List;

import OnePunchManWeb.model.Comida;

public interface IComidaService {
	List<Comida> listarComidas();
	Comida encontrarPorId(int id);
	void guardar(Comida comida);
	void eliminar(int id);
	List<Comida> listarComidasPorVisita();
}
