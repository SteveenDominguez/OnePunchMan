package OnePunchManWeb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import OnePunchManWeb.model.Videojuego;
import OnePunchManWeb.repository.VideojuegoRepository;

@Service
public class VideojuegoService implements IVideojuegoService {
	@Autowired
	VideojuegoRepository vid;
	@Override
	public List<Videojuego> listarVideojuegos() {
		// TODO Auto-generated method stub
		return vid.findAll();
	}

	@Override
	public Videojuego encontrarPorId(int id) {
		// TODO Auto-generated method stub
		return vid.findById(id);
	}

	@Override
	public void guardar(Videojuego videojuego) {
		// TODO Auto-generated method stub
		vid.save(videojuego);
	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub
		vid.deleteById(id);
	}

}
