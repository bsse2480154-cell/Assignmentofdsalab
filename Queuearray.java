//Question no 2 part A
public class Queuearray {
    int[] arr;
    int front, rear, size;

    // Constructor
    public Queuearray(int capacity) {
        arr = new int[capacity];
        front = 0;
        rear = 0;
        size = 0;
    }

    // Enqueue
    public void enqueue(int val) {
        // Resize if full
        if (size == arr.length) {
            int[] newArr = new int[arr.length * 2];
            for (int i = 0; i < size; i++) {
                newArr[i] = arr[(front + i) % arr.length];
            }
            arr = newArr;
            front = 0;
            rear = size;
            System.out.println("Array resized to " + arr.length);
        }
        arr[rear] = val;
        rear = (rear + 1) % arr.length;
        size++;
    }

    // Dequeue
    public int dequeue() {
        if (size == 0) {
            System.out.println("Queue is empty!");
            return -1;
        }
        int val = arr[front];
        front = (front + 1) % arr.length;
        size--;
        return val;
    }

    // Peek
    public int peek() {
        if (size == 0) {
            System.out.println("Queue is empty!");
            return -1;
        }
        return arr[front];
    }

    // Display
    public void display() {
        System.out.print("Queue: ");
        for (int i = 0; i < size; i++) {
            System.out.print(arr[(front + i) % arr.length] + " ");
        }
        System.out.println();
    }

    // Find minimum
    public int findMin() {
        if (size == 0) return -1;
        int min = arr[front];
        for (int i = 1; i < size; i++) {
            int val = arr[(front + i) % arr.length];
            if (val < min) min = val;
        }
        return min;
    }

    // Find maximum
    public int findMax() {
        if (size == 0) return -1;
        int max = arr[front];
        for (int i = 1; i < size; i++) {
            int val = arr[(front + i) % arr.length];
            if (val > max) max = val;
        }
        return max;
    }


    public static void main(String[] args) {
        Queuearray q = new Queuearray(3); // initial size = 3

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40); // triggers resize

        q.display();

        System.out.println("Dequeue: " + q.dequeue());
        System.out.println("Peek: " + q.peek());

        q.display();

        System.out.println("Min: " + q.findMin());
        System.out.println("Max: " + q.findMax());
    }
}
