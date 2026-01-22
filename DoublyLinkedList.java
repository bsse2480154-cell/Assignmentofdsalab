class DoublyLinkedList {

    // Node class
    static class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
            next = null;
            prev = null;
        }
    }

    // DLL class
    static class DLL {
        Node head;
        Node tail;

        // Insert at beginning
        public void insertAtBeginning(int data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = tail = newNode;
            } else {
                newNode.next = head;
                head.prev = newNode;
                head = newNode;
            }
        }

        // Insert at end
        public void insertAtEnd(int data) {
            Node newNode = new Node(data);
            if (tail == null) {
                head = tail = newNode;
            } else {
                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;
            }
        }

        // Forward traversal
        public void displayForward() {
            System.out.print("Forward: ");
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.println();
        }

        // Backward traversal
        public void displayBackward() {
            System.out.print("Backward: ");
            Node temp = tail;
            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.prev;
            }
            System.out.println();
        }

        // Delete first node
        public void deleteFirst() {
            if (head == null) return; // empty list
            if (head == tail) { // only one node
                head = tail = null;
            } else {
                head = head.next;
                head.prev = null;
            }
        }

        // Delete last node
        public void deleteLast() {
            if (tail == null) return; // empty list
            if (head == tail) { // only one node
                head = tail = null;
            } else {
                tail = tail.prev;
                tail.next = null;
            }
        }

        // Delete by value
        public void deleteByValue(int value) {
            Node temp = head;
            while (temp != null && temp.data != value) {
                temp = temp.next;
            }
            if (temp == null) return; // value not found
            if (temp == head) deleteFirst();
            else if (temp == tail) deleteLast();
            else {
                temp.prev.next = temp.next;
                temp.next.prev = temp.prev;
            }
        }

        // Delete node before a given value
        public void deleteBeforeValue(int value) {
            Node temp = head;
            while (temp != null && temp.data != value) {
                temp = temp.next;
            }
            if (temp == null || temp.prev == null) return; // value not found or no node before
            Node nodeToDelete = temp.prev;
            if (nodeToDelete == head) {
                deleteFirst();
            } else {
                nodeToDelete.prev.next = temp;
                temp.prev = nodeToDelete.prev;
            }
        }

        // Delete node after a given value
        public void deleteAfterValue(int value) {
            Node temp = head;
            while (temp != null && temp.data != value) {
                temp = temp.next;
            }
            if (temp == null || temp.next == null) return; // value not found or no node after
            Node nodeToDelete = temp.next;
            if (nodeToDelete == tail) {
                deleteLast();
            } else {
                temp.next = nodeToDelete.next;
                nodeToDelete.next.prev = temp;
            }
        }

        // Find minimum
        public int findMin() {
            if (head == null) return -1; // empty list
            int min = head.data;
            Node temp = head.next;
            while (temp != null) {
                if (temp.data < min) min = temp.data;
                temp = temp.next;
            }
            return min;
        }

        // Find maximum
        public int findMax() {
            if (head == null) return -1; // empty list
            int max = head.data;
            Node temp = head.next;
            while (temp != null) {
                if (temp.data > max) max = temp.data;
                temp = temp.next;
            }
            return max;
        }
    }

    // Main method
    public static void main(String[] args) {
        DLL list = new DLL();

        // Insert elements at the beginning
        list.insertAtBeginning(10);
        list.insertAtBeginning(20);

        // Insert elements at the end
        list.insertAtEnd(30);
        list.insertAtEnd(40);
        list.insertAtEnd(5);
        list.insertAtEnd(50);

        // Display
        list.displayForward();
        list.displayBackward();

        // Delete first and last
        list.deleteFirst();
        list.deleteLast();
        list.displayForward();

        // Delete by value
        list.deleteByValue(20);
        list.displayForward();

        // Delete before value
        list.deleteBeforeValue(30);
        list.displayForward();

        // Delete after value
        list.deleteAfterValue(20);
        list.displayForward();

        // Min and Max
        System.out.println("Min: " + list.findMin());
        System.out.println("Max: " + list.findMax());
        System.out.println("\n---- Time Complexity ----");
        System.out.println("Insert at beginning: O(1)");
        System.out.println("Insert at end: O(1)");
        System.out.println("Delete first: O(1)");
        System.out.println("Delete last: O(1)");
        System.out.println("Delete by value: O(n)");
        System.out.println("Delete before value: O(n)");
        System.out.println("Delete after value: O(n)");
        System.out.println("Find Min: O(n)");
        System.out.println("Find Max: O(n)");
        System.out.println("Traversal: O(n)");
    }
}
