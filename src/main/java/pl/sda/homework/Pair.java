package pl.sda.homework;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

//Napisz klasę generyczną klasę Pair przechowującą dwa elementy różnych typów (T,E)
//Napisz metodę która porówna dwa obiekty klasy Pair (equals)

@Getter
@Setter
public class Pair<T, E> {
    private T element1;
    private E element2;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair<?, ?> pair = (Pair<?, ?>) o;
        return Objects.equals(element1, pair.element1) &&
                Objects.equals(element2, pair.element2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(element1, element2);
    }
}

