package ua.service.specification;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import ua.dto.filter.ItemFilter;
import ua.entity.Item;

public class ItemSpecification implements Specification<Item> {

	private final ItemFilter filter;

	private final List<Predicate> predicates = new ArrayList<>();

	public ItemSpecification(ItemFilter filter) {
		this.filter = filter;
	}

//	 private void filterBySearch(Root<Item> root, CriteriaQuery<?> query,
//	 CriteriaBuilder cb){
//	 if(!filter.getSearch().isEmpty()){
//	 predicates.add(cb.like( root.get("name"), filter.getSearch()+"%"));
//	 }
//	 }

	private void filterByPrice(Root<Item> root, CriteriaQuery<?> query,
			CriteriaBuilder cb) {
		if (filter.getMax() != null && filter.getMin() != null) {
			predicates.add(cb.between(root.get("price"), filter.getMin(),
					filter.getMax()));
		} else if (filter.getMax() != null) {
			predicates.add(cb.lessThanOrEqualTo(root.get("price"),
					filter.getMax()));
		} else if (filter.getMin() != null) {
			predicates.add(cb.greaterThanOrEqualTo(root.get("price"),
					filter.getMin()));
		}
	}

	private void filterBySize(Root<Item> root, CriteriaQuery<?> query,
			CriteriaBuilder cb) {
		if (filter.getMax() != null && filter.getMin() != null) {
			predicates.add(cb.between(root.get("size"), filter.getMin(),
					filter.getMax()));
		} else if (filter.getMax() != null) {
			predicates.add(cb.lessThanOrEqualTo(root.get("size"),
					filter.getMax()));
		} else if (filter.getMin() != null) {
			predicates.add(cb.greaterThanOrEqualTo(root.get("size"),
					filter.getMin()));
		}
	}

	private void filterByProducer(Root<Item> root, CriteriaQuery<?> query,
			CriteriaBuilder cb) {
		if (!filter.getProducerIds().isEmpty()) {
			predicates.add(root.get("producer").in(filter.getProducerIds()));
		}
	}

	private void filterByColor(Root<Item> root, CriteriaQuery<?> query,
			CriteriaBuilder cb) {
		if (!filter.getColorIds().isEmpty()) {
			predicates.add(root.get("color").in(filter.getColorIds()));
		}
	}

	private void filterBySeason(Root<Item> root, CriteriaQuery<?> query,
			CriteriaBuilder cb) {
		if (!filter.getSeasonIds().isEmpty()) {
			predicates.add(root.get("season").in(filter.getSeasonIds()));
		}
	}

	private void filterByModel(Root<Item> root, CriteriaQuery<?> query,
			CriteriaBuilder cb) {
		if (!filter.getModelIds().isEmpty()) {
			predicates.add(root.get("model").in(filter.getModelIds()));
		}
	}

	private void filterByCategory(Root<Item> root, CriteriaQuery<?> query,
			CriteriaBuilder cb) {
		if (!filter.getCategoryIds().isEmpty()) {
			predicates.add(root.get("category").in(filter.getCategoryIds()));
		}
	}
	
	

	private void fetch(Root<Item> root, CriteriaQuery<?> query) {
		if (query.getResultType() != Long.class) {
			root.fetch("category", JoinType.LEFT);
			root.fetch("producer", JoinType.LEFT);
			root.fetch("model", JoinType.LEFT);
			root.fetch("color", JoinType.LEFT);
			root.fetch("season", JoinType.LEFT);
		}
	}

	@Override
	public Predicate toPredicate(Root<Item> root, CriteriaQuery<?> query,
			CriteriaBuilder cb) {
		fetch(root, query);
		query.distinct(true);
//		filterBySearch(root, query, cb);
		filterBySize(root, query, cb);
		filterByPrice(root, query, cb);
		filterByProducer(root, query, cb);
		filterByColor(root, query, cb);
		filterBySeason(root, query, cb);
		filterByModel(root, query, cb);
		filterByCategory(root, query, cb);
		if (predicates.isEmpty())
			return null;
		Predicate[] array = new Predicate[predicates.size()];
		predicates.toArray(array);
		return cb.and(array);
	}

}