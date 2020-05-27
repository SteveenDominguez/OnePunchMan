package OnePunchManWeb.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import OnePunchManWeb.model.CombateXHeroe;
import OnePunchManWeb.model.CombateXMonstruo;
import OnePunchManWeb.model.PatrocinadorXHeroe;

@Repository
public interface CombaXMonsRepository extends JpaRepository<CombateXMonstruo, Integer> {
	CombateXMonstruo findById(int id);
	@Query(value = "SELECT cxm.* from Combate comba, CombateXMonstruo cxm "
			+ "WHERE comba.ID= :idcomba AND comba.ID=cxm.ID_Combate",
			nativeQuery = true)
	List <CombateXMonstruo> findAllCXMByCombate(@Param("idcomba") int icomba);
}
