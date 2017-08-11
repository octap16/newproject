//package ua.editor;
//
//import java.beans.PropertyEditorSupport;
//
//import ua.entity.Content;
//import ua.service.ContentService;
//
//public class ContentEditor extends PropertyEditorSupport {
//	private final ContentService contentService;
//
//	public ContentEditor(ContentService contentService) {
//		this.contentService = contentService;
//	}
//	
//	@Override
//	public void setAsText(String text) throws IllegalArgumentException {
//		Content content = contentService.findOne(Integer.valueOf(text));
//		setValue(content);
//	}
//}
