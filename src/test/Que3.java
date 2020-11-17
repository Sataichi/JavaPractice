package test;

import java.time.Period;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Que3 {

    public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
        //generate user list
        List<User> users = Stream.of(
            new User("Arthas", "Menetil", Period.of(24, 1, 6)),
            new User("Sylvanas", "Windrunner", Period.of(2700, 4, 5)),
            new User("Illidan", "Stormrage", Period.of(15032, 5, 3)),
            new User("Jaina", "Proudmoore", Period.of(36, 11, 5)))
            .collect(Collectors.toList());

        //way 1
        List<Map<String, String>> json = users.stream()
            .map(x -> {
                return Arrays.stream(x.getClass().getDeclaredFields())
                    .collect(Collectors.toMap(y -> y.getName(),
                        y -> {
                            y.setAccessible(true);
                            try {
                                return y.get(x).toString();
                            } catch (IllegalArgumentException | IllegalAccessException e) {
                                e.printStackTrace();
                                return null;
                            }
                        }));
            })
            .collect(Collectors.toList());

        //way2
        List<Map<String, String>> json2 = users.stream()
            .map(x -> Stream.of(new AbstractMap.SimpleEntry<String, String>("lastName", x.getLastName()),
                new AbstractMap.SimpleEntry<String, String>("firstName", x.getFirstName()),
                new AbstractMap.SimpleEntry<String, String>("period", x.getPeriod().toString()))
                .collect(Collectors.toMap(Entry::getKey, Entry::getValue)))
            .collect(Collectors.toList());
        //List<Map<String, String>> object (way1) output to System.out
        json.forEach(x -> {
            x.forEach((y, z) -> System.out.printf("%s : %s%n", y, z));
            System.out.println();
        });

        /*
         * output for way2
         *
         * json2.forEach(x->{
         * x.forEach((y,z)->System.out.println(String.format("%s : %s", y,z)));
         * System.out.println(); });
         */
    }

}
