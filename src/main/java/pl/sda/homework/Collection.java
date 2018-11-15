package pl.sda.homework;

import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

public class Collection {

//    Napisz metodę przetwarzającą podaną tablicę animals na listę elementów pozbawionych białych znaków (spacje, tabulatory) //1

    public static List<String> arrayAsList(String[] strings) {
        return new ArrayList<>(Arrays.asList(strings)).stream().filter(StringUtils::isNotBlank).map(String::trim).collect(Collectors.toList());
        // pytanie - czy lepiej używać new ArrayList<>(Arrays.asList(strings)) czy Arrays.stream(strings)?
    }

//    Napisz metodę przetwarzającą podaną tablicę animals na listę elementów pozbawionych białych znaków (spacje, tabulatory)
//    przyjmując naturalną kolejność dla klasy String

    public static List<String> arrayAsSortedList(String[] strings) {
        return Arrays.stream(strings).filter(StringUtils::isNotBlank).map(String::trim).sorted().collect(Collectors.toList());
    }

//    Napisz metodę przetwarzającą podaną tablicę animals na listę elementów pozbawionych białych znaków (spacje, tabulatory)
//    przyjmując kolejność według długości napisu oraz eliminując duplikaty

    public static List<String> arrayAsSortedListWithoutDuplicates(String[] strings) {
        return Arrays.stream(strings).filter(StringUtils::isNotBlank).map(String::trim).distinct().sorted(Comparator.comparing(String::length)).collect(Collectors.toList());
    }

//    Napisz metodę przetwarzającą podaną tablicę animals na listę elementów pozbawionych białych znaków (spacje, tabulatory)
//    przyjmując przekazaną kolejność oraz eliminując duplikaty

    public static List<String> arrayAsSortedListWithoutDuplicatesSavingOriginalOrder(String[] strings, Comparator<String> comparator) {
        return Arrays.stream(strings).filter(StringUtils::isNotBlank).map(String::trim).distinct().sorted(comparator).collect(Collectors.toList());
    }

//    Napisz metodę przetwarzającą podaną tablicę animals na set z zachowaniem kolejności elementów z oryginalnej tablicy
//    + należy zapewnić poprawne wyeliminowanie duplikatów

    public static Set<String> arrayAsSetSavingOriginalOrder(String[] strings) {
        return Arrays.stream(strings).filter(StringUtils::isNotBlank).map(String::trim).collect(Collectors.toCollection(LinkedHashSet::new));
    }

//    Napisz metodę która przyjmie tablicę i element po którym będziemy szukać (String) i wewnątrz wykorzysta metodę //1
//    a następnie jako wynik zwróci ile jest elementów równych szukanemu elementowi

    public static long countWords(String[] strings, String searchedText) {
        return Collection.arrayAsList(strings).stream().filter(s -> s.equals(searchedText.trim())).count();
    }
}
