package resiliency;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;

public class SearchRequestTypeSubsetValidator implements ConstraintValidator<SearchRequestTypeSubset, SearchRequestType> {
    private SearchRequestType[] subset;

    @Override
    public void initialize(SearchRequestTypeSubset constraint) {
        this.subset = constraint.anyOf();
    }

    @Override
    public boolean isValid(SearchRequestType value, ConstraintValidatorContext context) {
        return value == null || Arrays.asList(subset).contains(value);
    }
}