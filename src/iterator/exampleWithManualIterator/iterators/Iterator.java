package iterator.exampleWithManualIterator.iterators;

public interface Iterator {
    /**
     * @return флаг, который указывает, остались ли к коллекции элементы для перебора
     */
    boolean hasNext();

    /**
     * @return следующий элемент коллекции
     */
    Object next();
}
