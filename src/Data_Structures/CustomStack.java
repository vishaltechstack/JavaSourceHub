package Data_Structures;

import java.util.EmptyStackException;

public class CustomStack<T> {

    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node<T> top; // Always points to the most recently pushed element
    private int size;

    // 1. Push element onto the top of the stack: O(1)
    public void push(T item) {
        top = new Node<>(item, top);
        size++;
    }

    // 2. Remove and return the top element: O(1)
    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        T value = top.data;
        top = top.next; // Move top down to the previous element
        size--;
        return value;
    }

    // 3. View the top element without removing it: O(1)
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public int size() {
        return size;
    }
}