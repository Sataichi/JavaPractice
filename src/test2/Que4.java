package test2;

import java.time.Period;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Que4 {
	public static void main(String [] args) {
		//generating user list
		List<OtherUser> list =Stream.of(
				new OtherUser("Arthas", "Menetil", Period.of(24, 1, 6), Stream.of(new Order("11","myOrder"), new Order("12","hisOrder")).collect(Collectors.toList())),
				new OtherUser("Sylvanas", "Windrunner", Period.of(2700, 4, 5), Stream.of(new Order("21","Order"), new Order("23","isOrder")).collect(Collectors.toList())),
				new OtherUser("Illidan", "Stormrage", Period.of(15032, 5, 3), Stream.of(new Order("32","FDFDOrder"), new Order("33","newOrder")).collect(Collectors.toList())),
				new OtherUser("Jaina","Proudmoore",Period.of(36, 11, 5), Stream.of(new Order("42","loopOrder"), new Order("43","Order")).collect(Collectors.toList())))
				.collect(Collectors.toList());
		//transform list of users to orders list
		Set<String> orders = list.stream()
								.map(OtherUser::getOrders)
								.flatMap(Collection::stream)
								.map(Order::getName)
								.collect(Collectors.toSet());
		//output order list to System.out
		orders.forEach(System.out::println);
	}

}
