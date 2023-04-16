import java.util.Iterator;

public class MyLinkedList<E> implements MyList<E> {
    private Node head;
    private Node tail;
    private int size;

    private class Node {
        private E data;
        private Node prev;
        private Node next;

        Node(E data) {
            this.data = data;
        }
    }

    public void add(E element) {
        Node newNode = new Node(element);
        newNode.next = null;

        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }

        size++;
    }

    @Override
    public void add(E element, int index) {
        if (index > size) throw new IndexOutOfBoundsException();

        Node newNode = new Node(element);

        if (index == 0) {
            newNode.next = head;
            head = newNode;
            newNode.prev = null;
        }
        else if (index == size) {
            add(element);
            return;
        }
        else {
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }

            newNode.next = current.next;
            newNode.prev = current;
            current.next = current.next.prev = newNode;
        }

        size++;
    }

    @Override
    public E get(int index) {
        if (index >= size) throw new IndexOutOfBoundsException();

        Node current;
        if (index < size - index) {
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        }
        else {
            current = tail;
            for (int i = size - 1; i > index; i--) {
                current = current.prev;
            }
        }

        return current.data;
    }

    @Override
    public boolean remove(E element) {

        if (head.data == element) {
            head = head.next;
            head.prev = null;
            size--;
            return true;
        }
        else if (tail.data == element) {
            tail = tail.prev;
            tail.next = null;
            size--;
            return true;
        }
        else {
            Node current = head;
            for (int i = 0; i < size; i++) {
                if (current.data == element) {
                    size--;
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                    return true;
                }
                current = current.next;
            }
        }

        return false;
    }

    @Override
    public E remove(int index) {
        if (index >= size) throw new IndexOutOfBoundsException();

        E removedElement = get(index);
        remove(removedElement);

        return removedElement;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) > -1;
    }

    @Override
    public void clear() {
        head = tail = null;
        size = 0;
    }

    @Override
    public int indexOf(Object o) {
        Node current = head;
        for (int i = 0; i < size; i++) {
            if (current.data == o)
                return i;
            current = current.next;
        }

        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        int index = -1;
        Node current = head;
        for (int i = 0; i < size; i++) {
            if (current.data == o)
                index = i;
            current = current.next;
        }

        return index;
    }

    @Override
    public void sort() {

    }

    @Override
    public Iterator<E> iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator<E> {
        Node cursor = head;

        @Override
        public boolean hasNext() {
            return cursor != null;
        }

        @Override
        public E next() {
            E data = cursor.data;
            cursor = cursor.next;

            return data;
        }
    }
}