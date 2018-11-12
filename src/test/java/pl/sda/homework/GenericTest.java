package pl.sda.homework;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;

public class GenericTest {
    List<String> fruits = Lists.newArrayList("Apple", "Banana", "Strawberry");
    Comparator<String> comparator = Comparator.reverseOrder();
    List<Double> numbers1 = Lists.newArrayList(123.0, 2.5, 3.4);
    List<Integer> numbers2 = Lists.newArrayList(123, 2, 3);

    @Test
    void simplePrint() {
        Generic.printList(fruits);
    }

    @Test
    void simplePrintwithStream() {
        Generic.printListWithStream(fruits);
    }

    @Test
    void orderedPrint() {
        Generic.printOrderedList(fruits, comparator);
    }

    @Test
    void orderedPrintWithStream() {
        Generic.printOrderedListWithList(fruits, comparator);
    }

    @Test
    void summingList() {
        System.out.println(Generic.sumList(numbers1));
        System.out.println(Generic.sumList(numbers2));
    }

    @Test
    void summingListWithStream() {
        System.out.println(Generic.sumListWithStream(numbers1));
        System.out.println(Generic.sumListWithStream(numbers2));
    }

    @Test
    void summingList5WithStream() {
        System.out.println(Generic.sumList5WithStream(numbers1));
        System.out.println(Generic.sumList5WithStream(numbers2));
    }

}
