package tasks.Task5;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task5 {

    public static void main(String[] args) {
        Collection<A> collection =Stream.of(
                new A(64, "Anatoliy Wasserman", 865.8, Stream.of("The art of role-playing", "Genius", "Rise of the horde", "Play the role of your stunt double").collect(Collectors.toList())),
                new A(26, "Victor Kath", 65.3, Stream.of("The art of role-playing", "Play the role of your stunt double").collect(Collectors.toList())),
                new A(35, "Dimtry Alpen Goldovich", 6004.2, Stream.of("Genius", "Rise of the horde").collect(Collectors.toList())),
                new A(32, "Semen Galkin", 400.0, Stream.of("The art of role-playing", "Genius").collect(Collectors.toList())),
                new A(16, "Egor Bespalov", 234.0, Stream.of("Genius", "Play the role of your stunt double").collect(Collectors.toList())),
                new A(17, "Marochko Anna", 45.0, Stream.of("The art of role-playing", "Play the role of your stunt double", "Genius").collect(Collectors.toList())),
                new A(13, "Strelkov Maksim", 118.0, Stream.of("Rise of the horde", "Play the role of your stunt double", "Genius").collect(Collectors.toList())),
                new A(32, "Hitruk Anatoliy", 632.4, Stream.of("The art of role-playing").collect(Collectors.toList())),
                new A(61, "Vorontsov Dmitry", 651.1, Stream.of("The art of role-playing", "Rise of the horde", "Genius").collect(Collectors.toList())),
                new A(55, "Dorofeev Alyaksandr", 112.3, Stream.of("The art of role-playing", "Rise of the horde").collect(Collectors.toList())),
                new A(44, "Ershov Oleg", 9965.7, new ArrayList<>()),
                new A(33, "Merkushev Oleg", 565.3, Stream.of("The art of role-playing").collect(Collectors.toList())),
                new A(22, "Shamrilo Stanislav", 56.3, Stream.of("Play the role of your stunt double").collect(Collectors.toList())),
                new A(18, "Shitar Afanasiy", 978.5, Stream.of("The art of role-playing", "Genius").collect(Collectors.toList())),
                new A(32, "Yakushev Vladimir", 123.9, Stream.of("Rise of the horde").collect(Collectors.toList())),
                new A(23, "Spivak Oskar", 652.3, new ArrayList<>()),
                new A(76, "Roshkov Ivan", 234.6, Stream.of("Genius", "Play the role of your stunt double").collect(Collectors.toList())),
                new A(56, "Kalinin Ilya", 765.3, Stream.of("The art of role-playing", "Genius").collect(Collectors.toList())),
                new A(65, "Myhin Edvard", 61.4, Stream.of("The art of role-playing").collect(Collectors.toList())),
                new A(45, "Vinogradova Polina", 1256.0, Stream.of("Play the role of your stunt double").collect(Collectors.toList())),
                new A(54, "Trubalevski Shamil", 655.8, Stream.of("Rise of the horde", "Genius").collect(Collectors.toList())),
                new A(80, "Klichko Vitaliy", 65.2, Stream.of("Genius", "Play the role of your stunt double").collect(Collectors.toList())),
                new A(18, "Borisov Yuriy", 9876.7, Stream.of("The art of role-playing", "Play the role of your stunt double","Genius").collect(Collectors.toList())),
                new A(23, "Chikolba Vasiliy", 6.8, new ArrayList<>()),
                new A(60, "Serduk Anton", 365.5, Stream.of("Genius", "Play the role of your stunt double").collect(Collectors.toList())),
                new A(150, "Pawn of the Old Gods", 265.3, Stream.of("Rise of the horde", "Genius").collect(Collectors.toList())),
                new A(40, "Drozdov Kirill", 165.6, Stream.of("Play the role of your stunt double").collect(Collectors.toList())))
                .collect(Collectors.toList());
        Map<String, List<String>> aMap = collection.stream().peek(System.out::println)
                .collect(new AStringCollector());
        System.out.println(aMap.toString());
        System.out.println();
        Map<String, List<String>> aMapParallel = collection.parallelStream().peek(System.out::println)
                .collect(new AStringCollector());
        System.out.println(aMapParallel);

    }

}
