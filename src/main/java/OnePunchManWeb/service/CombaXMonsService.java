package OnePunchManWeb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import OnePunchManWeb.model.CombateXHeroe;
import OnePunchManWeb.model.CombateXMonstruo;
import OnePunchManWeb.repository.CombaXHeroRepository;
import OnePunchManWeb.repository.CombaXMonsRepository;


@Service
public class CombaXMonsService implements ICombaXMonsService {
	@Autowired
	CombaXMonsRepository cxm;
	
	@Override
	public List<CombateXMonstruo> listarCombateXMonstruos() {
		// TODO Auto-generated method stub
		return cxm.findAll();
	}

	@Override
	public CombateXMonstruo encontrarPorId(int id) {
		// TODO Auto-generated method stub
		return cxm.findById(id);
	}

	@Override
	public void guardar(CombateXMonstruo combaxmons) {
		// TODO Auto-generated method stub
		cxm.save(combaxmons);
	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub
		cxm.deleteById(id);
	}

	@Override
	public List<CombateXMonstruo> listarCXMPorCombate(int idcomba) {
		// TODO Auto-generated method stub
		return cxm.findAllCXMByCombate(idcomba);
	}
}
