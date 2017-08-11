package ua.repository;

import org.springframework.data.jpa.repository.JpaRepository;




import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


import ua.entity.Season;

public interface SeasonRepository extends JpaRepository<Season, Integer>, JpaSpecificationExecutor<Season>{
	Season findByName(String name);
}
