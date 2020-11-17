package test;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Que1 {

    public static void main(String[] args) {
        //generate list with events
        List<String> list = Stream.of("University", "English", "Holiday", "Work", "Painting")
            .collect(Collectors.toList());
        //generate map with 50 elements and random events for dates
        Map<LocalDate, String> map = Stream.iterate(LocalDate.now(), x -> x.plusDays(1))
            .limit(50)
            .collect(Collectors.toMap(Function.identity(), (x) -> list.get((int) (Math.random() * list.size())),
                (a, b) -> String.join(" ,", a, b), LinkedHashMap<LocalDate, String>::new));
        //filer map with University events and output to System.out
        map.entrySet().stream()
            .filter((Entry<LocalDate, String> e) -> "University".equals(e.getValue()))
            .forEach((Entry<LocalDate, String> e) ->
                System.out.printf("%s %s : %s%n", e.getKey(), e.getKey().getDayOfWeek(), e.getValue()));
    }

}
