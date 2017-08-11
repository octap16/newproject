package ua.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ua.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>, JpaSpecificationExecutor<User>{
	List<User> findAll();
	@Query("SELECT DISTINCT c FROM User c  WHERE c.email=:email" )
	User findByUserEmail(String email);
	@Query("SELECT DISTINCT c FROM User c  WHERE c.id=:id" )
	User findOne(@Param("id")long id);
}
