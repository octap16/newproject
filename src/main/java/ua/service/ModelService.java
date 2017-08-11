package ua.service;

import java.util.List;





import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.dto.filter.BasicFilter;
import ua.entity.Model;

public interface ModelService {
	
	Model findOne(int id);
	 
	 List<Model> findAll();
	 
	 void save(Model model);
	 
	 void delete(int id);
	 
	 Model findOne(String name);
	 
	 Page<Model> findAll(BasicFilter filter, Pageable pageable);
}
