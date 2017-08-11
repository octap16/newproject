package ua.service;

import java.util.List;





import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.dto.filter.BasicFilter;
import ua.entity.Color;

public interface ColorService {

	Color findOne(int id);
	 
	 List<Color> findAll();
	 
	 void save(Color color);
	 
	 void delete(int id);
	 
	 Color findOne(String name);
	 
	 Page<Color> findAll(BasicFilter filter, Pageable pageable);
}
