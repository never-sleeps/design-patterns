package adapter.example;

import java.util.Enumeration;
import java.util.Iterator;

/**
 * Адаптер, преобразующий Enumeration в Iterator.
 *
 * Чтобы адаптер воспринимался клиентским кодом как итератор, он реализует интерфейс Iterator.
 */
public class EnumerationIteratorAdapter implements Iterator<Object> {

    Enumeration<Object> enumeration;

    /**
     * Адаптируемый объект Enumeration сохраняется в переменной (паттерн "композиция").
     * @param enumeration
     */
    public EnumerationIteratorAdapter(Enumeration<Object> enumeration) {
        this.enumeration = enumeration;
    }

    /**
     * Метод hasNext() интерфейса Iterator передает управление методу hasMoreElements() интерфейса Enumeration.
     * @return
     */
    @Override
    public boolean hasNext() {
        return enumeration.hasMoreElements();
    }

    /**
     * Метод next() интерфейса Iterator передаёт управление методу nextElement() интерфейса Enumeration.
     * @return
     */
    @Override
    public Object next() {
        return enumeration.nextElement();
    }

    /**
     * К сожалению, поддержать метод remove() интерфейса Iterator не удастся, поэтому просто инициируем исключение.
     */
    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
