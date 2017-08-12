package ua.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.entity.User;
import ua.service.UserService;



public class UserValidator implements Validator{
	private final UserService userService;
	
	public UserValidator(UserService userService) {
		this.userService = userService;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		
		return clazz.equals(User.class);
	}

	
	@Override
	public void validate(Object target, Errors errors) {
		User user = (User) target;
		if (userService.findByUserEmail(user.getEmail()) != null) {
			errors.rejectValue("username", "", "Такий email вже існує");
		}	
	}	
}
