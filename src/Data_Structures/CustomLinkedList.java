package Data_Structures;

public class CustomLinkedList<T> {

    // Private inner Node class representing each link in the chain
    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node<T> head; // Points to the very first node in the list
    private int size;

    // 1. Insert at the beginning: O(1) constant time
    public void addFirst(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.next = head; // New node points to current head
        head = newNode;      // Head moves back to new node
        size++;
    }

    // 2. Insert at the end: O(n) linear time
    public void addLast(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            // Traverse until reaching the last node (whose next is null)
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    // 3. Remove first occurrence of a value: O(n)
    public boolean remove(T target) {
        if (head == null) return false;

        // Special case: target is at the head
        if (head.data.equals(target)) {
            head = head.next;
            size--;
            return true;
        }

        Node<T> current = head;
        while (current.next != null) {
            if (current.next.data.equals(target)) {
                // Bypass the matched node so Garbage Collector reclaims it
                current.next = current.next.next;
                size--;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // 4. Reverse the Linked List in-place using three pointers: O(n) time, O(1) space
    public void reverse() {
        Node<T> prev = null;
        Node<T> current = head;
        Node<T> nextNode;

        while (current != null) {
            nextNode = current.next; // Save next link before breaking it
            current.next = prev;     // Reverse pointer direction
            prev = current;          // Move prev forward
            current = nextNode;      // Move current forward
        }
        head = prev; // Update head to the new front
    }

    public void printList() {
        Node<T> current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null (Size: " + size + ")");
    }
}
