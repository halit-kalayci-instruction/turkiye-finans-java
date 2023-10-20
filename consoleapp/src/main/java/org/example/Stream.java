package org.example;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Stream {
    public static void main(String[] args) {
        // Java Stream API => Java 8
        List<Integer> numbers = Arrays.asList(5,71,59,14,23,3);
        /*List<Integer> squareNumbers = Arrays.asList();

        for (Integer number:
             numbers) {
            squareNumbers.add(number*number);
        }*/

        // toList =>
        // collect
        /*var y = numbers
                .stream()
                .map(number-> number*number)
                .collect(Collectors.toList());*/
        var squareList = numbers.stream().map(number-> number*number).toList();
        System.out.println(squareList);

        var filteredList = numbers.stream().filter(number -> number < 15).toList();
        System.out.println(filteredList);

        var sortedList = numbers.stream().sorted().toList();
        System.out.println(sortedList);

        var sortedReverse = numbers.stream()
                .sorted(Comparator.reverseOrder()).toList();
        System.out.println(sortedReverse);

        User user1 = new User(1,"Halit","Kalaycı",24);
        User user2 = new User(2,"Engin","Demiroğ",35);
        User user3 = new User(3,"Ahmet","Çetinkaya",17);
        User user4 = new User(4,"Mehmet","Dere",28);
        User user5 = new User(5,"Deniz","Ak",19);

        List<User> users = Arrays.asList(user1,user2,user3,user4,user5);

        List<UserForListingDto> dtos = users
                .stream()
                // her bir user'a işleniyor
                .map((user) -> new UserForListingDto(user.getId(), user.getName()))
                .toList();
        /*
        List<UserForListingDto> dtos2 = users
                .stream()
                // her girdiyi birden çok çıktı öğesine eşler
                // nested collection
                //.flatMap((x) -> x.)
                .toList(); */
        System.out.println(dtos);

        List<User> filteredUsers = users.stream()
                .filter((user) -> user.getAge() > 18)
                .toList();
        filteredUsers.forEach((user) -> System.out.println(user.toString()));
        System.out.println("*******************************");
        List<User> sortedUsers = users.stream()
                .sorted((u1,u2) -> (u1.getName().compareTo(u2.getName())))
                .toList();
        sortedUsers.forEach((user) -> System.out.println(user.toString()));

        System.out.println("************* SORT 2 ******************");
        List<User> sortedUsers2 = users.stream()
                .sorted(Comparator.comparing(User::getAge).thenComparing(User::getAge))
                .toList();
        sortedUsers2.forEach((user) -> System.out.println(user.toString()));

    }
}
