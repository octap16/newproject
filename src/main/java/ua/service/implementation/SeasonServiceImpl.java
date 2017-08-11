package ua.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.dto.filter.BasicFilter;
import ua.entity.Season;
import ua.repository.SeasonRepository;
import ua.service.SeasonService;
import ua.service.specification.SeasonSpecification;

@Service
public class SeasonServiceImpl implements SeasonService{

	@Autowired
	private  SeasonRepository repository;
	
	@Override
	@Transactional (readOnly=true)
	public Season findOne(int id) {
		return repository.findOne(id);
	}

	@Override
	@Transactional (readOnly=true)
	public List<Season> findAll() {
		return repository.findAll();
	}

	@Override
	public void save(Season season) {
		season.setName(season.getName().trim());
		repository.save(season);
		
	}

	@Override
	public void delete(int id) {
		repository.delete(id);
		
	}
	
	@Override
	public Season findOne(String name) {
		return repository.findByName(name);
	}
	
	@Override
	public Page<Season> findAll(BasicFilter filter, Pageable pageable) {
		return repository.findAll(new SeasonSpecification(filter), pageable);
	}

}
