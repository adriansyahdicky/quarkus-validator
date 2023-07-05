package org.acme.validation;

import jakarta.inject.Inject;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.acme.entity.TObject;
import org.acme.repository.TObjectRepository;


public class DatabaseValidator implements ConstraintValidator<DatabaseValidation, Object> {

    @Inject
    TObjectRepository tObjectRepository;
    private String key;

    @Override
    public void initialize(DatabaseValidation constraintAnnotation) {
        this.key = constraintAnnotation.key();
    }

    @Override
    public boolean isValid(Object s, ConstraintValidatorContext context) {
        System.out.println("OBJECT NAME = " + key);
        TObject tObject = tObjectRepository.findByNameKey(key);
        return tObject != null;
    }
}
