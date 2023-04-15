public interface MyList<E> extends Iterable<E>{
    void add(E element);
    E get(int index);
    void remove(int index);
    int size();
}
