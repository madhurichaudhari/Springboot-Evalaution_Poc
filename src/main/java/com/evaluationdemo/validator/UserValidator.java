package com.evaluationdemo.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.evaluationtestdemo.iServices.IUserRegisterationService;
import com.evaluationtestdemo.requestmodels.UserRequestModel;

/**
 * @author MadhuriC
 *
 */
@Component
public class UserValidator implements Validator {
	@Autowired
	private IUserRegisterationService userRegisterService;

	@Override
	
	public boolean supports(Class<?> aClass) {
		return UserRequestModel.class.equals(aClass);
	}

	@Override
	public void validate(Object o, Errors errors) {
		UserRequestModel user = (UserRequestModel) o;

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");
		if (user.getUserName().length() < 6 || user.getUserName().length() > 32) {
			errors.rejectValue("username", "Size.userForm.username");
		}
		if (userRegisterService.findByUsername(user.getUserName()) != null) {
			errors.rejectValue("username", "Duplicate.userForm.username");
		}

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
		if (user.getPassword().length() < 8 || user.getPassword().length() > 32) {
			errors.rejectValue("password", "Size.userForm.password");
		}

		if (!user.getConfirmPassword().equals(user.getPassword())) {
			errors.rejectValue("passwordConfirm", "Diff.userForm.passwordConfirm");
		}
	}
}
