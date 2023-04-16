public class Main {
    public static void main(String[] args) {
 //       MyList<Character> list = new MyArrayList<>();
        MyList<Character> list = new MyLinkedList<>();
        list.add('c');
        list.add('o');
        list.add('o');
        list.add('i');
        list.add('e');
        list.add('s');
        list.add('<');
        list.add('3', 7);
        list.add('k', 3);

        print(list);
        System.out.println("Size: " + list.size());
        System.out.println("Remove letter: " + list.get(6));
        list.remove(6);
        print(list);
        System.out.println("Decreased size: " + list.size());
        System.out.println("Index of 'k': " + list.indexOf('k'));
        System.out.println("Last index of 'o': " + list.lastIndexOf('o'));
        list.clear();
        System.out.print("Cleared list: ");
        print(list);
        System.out.println("Size: " + list.size());

    }

    public static void print(MyList list) {
        for (var el: list) {
            System.out.print(el);
        }
        System.out.println();
    }
}