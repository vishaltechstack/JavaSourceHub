package Data_Structures;

import java.util.NoSuchElementException;

public class CustomQueue<T> {

    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
        }
    }

    private Node<T> front; // Head of the queue (elements leave from here)
    private Node<T> rear;  // Tail of the queue (new elements join here)
    private int size;

    // 1. Enqueue: Add element to the rear of the queue: O(1)
    public void enqueue(T item) {
        Node<T> newNode = new Node<>(item);
        if (rear != null) {
            rear.next = newNode; // Link old rear to new node
        }
        rear = newNode; // Update rear pointer

        if (front == null) {
            front = rear; // If queue was empty, front and rear both point to newNode
        }
        size++;
    }

    // 2. Dequeue: Remove and return element from the front of the queue: O(1)
    public T dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty!");
        }
        T value = front.data;
        front = front.next; // Advance front pointer

        if (front == null) {
            rear = null; // Queue is now completely empty
        }
        size--;
        return value;
    }

    public T peekFront() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty!");
        }
        return front.data;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public int size() {
        return size;
    }
}