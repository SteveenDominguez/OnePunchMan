package OnePunchManWeb.service;

import java.util.List;

import OnePunchManWeb.model.PatrocinadorXHeroe;
import OnePunchManWeb.model.PatrocinadorXMonstruo;

public interface IPatroXMonsService {
	List<PatrocinadorXMonstruo> listarPatroXMons();
	PatrocinadorXMonstruo encontrarPorId(int id);
	void guardar(PatrocinadorXMonstruo patroxmons);
	void eliminar(int id);
	List<PatrocinadorXMonstruo> listarPXMPorPatrocinador(int idpatro);
}
