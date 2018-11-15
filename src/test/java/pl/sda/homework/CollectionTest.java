package pl.sda.homework;

import com.google.common.collect.Sets;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class CollectionTest {

    String[] animals = new String[]{"cat", "dog ", "mouse", "rat", "pig", "rabbit", "hamster", " ", "parrot", "cat", "", "dog", "cat", "  pig", "dog", null};

    @Test
    void parsingArrayToList(){
        List<String> expectedList = Arrays.asList("cat", "dog", "mouse", "rat", "pig", "rabbit", "hamster", "parrot", "cat","dog", "cat", "pig", "dog");

        List<String> result = Collection.arrayAsList(animals);

        Assertions.assertEquals(expectedList,result);
    }

    @Test
    void parsingArrayToSortedList(){
        List<String> expectedList = Arrays.asList("cat", "cat", "cat", "dog", "dog", "dog", "hamster", "mouse", "parrot", "pig", "pig", "rabbit", "rat");

        List<String> result = Collection.arrayAsSortedList(animals);

        Assertions.assertEquals(expectedList,result);
    }

    @Test
    void parsingArrayToSortedListWithoutDuplicates(){
        List<String> expectedList = Arrays.asList("cat", "dog", "rat", "pig", "mouse", "rabbit", "parrot", "hamster");

        List<String> result = Collection.arrayAsSortedListWithoutDuplicates(animals);

        Assertions.assertEquals(expectedList,result);
    }

    @Test
    void parsingArrayToSortedListWithoutDuplicatesComparator(){
        List<String> expectedList = Arrays.asList("rat", "rabbit", "pig", "parrot", "mouse", "hamster", "dog", "cat");
        Comparator<String> comparator = Comparator.reverseOrder();

        List<String> result = Collection.arrayAsSortedListWithoutDuplicatesSavingOriginalOrder(animals,comparator);

        Assertions.assertEquals(expectedList,result);
    }

    @Test
    void parsingArrayToSet(){
        List<String> expectedList = Arrays.asList("rat", "rabbit", "pig", "parrot", "mouse", "hamster", "dog", "cat");
        Set<String> expectedSet = Sets.newLinkedHashSet(expectedList);

        Set<String> result = Collection.arrayAsSetSavingOriginalOrder(animals);

        Assertions.assertEquals(expectedSet,result);
    }

    @Test
    void numberOfWords(){
        long result = Collection.countWords(animals,"");

        Assertions.assertEquals(0,result);
    }
}
