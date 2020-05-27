package OnePunchManWeb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import OnePunchManWeb.model.HeroeXVisita;

public interface HerXVisRepository extends JpaRepository<HeroeXVisita, Integer> {
	HeroeXVisita findById(int id);
	@Query(value = "SELECT hxv.* from  Heroe hero, HeroeXVisita hxv "
			+ "WHERE hero.ID= :idheroe AND hero.ID=hxv.ID_Heroe",
			nativeQuery = true)
	List <HeroeXVisita> findAllHXVByHeroe(@Param("idheroe") int idheroe);
	
	@Query(value = "SELECT hxv.* from  Visita vis, HeroeXVisita hxv "
			+ "WHERE vis.ID= :idvisita AND vis.ID=hxv.ID_Visita",
			nativeQuery = true)
	List <HeroeXVisita> findAllHXVByVisita(@Param("idvisita") int idvisita);
}
