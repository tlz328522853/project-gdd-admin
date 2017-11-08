package cn.hacz.edu.valid.validator;

import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import cn.hacz.edu.valid.annotations.IntPattern;


public class IntPatternValidator implements ConstraintValidator<IntPattern, Integer> {

	private String regexp;

	@Override
	public void initialize(IntPattern constraintAnnotation) {
		this.regexp = constraintAnnotation.regexp();
	}

	@Override
	public boolean isValid(Integer value, ConstraintValidatorContext context) {
		if (value == null) {
			return true;
		}
		String string = value.toString();
		return Pattern.compile(this.regexp).matcher(string).matches();
	}

}
