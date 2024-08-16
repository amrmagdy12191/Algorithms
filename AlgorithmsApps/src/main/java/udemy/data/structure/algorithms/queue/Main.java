package udemy.data.structure.algorithms.queue;

public class Main {

	public static void main(String[] args) {
		Queue queue = new Queue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		
		queue.dequeue();
		queue.dequeue();
		
		queue.printQueue();
		System.out.println("Length : " + queue.getLength());
	}

}
