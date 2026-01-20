public class DoublyLinkedList {

    static class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
        }
    }

    Node head;
    Node tail;

    void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    void displayForward() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    void displayBackward() {
        Node temp = tail;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.prev;
        }
        System.out.println();
    }

    void deleteFirst() {
        if (head == null) return;
        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
    }

    void deleteLast() {
        if (tail == null) return;
        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
    }

    void deleteByValue(int value) {
        Node temp = head;
        while (temp != null && temp.data != value) {
            temp = temp.next;
        }
        if (temp == null) return;

        if (temp == head) deleteFirst();
        else if (temp == tail) deleteLast();
        else {
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
        }
    }

    void deleteBeforeValue(int value) {
        Node temp = head;
        while (temp != null && temp.data != value) {
            temp = temp.next;
        }
        if (temp == null || temp.prev == null) return;
        deleteByValue(temp.prev.data);
    }

    void deleteAfterValue(int value) {
        Node temp = head;
        while (temp != null && temp.data != value) {
            temp = temp.next;
        }
        if (temp == null || temp.next == null) return;
        deleteByValue(temp.next.data);
    }

    int findMin() {
        if (head == null) return Integer.MAX_VALUE;
        int min = head.data;
        Node temp = head.next;
        while (temp != null) {
            if (temp.data < min) min = temp.data;
            temp = temp.next;
        }
        return min;
    }

    int findMax() {
        if (head == null) return Integer.MIN_VALUE;
        int max = head.data;
        Node temp = head.next;
        while (temp != null) {
            if (temp.data > max) max = temp.data;
            temp = temp.next;
        }
        return max;
    }

    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();

        dll.insertAtBeginning(10);
        dll.insertAtBeginning(20);

        dll.insertAtEnd(30);
        dll.insertAtEnd(40);
        dll.insertAtEnd(5);
        dll.insertAtEnd(50);

        System.out.print("Forward traversal: ");
        dll.displayForward();
        System.out.print("Backward traversal: ");
        dll.displayBackward();

        dll.deleteFirst();
        dll.deleteLast();
        dll.deleteByValue(20);
        dll.deleteBeforeValue(30);
        dll.deleteAfterValue(20);

        System.out.print("After deletions, forward: ");
        dll.displayForward();
        System.out.print("After deletions, backward: ");
        dll.displayBackward();

        System.out.println("Minimum value: " + dll.findMin());
        System.out.println("Maximum value: " + dll.findMax());
    }
}











