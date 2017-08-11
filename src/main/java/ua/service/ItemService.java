//package ua.service;
//
//import java.security.Principal;
//import java.util.List;
//
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//
//import ua.dto.filter.ItemFilter;
//import ua.dto.form.ItemForm;
//import ua.entity.Item;
//
//public interface ItemService {
//
//	Item findOne(int id);
//
//	List<Item> findAll();
//
//	void save(ItemForm item);
//
//	void delete(int id);
//
//	ItemForm findForm(int id);
//
//	Page<Item> findAll(ItemFilter filter, Pageable pageable);
//
//	List<Item> findByUserId(Principal principal);
//
//	void addUsers(int id, Principal principal);
//
//	public Page<Item> findAllSearch(Pageable pageable, ItemFilter filter);
//}
