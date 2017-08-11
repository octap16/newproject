package ua.service.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import ua.dto.filter.BasicFilter;
import ua.entity.Model;



public class ModelSpecification implements Specification<Model>{
	
	private final BasicFilter filter;
	
	public ModelSpecification(BasicFilter filter) {
		this.filter = filter;
	}
	
	@Override
	public Predicate toPredicate(Root<Model> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
//		if(!query.getResultType().equals(Long.class)){
//			root.fetch("content");
//		}
			if(filter.getSearch().isEmpty()) return null;
		return cb.like(root.get("name"), filter.getSearch()+"%");
	}

	
}