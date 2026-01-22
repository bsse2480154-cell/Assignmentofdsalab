class Node {
    int data;
    Node next;
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class QueueLinkedList {
    Node front, rear;

    public QueueLinkedList() {
        front = rear = null;
    }

    // Enqueue
    public void enqueue(int val) {
        Node newNode = new Node(val);
        if (rear == null) { // empty queue
            front = rear = newNode;
            return;
        }
        rear.next = newNode;
        rear = newNode;
    }

    // Dequeue
    public int dequeue() {
        if (front == null) {
            System.out.println("Queue is empty!");
            return -1;
        }
        int val = front.data;
        front = front.next;
        if (front == null) rear = null; // queue became empty
        return val;
    }

    // Peek
    public int peek() {
        if (front == null) {
            System.out.println("Queue is empty!");
            return -1;
        }
        return front.data;
    }

    // Display
    public void display() {
        System.out.print("Queue: ");
        Node temp = front;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Find minimum
    public int findMin() {
        if (front == null) return -1;
        int min = front.data;
        Node temp = front.next;
        while (temp != null) {
            if (temp.data < min) min = temp.data;
            temp = temp.next;
        }
        return min;
    }

    // Find maximum
    public int findMax() {
        if (front == null) return -1;
        int max = front.data;
        Node temp = front.next;
        while (temp != null) {
            if (temp.data > max) max = temp.data;
            temp = temp.next;
        }
        return max;
    }

    // Main method
    public static void main(String[] args) {
        QueueLinkedList q = new QueueLinkedList();

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);

        q.display();

        System.out.println("Dequeue: " + q.dequeue());
        System.out.println("Peek: " + q.peek());

        q.display();

        System.out.println("Min: " + q.findMin());
        System.out.println("Max: " + q.findMax());
        System.out.println("\nComparsion between array and linked list based on timecomplexity and memory usuage");

        System.out.println("Time Complexity:");
        System.out.println("Enqueue in Array Queue takes O(1) on average, but becomes O(n) when resizing occurs.");
        System.out.println("Enqueue in Linked List Queue always takes O(1).");

        System.out.println("Dequeue in both Array and Linked List Queue takes O(1).");
        System.out.println("Peek in both Array and Linked List Queue takes O(1).");

        System.out.println("Finding minimum in both queues takes O(n).");
        System.out.println("Finding maximum in both queues takes O(n).");

        System.out.println("Displaying the queue in both implementations takes O(n).");

        System.out.println("\nMemory Usage:");
        System.out.println("Array Queue uses a fixed contiguous block of memory and may waste unused space.");
        System.out.println("Linked List Queue uses dynamic memory and requires extra memory for pointers.");

        System.out.println("\nConclusion:");
        System.out.println("Array Queue is faster in memory access but needs resizing when full.");
        System.out.println("Linked List Queue does not need resizing but uses more memory per element.");

    }
}
