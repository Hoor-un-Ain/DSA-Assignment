import java.util.Arrays;

public class QueueArray {
    int[] queue;
    int front, rear, size;

    QueueArray(int capacity) {
        queue = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    void enqueue(int data) {
        if (size == queue.length) {
            queue = Arrays.copyOf(queue, queue.length * 2);
        }
        rear = (rear + 1) % queue.length;
        queue[rear] = data;
        size++;
    }

    int dequeue() {
        if (size == 0) return -1;
        int val = queue[front];
        front = (front + 1) % queue.length;
        size--;
        return val;
    }

    int peek() {
        if (size == 0) return -1;
        return queue[front];
    }

    void display() {
        for (int i = 0; i < size; i++) {
            System.out.print(queue[(front + i) % queue.length] + " ");
        }
        System.out.println();
    }

    int findMin() {
        if (size == 0) return -1;
        int min = queue[front];
        for (int i = 1; i < size; i++) {
            int val = queue[(front + i) % queue.length];
            if (val < min) min = val;
        }
        return min;
    }

    int findMax() {
        if (size == 0) return -1;
        int max = queue[front];
        for (int i = 1; i < size; i++) {
            int val = queue[(front + i) % queue.length];
            if (val > max) max = val;
        }
        return max;
    }

    public static void main(String[] args) {
        QueueArray q = new QueueArray(3);

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);

        System.out.print("Queue: ");
        q.display();

        System.out.println("Dequeue: " + q.dequeue());
        System.out.println("Peek: " + q.peek());
        System.out.println("Min: " + q.findMin());
        System.out.println("Max: " + q.findMax());

        System.out.print("Queue after dequeue: ");
        q.display();
    }
}
