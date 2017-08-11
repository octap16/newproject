package ua.validator;

import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.dto.form.ItemForm;



public class ItemValidator implements Validator {
	private final static Pattern PATTERN = Pattern
			.compile("^([0-9]{1,18}\\.[0-9]{0,2})|([0-9]{1,18}\\,[0-9]{0,2})$");
	private final static Pattern PATTERNSIZE = Pattern
			.compile("^([0-9]{1,2})$");

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.equals(ItemForm.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ItemForm itemForm = (ItemForm) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "size", "",
				"Can`t be empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "context", "",
				"Can`t be empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "price", "",
				"Can`t be empty");
		if (!PATTERN.matcher(itemForm.getPrice()).matches()) {
			errors.rejectValue("price", "",
					"Wrong format, only 2 digits after separator");
		}
		if (!PATTERNSIZE.matcher(itemForm.getSize()).matches()) {
			errors.rejectValue("size", "",
					"Wrong format, only 2 digits ");
		}
	}

}
