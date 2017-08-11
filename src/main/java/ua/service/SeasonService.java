package ua.service;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.dto.filter.BasicFilter;
import ua.entity.Season;

public interface SeasonService {
	
	Season findOne(int id);
	 
	 List<Season> findAll();
	 
	 void save(Season season);
	 
	 void delete(int id);
	 
	 Season findOne(String name);
	 
	 Page<Season> findAll(BasicFilter filter, Pageable pageable);
}
