package OnePunchManWeb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import OnePunchManWeb.model.Comida;
@Repository
public interface ComidaRepository extends JpaRepository<Comida, Integer> {
	Comida findById(int id);
	List<Comida> findByNombre(String nombre);
	
	@Query("select com from Comida com, Visita vis, VisitaXComida vxc where com.ID=vxc.comida and vis.ID=vxc.visita")
    List<Comida> findAllFoodInVisit();
	
	}
