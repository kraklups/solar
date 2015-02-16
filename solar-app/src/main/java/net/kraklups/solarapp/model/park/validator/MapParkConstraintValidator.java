package net.kraklups.solarapp.model.park.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MapParkConstraintValidator implements ConstraintValidator<MapPark, String> {

	@Override
	public void initialize(MapPark mapPark) {
		// TODO Auto-generated method stub		
	}

	@Override
	public boolean isValid(String mapParkField, ConstraintValidatorContext ctx) {
		// TODO Auto-generated method stub
		return true;
	}

}
