//package ua.service.implementation;
//
//import java.math.BigDecimal;
//import java.security.Principal;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import ua.dto.filter.ItemFilter;
//import ua.dto.form.ItemForm;
//import ua.entity.Item;
//import ua.entity.User;
//import ua.repository.ItemRepository;
//import ua.service.FileWriter;
//import ua.service.FileWriter.Folder;
//import ua.service.ItemService;
//import ua.service.UserService;
//import ua.service.specification.ItemSearchSpecification;
//import ua.service.specification.ItemSpecification;
//
//@Service
//public class ItemServiceImpl implements ItemService{
//	
//	@Autowired
//	private ItemRepository repository;
//	
//	@Autowired
//	private UserService userService;
//	
//	@Autowired
//	private FileWriter fileWriter;
//
//	@Override
//	@Transactional (readOnly=true)
//	public Item findOne(int id) {
//		return repository.findOne(id);
//	}
//
//	@Override
//	@Transactional (readOnly=true)
//	public List<Item> findAll() {
//		return repository.findAll();
//	}
//
//	@Override
//	public void delete(int id) {
//		repository.delete(id);
//		
//	}
//	
//	@Override
//	@Transactional (readOnly=true)
//	public ItemForm findForm(int id) {
//		Item item = repository.findOne(id);
//		ItemForm itemForm = new ItemForm();
//		itemForm.setId(item.getId());
//		itemForm.setCategory(item.getCategory());
//		itemForm.setColor(item.getColor());
//		itemForm.setPrice(String.valueOf(item.getPrice()));
//		itemForm.setProducer(item.getProducer());
//		itemForm.setModel(item.getModel());
//		itemForm.setSeason(item.getSeason());
//		itemForm.setContext(item.getContext());
//		itemForm.setSize(String.valueOf(item.getSize()));
//		itemForm.setVersion(item.getVersion());
//		return itemForm;
//	}
//	
//	@Override
//	@Transactional
//	public void save(ItemForm itemForm) {
//		Item item = new Item();
//		item.setId(itemForm.getId());
//		item.setCategory(itemForm.getCategory());
//		item.setColor(itemForm.getColor());
//		item.setPrice(new BigDecimal(itemForm.getPrice().replace(',', '.')));
//		item.setProducer(itemForm.getProducer());
//		item.setModel(itemForm.getModel());
//		item.setSeason(itemForm.getSeason());
//		item.setContext(itemForm.getContext());
//		item.setSize(Integer.valueOf(itemForm.getSize()));
//		item.setVersion(itemForm.getVersion());
//		repository.saveAndFlush(item);
//		if(fileWriter.write(Folder.ITEM, itemForm.getFile(), item.getId())){
//			if(item.getVersion()==null)item.setVersion(0);
//			else item.setVersion(item.getVersion()+1);
//		}
//		repository.save(item);
//		}
//	
//	@Override
//	public Page<Item> findAll(ItemFilter filter, Pageable pageable) {
//		System.out.println("---------------------------------------------------------------");
//		Page<Item> items = repository.findAll(new ItemSpecification(filter),pageable);
//		System.out.println("---------------------------------------------------------------");
//		return items;
//	}
//
//	@Override
//	public List<Item> findByUserId(Principal principal) {
//		return repository.findByUserId(userService.getUserId(principal));
//	}
//
//	@Override
//	@Transactional
//	public void addUsers(int id, Principal principal) {
//	Item item = repository.findOne(id);
//	 String name = principal.getName();
//     User user = userService.findByUsername(name);
//     item.getUsers().add(user);
//	}
//	
//	@Override
//	public Page<Item> findAllSearch(Pageable pageable, ItemFilter filter) {
//		Page<Item> items = repository.findAll(new ItemSearchSpecification(filter), pageable);
//		return items;
//	}
//}
