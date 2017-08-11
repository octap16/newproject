package ua.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.dto.filter.BasicFilter;
import ua.entity.Model;
import ua.repository.ModelRepository;
import ua.service.ModelService;
import ua.service.specification.ModelSpecification;

@Service
public class ModelServiceImpl implements ModelService {

	@Autowired
	private  ModelRepository repository;
	
	@Override
	@Transactional (readOnly=true)
	public Model findOne(int id) {
		return repository.findOne(id);
	}

	@Override
	@Transactional (readOnly=true)
	public List<Model> findAll() {
		return repository.findAll();
	}

	@Override
	public void save(Model model) {
		model.setName(model.getName().trim());
		repository.save(model);
		
	}

	@Override
	public void delete(int id) {
		repository.delete(id);
		
	}
	
	@Override
	public Model findOne(String name) {
		return repository.findByName(name);
	}
	
	@Override
	public Page<Model> findAll(BasicFilter filter, Pageable pageable) {
		return repository.findAll(new ModelSpecification(filter), pageable);
	}

}
