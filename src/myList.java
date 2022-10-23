package container;
//Написать  класс связанный список myList

//Написать метод добавление элемента в  конец  списка

//Написать метод вывод всех элемента списка

//Написать тестовый класс демонстрирующий метод вывод всех элемента списка на экран переопределив метод toString
public class myList<T> {

    private Node head;
    private Node end;
    private int size = 0;

    public myList() {
        head = null;
    }

    public class Node<T> {
        public T element;
        public Node nextElement;


        public Node(T element) {
            this.element = element;
            nextElement = null;
        }
    }

    public myList(Node<T> head, Node<T> end, int size) {
        this.head = head;
        this.end = end;
        this.size = size;
    }

    public Node<T> getHead() {
        return head;
    }

    public Node<T> getEnd() {
        return end;
    }

    public int getSize() {
        return size;
    }
    public void addFirst(T element) {
        Node<T> current = new Node<T>(element);
        current.element = element;
        if (head == null) {
            head = current;
        } else {
            current.nextElement = head;
            head = current;
        }
        size++;
    }

    public void addLast(T element) throws Exception {
        if (head == null) {
            throw new Exception("Невозможно добавить элемент в конец контейнера, пока у него нет начала!");
        }
        Node<T> current = new Node<T>(element);
        current.element = element;
        Node<T> node = head;
        while (node.nextElement != null) {
            node = node.nextElement;
        }
        node.nextElement = current;
        end = current;
        size++;
    }

    public String toString() {
        System.out.print("Вывод содержимого контейнера: [ ");
        if (head == null) {
            System.out.print("Контейнер пуст");
        }
        Node<T> current = head;
        while (current != null) {
            System.out.print(current.element + " ");
            current = current.nextElement;
        }
        System.out.println("]");
        return " ";
    }

    public static void main(String[] args) throws Exception {
        myList list = new myList();
        list.addFirst(5);
        list.addLast("Hello");
        list.addLast(true);
        list.toString();
    }
}
