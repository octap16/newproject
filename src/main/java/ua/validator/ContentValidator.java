//package ua.validator;
//
//import org.springframework.validation.Errors;
//import org.springframework.validation.ValidationUtils;
//import org.springframework.validation.Validator;
//
//import ua.entity.Content;
//import ua.service.ContentService;
//
//public class ContentValidator implements Validator{
//	private final ContentService contentService;
//
//	public ContentValidator(ContentService contentService) {
//		this.contentService = contentService;
//	}
//	@Override
//	public boolean supports(Class<?> clazz) {
//		return clazz.equals(Content.class);
//	}
//	@Override
//	public void validate(Object target, Errors errors) {
//		Content content = (Content) target;
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "",
//				"Can`t be empty");
//		if (contentService.findOne(content.getName()) != null) {
//			errors.rejectValue("name", "", "Already exist");
//		}
//	}
//}
