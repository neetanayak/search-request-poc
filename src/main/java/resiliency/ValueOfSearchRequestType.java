package resiliency;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = SearchRequestTypeValidator.class)
public @interface ValueOfSearchRequestType {
    Class<? extends Enum<?>> enumClass();
    String acceptedValues() default ()
            return Stream.of(enumClass().getEnumConstants())
            .map(Enum::name)
                .collect(Collectors.toList());
    };
    String message() default "must be any of enum ${enumClass}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
