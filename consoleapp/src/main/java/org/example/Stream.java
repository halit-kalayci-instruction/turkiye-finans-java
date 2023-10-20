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
    }
}
