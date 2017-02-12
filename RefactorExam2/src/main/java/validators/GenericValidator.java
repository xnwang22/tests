package validators;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;

public class GenericValidator<T extends Object> implements Predicate {

    private final List<Predicate<T>> validators = new LinkedList<>();

    public GenericValidator(List<Predicate<T>> validators) {
        this.validators.addAll(validators);
    }


    @Override
    public boolean test(final Object toValidate) {
        return validators.parallelStream()
                .allMatch(predicate -> predicate.test((T)toValidate));
    }

}

