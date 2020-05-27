package OnePunchManWeb.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import OnePunchManWeb.model.VisitaXComida;

@Repository
public interface VisXComRepository extends JpaRepository<VisitaXComida, Integer> {
	VisitaXComida findById(int id);
	
	@Query(value = "SELECT vxc.* from Comida com, VisitaXComida vxc "
			+ "WHERE com.ID= :idcomida AND com.ID=vxc.ID_Comida",
			nativeQuery = true)
	List <VisitaXComida> findAllVXCByComida(@Param("idcomida") int idcomida);
	
	@Query(value = "SELECT vxc.* from Visita vis, VisitaXComida vxc "
			+ "WHERE vis.ID= :idvisita AND vis.ID=vxc.ID_Visita",
			nativeQuery = true)
	List <VisitaXComida> findAllVXCByVisita(@Param("idvisita") int idvisita);
}
