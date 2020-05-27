package OnePunchManWeb.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import OnePunchManWeb.model.CombateXHeroe;
import OnePunchManWeb.model.PatrocinadorXHeroe;

@Repository
public interface CombaXHeroRepository extends JpaRepository<CombateXHeroe, Integer> {
	CombateXHeroe findById(int id);
	@Query(value = "SELECT cxh.* from Combate comba, CombateXHeroe cxh "
			+ "WHERE comba.ID= :idcomba AND comba.ID=cxh.ID_Combate",
			nativeQuery = true)
	List <CombateXHeroe> findAllCXHByCombate(@Param("idcomba") int icomba);
}
