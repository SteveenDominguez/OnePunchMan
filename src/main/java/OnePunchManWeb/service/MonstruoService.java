package OnePunchManWeb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import OnePunchManWeb.model.Monstruo;
import OnePunchManWeb.model.Patrocinador;
import OnePunchManWeb.repository.MonstruoRepository;
import OnePunchManWeb.repository.PatrocinadorRepository;

@Service
public class MonstruoService implements IMonstruoService {
	@Autowired
	MonstruoRepository mons;
	@Override
	public List<Monstruo> listarMonstruos() {
		// TODO Auto-generated method stub
		return mons.findAll();
	}

	@Override
	public Monstruo encontrarPorId(int id) {
		// TODO Auto-generated method stub
		return mons.findById(id);
	}

	@Override
	public void guardar(Monstruo monstruo) {
		// TODO Auto-generated method stub
		mons.save(monstruo);
	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub
		mons.deleteById(id);
	}

}
