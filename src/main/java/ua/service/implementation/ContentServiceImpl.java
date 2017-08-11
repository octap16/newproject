//package ua.service.implementation;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//
//import ua.entity.Content;
//import ua.repository.ContentRepository;
//import ua.service.ContentService;
//
//
//@Service
//public class ContentServiceImpl implements ContentService{
//
//	@Autowired
//	private ContentRepository repository;
//	@Override
//	@Transactional (readOnly=true)
//	public Content findOne(int id) {
//		return repository.findOne(id);
//	}
//
//	@Override
//	@Transactional (readOnly=true)
//	public List<Content> findAll() {
//		return repository.findAll();
//	}
//
//	@Override
//	public void save(Content content) {
//		content.setName(content.getName().trim());
//		repository.save(content);
//		
//	}
//
//	@Override
//	public void delete(int id) {
//		repository.delete(id);
//		
//	}
//	
//	@Override
//	public Content findOne(String content) {
//		return repository.findByName(content);
//	}
//
//	@Override
//	public Page<Content> findAll( Pageable pageable) {
//		return repository.findAll( pageable);
//	}
//}