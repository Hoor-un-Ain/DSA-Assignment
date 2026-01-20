public class QueueArray {
    private int[] queue;
    private int front, rear, size;

    public QueueArray(int capacity) {
        queue = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    public void enqueue(int val) {
        if (size == queue.length) {
            int[] newQueue = new int[queue.length * 2];
            for (int i = 0; i < size; i++) {
                newQueue[i] = queue[(front + i) % queue.length];
            }
            queue = newQueue;
            front = 0;
            rear = size - 1;
        }
        rear = (rear + 1) % queue.length;
        queue[rear] = val;
        size++;
    }

    public int dequeue() {
        if (size == 0) throw new RuntimeException("Queue is empty");
        int val = queue[front];
        front = (front + 1) % queue.length;
        size--;
        return val;
    }

    public int peek() {
        if (size == 0) throw new RuntimeException("Queue is empty");
        return queue[front];
    }

    public void display() {
        System.out.print("Queue: ");
        for (int i = 0; i < size; i++) {
            System.out.print(queue[(front + i) % queue.length] + " ");
        }
        System.out.println();
    }

    public int findMin() {
        if (size == 0) throw new RuntimeException("Queue is empty");
        int min = queue[front];
        for (int i = 1; i < size; i++) {
            int val = queue[(front + i) % queue.length];
            if (val < min) min = val;
        }
        return min;
    }

    public int findMax() {
        if (size == 0) throw new RuntimeException("Queue is empty");
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

        q.display();
        System.out.println("Dequeued: " + q.dequeue());
        q.display();

        System.out.println("Peek: " + q.peek());
        System.out.println("Min: " + q.findMin());
        System.out.println("Max: " + q.findMax());
    }
}
