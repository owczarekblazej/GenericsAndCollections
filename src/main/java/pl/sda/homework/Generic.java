package pl.sda.homework;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;

public class Generic {

    //   Napisz generyczną metodę która przyjmuje Listę jakichkolwiek elementów i wypisuje wszystkie elementy tej listy
    public static <T> void printList(List<T> list) {
        for (T t : list) {
            System.out.println(t);
        }
    }

    public static <T> void printListWithStream(List<T> list) {
        list.forEach(System.out::println);
    }

    //    Napisz generyczną metodę która przyjmuje Listę jakichkolwiek elementów i wypisuje wszystkie elementy tej listy,
//    ale z zachowaniem kolejności przekazanej w parametrze
    public static <T> void printOrderedList(List<T> list, Comparator<T> comparator) {
        Collections.sort(list, comparator);
        for (T t : list) {
            System.out.println(t);
        }
    }

    public static <T> void printOrderedListWithList(List<T> list, Comparator<T> comparator) {
        list.stream().sorted(comparator).forEach(System.out::println);
    }

    //    Napisz generyczną metodę która przyjmuje Listę elementów będących jakimikowiek numerami i zwraca ich sumę
    public static <T extends Number> Number sumList(List<T> list) {
        Number result = 0;
        if (list.isEmpty()) {
            return 0;
        } else {

            if (list.get(0) instanceof Integer) {
                for (T t : list) {
                    result = result.intValue() + t.intValue();
                }
            }
            if (list.get(0) instanceof Long) {
                for (T t : list) {
                    result = result.longValue() + t.longValue();
                }
            }
            if (list.get(0) instanceof Float) {
                for (T t : list) {
                    result = result.floatValue() + t.floatValue();
                }
            }
            if (list.get(0) instanceof Double) {
                for (T t : list) {
                    result = result.doubleValue() + t.doubleValue();
                }
            }
            if (list.get(0) instanceof Byte) {
                for (T t : list) {
                    result = result.byteValue() + t.byteValue();
                }
            }
            if (list.get(0) instanceof Short) {
                for (T t : list) {
                    result = result.shortValue() + t.shortValue();
                }
            }
        }
        return result;
    }

    public static <T extends Number> OptionalDouble sumListWithStream(List<T> list) {
       return list.stream().mapToDouble(Number::doubleValue).reduce((t1, t2)->t1+t2);
    }

//    Napisz generyczną metodę która przyjmuje Listę elementów będących jakimikowiek numerami i zwraca ich sumę,
//    ale filtruje elementy większe od dodatkowo przekazanego parametru

    public static <T extends Number> OptionalDouble sumList5WithStream(List<T> list){
        return list.stream().mapToDouble(Number::doubleValue).filter(d->d>5).reduce((d1,d2) -> d1+d2);
    }
}
