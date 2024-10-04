package abstractions;

public interface IList<T> {
    int size();

    T get(int index);

    int indexOf(T element);

    void add(T element);

    void insert(T element, int index);

    T removeByIndex(int index);

    T removeByElement(T element);
}
