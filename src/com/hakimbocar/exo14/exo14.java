package com.hakimbocar.exo14;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class exo14 {

    public static void main(String[] args) {
        List<String> strings = Arrays.asList(
                "one","two","three",
                "four","five","six",
                "seven","eight","nine",
                "ten","eleven","twelve"
        );

        /* Question 1 */
        System.out.println("Display the list of the string:");
        strings.forEach(System.out::println);
        System.out.println("==================================================================");

        /* Question 2 */
        System.out.println("Display the list of the string in UpperCase:");
        strings.stream().map(String::toUpperCase).forEach(System.out::println);
        System.out.println("==================================================================");

        /* Question 3 */
        System.out.println("Display the list of the string with first letter of each element in UpperCase:");
        strings.stream()
                .map(s -> s.substring(0, 1).toUpperCase() + s.substring(1))
                .forEach(System.out::println);
        System.out.println("==================================================================");

        /* Question 4 */
        System.out.println("Display the length of each element in the list of string:");
        strings.stream()
                .map(String::length)
                .distinct()
                .forEach(System.out::println);
        System.out.println("==================================================================");

        /* Question 5 */
        System.out.println("Display the number of element in the list of string:");
        System.out.println(strings.stream().distinct().count());
        System.out.println("==================================================================");

        /* Question 6 */
        System.out.println("Display the number of element in the list of string with odd length:");
        System.out.println(strings.stream().filter((s -> s.length()%2==0)).distinct().count());
        System.out.println("==================================================================");

        /* Question 7 */
        System.out.println("Display the length of the longest string:");
        strings.stream()
               .max(Comparator.comparingInt(String::length))
               .ifPresent(longest -> System.out.println("The longest string length is:" +longest.length()));
       System.out.println("==================================================================");

        /* Question 8 */
        List<String> stringsOddLengthAndToUpperCase = strings.
                stream()
                .map(String::toUpperCase)
                .filter((s -> s.length()%2 !=0))
                .collect(Collectors.toList());

        System.out.println("Display the List of the string with odd length and in UpperCase:");
        stringsOddLengthAndToUpperCase.forEach(System.out::println);
        System.out.println("==================================================================");

        /* Question 9 */
        String wordOfFiveCharactersOrLess =
                strings.stream()
                        .filter(word -> word.length() <= 5)
                        .sorted(Comparator.comparing(String::toString))
                        .collect(Collectors.joining(" , ", "{", "}"));

        System.out.println("Word that contains 5 characters or less:\n" + wordOfFiveCharactersOrLess);
        System.out.println("==================================================================");

        /*
         * Question 10
         * key   : length of each element of the List String
         * value : string having the same length
         */
        Map<Integer,List<String>> prettyMap = strings.stream()
                .collect(Collectors.groupingBy(String::length,
                Collectors.toList()));


        System.out.println("Display the map created with the list of strings\n\t(K:length,V:List<String>)");
        prettyMap.forEach((key, value) -> System.out.println(key + " = " + value));
        System.out.println("==================================================================");


        /* Question 11
         * key   : first letter of each element of the List String
         * value : concatenation of each string of the list with the right key
         */

        Map<String,String> firstLetterMap = strings.stream()
                .collect(Collectors.groupingBy(word -> word.substring(0, 1),Collectors.joining(", ")));

        System.out.println("Display the map created with the list of strings\n\t(K:firstLetter,V:ConcatString)");
        firstLetterMap.forEach((key, value) -> System.out.println(key + " = " + value));
        System.out.println("==================================================================");
    }
}
