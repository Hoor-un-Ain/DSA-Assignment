public class QueueLinkedList {
    private Node front, rear;
    private int size;

    private static class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; }
    }

    public QueueLinkedList() {
        front = rear = null;
        size = 0;
    }

    public void enqueue(int val) {
        Node newNode = new Node(val);
        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    public int dequeue() {
        if (front == null) throw new RuntimeException("Queue is empty");
        int val = front.data;
        front = front.next;
        if (front == null) rear = null;
        size--;
        return val;
    }

    public int peek() {
        if (front == null) throw new RuntimeException("Queue is empty");
        return front.data;
    }

    public void display() {
        System.out.print("Queue: ");
        Node temp = front;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public int findMin() {
        if (front == null) throw new RuntimeException("Queue is empty");
        int min = front.data;
        Node temp = front.next;
        while (temp != null) {
            if (temp.data < min) min = temp.data;
            temp = temp.next;
        }
        return min;
    }

    public int findMax() {
        if (front == null) throw new RuntimeException("Queue is empty");
        int max = front.data;
        Node temp = front.next;
        while (temp != null) {
            if (temp.data > max) max = temp.data;
            temp = temp.next;
        }
        return max;
    }

    public static void main(String[] args) {
        QueueLinkedList q = new QueueLinkedList();
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);

        q.display();
        System.out.println("Dequeued: " + q.dequeue());
        q.display();

        System.out.println("Peek: " + q.peek());
        System.out.println("Min: " + q.findMin());
        System.out.println("Max: " + q.findMax());
    }
}
