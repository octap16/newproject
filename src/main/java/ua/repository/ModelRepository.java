package ua.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;


import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


import ua.entity.Model;


public interface ModelRepository extends JpaRepository<Model, Integer>, JpaSpecificationExecutor<Model>{
	
//	@Query("SELECT p FROM Model p LEFT JOIN FETCH p.content" )
	List<Model> findAll();
//	@Query("SELECT p FROM Model p LEFT JOIN FETCH p.content WHERE p.id=:id")
//	Model findOne(@Param("id")int id);
	Model findByName(String name);
//	@Query(value="SELECT p FROM Model p LEFT JOIN FETCH p.content", countQuery="SELECT count(p.id) FROM Model p" )
//	Page<Model> findAll(Pageable pageable);
	
	
}
