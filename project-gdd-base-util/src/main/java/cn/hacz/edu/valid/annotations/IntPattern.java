package cn.hacz.edu.valid.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import cn.hacz.edu.valid.validator.IntPatternValidator;


@Target(value = { ElementType.FIELD })
@Retention(value = RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { IntPatternValidator.class })
@Documented
public @interface IntPattern {

	public String message() default "类型不正确";

	public String regexp() default "^-?[1-9]\\d*$";

	public Class<?>[] groups() default {};

	public Class<? extends Payload>[] payload() default {};
}