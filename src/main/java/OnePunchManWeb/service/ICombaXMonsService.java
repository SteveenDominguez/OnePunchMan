package OnePunchManWeb.service;

import java.util.List;

import OnePunchManWeb.model.CombateXHeroe;
import OnePunchManWeb.model.CombateXMonstruo;


public interface ICombaXMonsService {
	List<CombateXMonstruo> listarCombateXMonstruos();
	CombateXMonstruo encontrarPorId(int id);
	void guardar(CombateXMonstruo combaxmons);
	void eliminar(int id);
	List<CombateXMonstruo> listarCXMPorCombate(int idcomba);
}
