package validators;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by robinwang on 9/25/16.
 */
public class QueryValidator extends GenericValidator<List<String>> {
    private static final List<Predicate<List<String>>> VALIDATORS = new LinkedList<>();

    static {
        VALIDATORS.add(list->list != null);
        VALIDATORS.add(list->!list.isEmpty());
        VALIDATORS.add(list->list.get(0).matches("\\d"));

        // ...and many more
    }

    public QueryValidator(List<Predicate<List<String>>> validators) {
        super(validators);
    }
}
