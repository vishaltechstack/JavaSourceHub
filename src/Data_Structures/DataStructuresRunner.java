package Data_Structures;

public class DataStructuresRunner {

    public static void main(String[] args) {

        // --- 1. Testing CustomLinkedList ---
        System.out.println("=== 1. CUSTOM SINGLY LINKED LIST ===");
        CustomLinkedList<String> list = new CustomLinkedList<>();
        list.addLast("Java");
        list.addLast("Spring");
        list.addLast("Docker");
        list.addFirst("Core");
        list.printList(); // Core -> Java -> Spring -> Docker -> null

        list.reverse();
        System.out.print("Reversed: ");
        list.printList(); // Docker -> Spring -> Java -> Core -> null

        // --- 2. Testing CustomStack (LIFO) ---
        System.out.println("\n=== 2. CUSTOM STACK (LIFO) ===");
        CustomStack<Integer> stack = new CustomStack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println("Top element (peek): " + stack.peek()); // 30
        System.out.println("Popped: " + stack.pop());              // 30
        System.out.println("Popped: " + stack.pop());              // 20

        // --- 3. Testing CustomQueue (FIFO) ---
        System.out.println("\n=== 3. CUSTOM QUEUE (FIFO) ===");
        CustomQueue<String> printQueue = new CustomQueue<>();
        printQueue.enqueue("Document_1.pdf");
        printQueue.enqueue("Document_2.pdf");
        printQueue.enqueue("Document_3.pdf");
        System.out.println("Processing first: " + printQueue.dequeue()); // Document_1.pdf
        System.out.println("Next in line: " + printQueue.peekFront());   // Document_2.pdf

        // --- 4. Testing BinarySearchTree ---
        System.out.println("\n=== 4. BINARY SEARCH TREE (BST) ===");
        BinarySearchTree bst = new BinarySearchTree();
        int[] values = {50, 30, 70, 20, 40, 60, 80};
        for (int v : values) {
            bst.insert(v);
        }
        bst.printInOrder(); // 20 30 40 50 60 70 80
        System.out.println("Contains 60? " + bst.contains(60)); // true
        System.out.println("Contains 99? " + bst.contains(99)); // false
    }
}
