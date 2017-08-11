package ua.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.entity.Season;
import ua.service.SeasonService;

public class SeasonValidator implements Validator {
	private final SeasonService seasonService;

	public SeasonValidator(SeasonService seasonService) {
		this.seasonService = seasonService;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.equals(Season.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Season season = (Season) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "",
				"Can`t be empty");
		if (seasonService.findOne(season.getName()) != null) {
			errors.rejectValue("name", "", "Already exist");
		}
	}
}
