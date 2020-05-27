package OnePunchManWeb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import OnePunchManWeb.model.PatrocinadorXHeroe;
import OnePunchManWeb.model.PatrocinadorXMonstruo;
import OnePunchManWeb.repository.PatroXHeroRepository;
import OnePunchManWeb.repository.PatroXMonsRepository;
import OnePunchManWeb.repository.PatrocinadorRepository;

@Service
public class PatroXMonsService implements IPatroXMonsService {
	@Autowired
	PatroXMonsRepository pxm;
	
	@Override
	public List<PatrocinadorXMonstruo> listarPatroXMons() {
		// TODO Auto-generated method stub
		return pxm.findAll();
	}

	@Override
	public PatrocinadorXMonstruo encontrarPorId(int id) {
		// TODO Auto-generated method stub
		return pxm.findById(id);
	}

	@Override
	public void guardar(PatrocinadorXMonstruo patroxmons) {
		// TODO Auto-generated method stub
		pxm.save(patroxmons);
	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub
		pxm.deleteById(id);
	}

	@Override
	public List<PatrocinadorXMonstruo> listarPXMPorPatrocinador(int idpatro) {
		// TODO Auto-generated method stub
		return pxm.findAllPXHByPatro(idpatro);
	}
}
