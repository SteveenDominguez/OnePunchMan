package OnePunchManWeb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import OnePunchManWeb.model.Visita;

@Repository
public interface VisitaRepository extends JpaRepository<Visita, Integer> {
	Visita findById(int id);
	
	@Query("select vis from Comida com, Visita vis, VisitaXComida vxc where com.ID=vxc.comida and vis.ID=vxc.visita")
    List<Visita> findAllFoodInVisit();
	
	@Query("select vis from Heroe hero, Visita vis, HeroeXVisita hxv where hero.ID=hxv.heroe and vis.ID=hxv.visita")
    List<Visita> findAllHeroInVisit();
}
