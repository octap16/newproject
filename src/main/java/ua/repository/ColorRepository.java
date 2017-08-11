package ua.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


import ua.entity.Color;

public interface ColorRepository extends JpaRepository<Color, Integer>, JpaSpecificationExecutor<Color>{
	Color findByName(String name);
}
