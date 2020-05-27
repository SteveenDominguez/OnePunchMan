package OnePunchManWeb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import OnePunchManWeb.model.HeroeXVideojuego;
import OnePunchManWeb.repository.HerXVidRepository;

@Service
public class HerXVidService implements IHerXVidService {
	@Autowired
	HerXVidRepository hxv;
	@Override
	public List<HeroeXVideojuego> listarPartidas() {
		// TODO Auto-generated method stub
		return hxv.findAll();
	}

	@Override
	public HeroeXVideojuego encontrarPorId(int id) {
		// TODO Auto-generated method stub
		return hxv.findById(id);
	}

	@Override
	public void guardar(HeroeXVideojuego herxpar) {
		// TODO Auto-generated method stub
		hxv.save(herxpar);
	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub
		hxv.deleteById(id);
	}

	@Override
	public List<HeroeXVideojuego> listarHXVPorVideojuego(int id_videojuego) {
		// TODO Auto-generated method stub
		return hxv.findAllHXVByVideojuego(id_videojuego);
	}

}
