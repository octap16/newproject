//package ua.service.specification;
//
//import javax.persistence.criteria.CriteriaBuilder;
//import javax.persistence.criteria.CriteriaQuery;
//import javax.persistence.criteria.Predicate;
//import javax.persistence.criteria.Root;
//
//import org.springframework.data.jpa.domain.Specification;
//
//import ua.dto.filter.BasicFilter;
//import ua.entity.Content;
//
//public class ContentSpesification implements Specification<Content>{
//	
//	private final BasicFilter filter;
//	
//	public ContentSpecification(BasicFilter filter) {
//		this.filter = filter;
//	}
//	
//		@Override
//	public Predicate toPredicate(Root<Content> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
//		if(filter.getSearch().isEmpty()) return null;
//		return cb.like(root.get("name"), filter.getSearch()+"%");
//	}
//}
