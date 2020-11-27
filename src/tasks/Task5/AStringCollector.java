package tasks.Task5;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class AStringCollector implements Collector<A, Map<String, List<A>>, Map<String, List<String>>> {

    private static final String RICH_USERS_KEY = "Rich users";
    private static final String WELLREAD_USERS_KEY = "Well-read users";
    private static final String STUDENT_USERS_KEY = "Student users";

    @Override
    public Supplier<Map<String, List<A>>> supplier() {

        return () -> {
            Map<String, List<A>> map = new HashMap<>();
            map.put(WELLREAD_USERS_KEY, new ArrayList<>());
            map.put(RICH_USERS_KEY, new ArrayList<>());
            map.put(STUDENT_USERS_KEY, new ArrayList<>());
            return map;
        };
    }

    @Override
    public BiConsumer<Map<String, List<A>>, A> accumulator() {
        return (e, a) -> {
            if (a.getTitlesOfReadBooks().size() > 2 || a.getBudget() > 100) {
                if (a.getTitlesOfReadBooks().size() > 2) {
                    e.get(WELLREAD_USERS_KEY).add(a);
                }
                if (a.getBudget() > 100) {
                    e.get(RICH_USERS_KEY).add(a);
                }
            } else {
                e.get(STUDENT_USERS_KEY).add(a);
            }
        };
    }

    @Override
    public BinaryOperator<Map<String, List<A>>> combiner() {
        return (a, b) -> {
            a.get(WELLREAD_USERS_KEY).addAll(b.get(WELLREAD_USERS_KEY));
            a.get(RICH_USERS_KEY).addAll(b.get(RICH_USERS_KEY));
            a.get(STUDENT_USERS_KEY).addAll(b.get(STUDENT_USERS_KEY));
            return a;
        };
    }

    @Override
    public Function<Map<String, List<A>>, Map<String, List<String>>> finisher() {
        return (Map<String, List<A>> s) -> s.entrySet().stream()
                .map(x -> {
                    List<String> values = x.getValue().stream().map(y -> {
                        switch (x.getKey()) {
                            case WELLREAD_USERS_KEY:
                                return y.userReadTitlesStatistics();
                            case RICH_USERS_KEY:
                                return y.userBudgetStatistics();
                            default:
                                return y.toString();
                        }
                    }).collect(Collectors.toList());
                    return new SimpleEntry<>(x.getKey(), values);
                }).collect(Collectors.toMap(SimpleEntry::getKey, SimpleEntry::getValue));
}

    @Override
    public Set<Characteristics> characteristics() {
        return EnumSet.of(Characteristics.CONCURRENT, Characteristics.UNORDERED);
    }
}
