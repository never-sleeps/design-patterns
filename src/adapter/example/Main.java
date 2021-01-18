package adapter.example;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Vector;

public class Main {
    public static void main(String[] args) {
        // Создаём объект Vector, метод elements() возвращает Enumeration
        Vector<Object> v = new Vector<>(Arrays.asList("a", "b", "c", "d"));
        Iterator<Object> iterator = new EnumerationIteratorAdapter(v.elements());

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
