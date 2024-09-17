public class NormalQueue {
    int front;
    int rear;
    int[] listOfElements;

    NormalQueue(int size) {
        front = 0;
        rear = -1;
        listOfElements = new int[size];
    }

    public void enqueue(int element) {
        if(rear == listOfElements.length) {
            System.out.println("The array is full");
            return;
        }
        rear++;
        listOfElements[rear] = element;
    }

    public void dequeue() {
        if(rear == -1 ){
            System.out.println("The array is empty");
        }
        front++;
    }

    public void printElements() {
        StringBuilder sb = new StringBuilder("The array contains: \n");
        for(int i=0;i<listOfElements.length; i++) {
            sb.append(listOfElements[i]);
        }
        System.out.println(sb);
    }

    public static void main(String[] args) {
        NormalQueue queue = new NormalQueue(10);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.printElements();
        queue.dequeue();
        queue.dequeue();
        queue.printElements();
    }

}
