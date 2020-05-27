package OnePunchManWeb.service;

import java.util.List;

import OnePunchManWeb.model.CombateXHeroe;


public interface ICombaXHeroService {
	List<CombateXHeroe> listarCombateXHeroes();
	CombateXHeroe encontrarPorId(int id);
	void guardar(CombateXHeroe patroxhero);
	void eliminar(int id);
	List<CombateXHeroe> listarCXHPorCombate(int idcomba);
}
