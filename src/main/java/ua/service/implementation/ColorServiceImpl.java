package ua.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.dto.filter.BasicFilter;
import ua.entity.Color;
import ua.repository.ColorRepository;
import ua.service.ColorService;
import ua.service.specification.ColorSpecification;

@Service
public class ColorServiceImpl implements ColorService {

	@Autowired
	private ColorRepository repository;

	@Override
	@Transactional(readOnly = true)
	public Color findOne(int id) {
		return repository.findOne(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Color> findAll() {
		return repository.findAll();
	}

	@Override
	public void save(Color color) {
		color.setName(color.getName().trim());
		repository.save(color);

	}

	@Override
	public void delete(int id) {
		repository.delete(id);

	}

	@Override
	public Color findOne(String name) {
		return repository.findByName(name);
	}

	@Override
	public Page<Color> findAll(BasicFilter filter, Pageable pageable) {
		return repository.findAll(new ColorSpecification(filter), pageable);
	}

}
