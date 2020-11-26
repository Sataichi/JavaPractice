package tasks.task2;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task2 {
    public static void main(String[] args) {

        //1)
        System.out.println("\r\n1)\r\n");
        //Function impl
        Function<String, Integer> stringLength = s -> s.length();
        System.out.println("Function strLength of \"MyString\" : " + stringLength.apply("MyString"));
        //Supplier impl
        Supplier<Double> randomDouble = () -> Math.random();
        System.out.println("Supplier random : " + randomDouble.get());
        //Consumer impl
        Consumer<String> outer = s -> System.out.println("Outer output : " + s);
        outer.accept("Outer Test output");
        System.out.println();
        //Predicate impl
        Predicate<String> isStartedWithA = s -> s.startsWith("A");
        List<String> strings =
            Stream.of("After", "Trust", "Amber", "Around", "Activate", "Implement").collect(Collectors.toList());
        strings.stream()
            .filter(isStartedWithA)
            .forEach(outer);
        System.out.println();
        //UnaryOperator impl
        UnaryOperator<String> toUpperCase = s -> s.toUpperCase();
        strings.stream()
            .map(toUpperCase::apply)
            .forEach(outer);
        System.out.println();
        //BinaryOperator impl
        outer.accept(strings.stream()
            .reduce((s1, s2) -> String.join(", ", s1, s2)).orElseGet(String::new));

        //2)
        System.out.println("\r\n2)\r\n");
        //My functional interface impl by lambda
        List<Double> doubleList = Stream.of(0.434343, 0.2232314, 0.73324, 0.876543).collect(Collectors.toList());
        StringTransformer<List<Double>> doubleToStringTransformer = (list) -> list.stream()
            .map(Object::toString)
            .reduce((s1, s2) -> String.join(" ,", s1, s2))
            .get();
        outer.accept(doubleToStringTransformer.transform(doubleList));
        System.out.println();
        //My functional interface impl by anonymous class
        DoubleObj doubleObject = new DoubleObj(283849294232423L, 0.542345);
        StringTransformer<DoubleObj> doubleObjectToJsonTransformer = new StringTransformer<DoubleObj>() {

            @Override
            public String transform(DoubleObj object) {
                return String.format("doubleObject transformed string :\r\n{\r\n\tid : %s,\r\n\tvalue : %s\r\n}",
                    object.getId().toString(),
                    object.getValue().toString());
            }
        };
        outer.accept(String.format("\r\n%s", doubleObjectToJsonTransformer.transform(doubleObject)));
        System.out.println();
        //3
        System.out.println("\r\n3)\r\n");
        outer.accept(String.format("Length of doubleObject transformed string is %d\r\n",
            doubleObjectToJsonTransformer.getStringLength(doubleObject)));
        outer.accept(String.format("Length of doubleList transformed string is %d\r\n",
            doubleToStringTransformer.getStringLength(doubleList)));
        outer.accept(String.format("Is doubleObject string is empty? - %b\r\n",
            doubleObjectToJsonTransformer.isStringEmpty(doubleObject)));
        outer.accept(String.format("Is doubleList string is empty? - %b\r\n",
            doubleToStringTransformer.isStringEmpty(doubleList)));
        //4
        System.out.println("\r\n4)\r\n");
        outer.accept(new String(new char[]{66, 79, 79, 79, 79, 32}).concat(StringTransformer.getSmile()));
        //another static method see in StringTransformer interface

    }
}
