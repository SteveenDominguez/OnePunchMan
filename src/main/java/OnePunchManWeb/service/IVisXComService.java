package OnePunchManWeb.service;

import java.util.List;

import OnePunchManWeb.model.VisitaXComida;

public interface IVisXComService {
	List<VisitaXComida> listarVisXCom();
	VisitaXComida encontrarPorId(int id);
	void guardar(VisitaXComida visxcom);
	void eliminar(int id);
	List<VisitaXComida> listarVXCPorComida(int id_comida);
	List<VisitaXComida> listarVXCPorVisita(int id_visita);
}
