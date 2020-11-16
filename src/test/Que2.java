package test;

import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Que2 {
	public static void main(String[] args) {
		//generating set of strings
		Set<String> set =Stream.generate(UUID::randomUUID)
						.limit(50)
						.map(UUID::toString)
						.collect(Collectors.toSet());
		//joining to string
		String s = set.stream()
					.sorted()
					.collect(Collectors.joining(", "));
		//string output to System.Out
		System.out.println(s);
	}

}
