package ua.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ua.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Integer>, JpaSpecificationExecutor<Item>{

	
	@Query("SELECT DISTINCT c FROM Item c LEFT JOIN FETCH c.category  LEFT JOIN FETCH c.color LEFT JOIN FETCH c.season LEFT JOIN FETCH c.model LEFT JOIN FETCH c.producer  " )
	List<Item> findAll();
	@Query("SELECT DISTINCT c FROM Item c LEFT JOIN FETCH c.category LEFT JOIN FETCH c.producer LEFT JOIN FETCH c.color LEFT JOIN FETCH c.season LEFT JOIN FETCH c.model WHERE c.id=:id" )
	Item findOne(@Param("id")int id);
	@Query(value="SELECT DISTINCT i FROM Item i LEFT JOIN FETCH i.category LEFT JOIN FETCH i.producer LEFT JOIN FETCH i.color LEFT JOIN FETCH i.season LEFT JOIN FETCH i.model  ",
			countQuery="SELECT count(i.id) FROM Item i")
	Page<Item> findAll(Pageable pageable);
//	@Query("SELECT DISTINCT c FROM Item c LEFT JOIN FETCH c.users  WHERE c.id=:id " )
//	List<Item> findByUserId(@Param("id")int id);
}
