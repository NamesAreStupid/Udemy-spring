package com.luv2code.springdemo.mvc;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String>{
	
	private String[] coursePrefixes;

	@Override
	public void initialize(CourseCode courseCode) {
		this.coursePrefixes = courseCode.value();
		
	}
	
	@Override
	public boolean isValid(String code, ConstraintValidatorContext constraintValidatorContext) {
		if(code != null) {
			for( String prefix : coursePrefixes) {
				if(code.startsWith(prefix))
					return true;
			}
		}
		return false;
	}

}
