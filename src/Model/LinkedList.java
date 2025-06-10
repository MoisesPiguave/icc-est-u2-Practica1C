package Model;

public class LinkedList<T> {
    public Node<T> head;
    public Node<T> tail;
    private int size = 0;

    public void appendToTail(T value) {
        Node<T> newNode = new Node<>(value);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.setNext(newNode);
            tail = newNode;
        }
        size++;
    }

    public T findByValue(T value) {
        Node<T> current = head;
        while (current != null) {
            if (current.getvalue().equals(value)) {
                return current.getvalue();
            }
            current = current.getNext();
        }
        return null;
    }

    public boolean deleteByValue(T value) {
        if (head == null)
            return false;

        if (head.getvalue().equals(value)) {
            head = head.getNext();
            if (head == null) tail = null; // lista vacía después de borrar
            size--;
            return true;
        }

        Node<T> current = head;
        while (current.getNext() != null && !current.getNext().getvalue().equals(value)) {
            current = current.getNext();
        }

        if (current.getNext() == null) {
            return false;
        }

        // Si el nodo a eliminar es el tail, actualiza tail
        if (current.getNext() == tail) {
            tail = current;
        }

        current.setNext(current.getNext().getNext());
        size--;
        return true;
    }

    public void print() {
        if (head == null) {
            System.out.println("fin");
            return;
        }
        Node<T> current = head;
        while (current.getNext() != null) {
            System.out.print(current.getvalue() + " -> ");
            current = current.getNext();
        }
        System.out.println(current.getvalue() + " -> fin");
    }

    public Node<T> getHead() {
        return head;
    }

    public void setHead(Node<T> head) {
        this.head = head;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
