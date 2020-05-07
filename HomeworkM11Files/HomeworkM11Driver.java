import java.util.*;

public class HomeworkM11Driver {

	public static void main(String[] args) {

		System.out.println("*****************************************************TESTING CLIENT VIEW SPLICE");
		QueueInterface<Integer> q1 = new LinkedQueue<Integer>();
		QueueInterface<Integer> q2 = new ArrayQueue<Integer>();
		// splicing two empty queues
		splice(q1, q2);
		System.out.println("q1 empty: \ttrue:" + q1.isEmpty());
		System.out.println("q2 empty: \ttrue:" + q2.isEmpty());
		
		// splice an empty queue to one with contents
		q1.enqueue(4);
		q1.enqueue(8);
		q1.enqueue(9);
		q1.enqueue(2);
		splice(q1, q2);
		System.out.println("\nq1 contains: \t4 8 9 2");
		System.out.print("\t\t");		
		((LinkedQueue<Integer>)q1).display();
		System.out.println("q2 empty: \ttrue:" + q2.isEmpty());
		
		// splice two queues with contents
		q2.enqueue(1);
		q2.enqueue(3);
		q2.enqueue(7);
		q2.enqueue(6);
		q2.enqueue(3);
		q2.enqueue(1);
		splice(q1, q2);
		System.out.println("\nq1 contains: \t4 8 9 2 1 3 7 6 3 1");
		System.out.print("\t\t");
		((LinkedQueue<Integer>)q1).display();
		System.out.println("q2 contains: \t1 3 7 6 3 1");
		System.out.print("\t\t");
		((ArrayQueue<Integer>)q2).display();

		// splice queue with contents to an empty queue
		q1.clear();
		q2.clear();
		q2.enqueue(1);
		q2.enqueue(3);
		q2.enqueue(7);
		q2.enqueue(6);
		q2.enqueue(3);
		q2.enqueue(1);
		splice(q1, q2);
		System.out.println("\nq1 contains: \t1 3 7 6 3 1");
		System.out.print("\t\t");
		((LinkedQueue<Integer>)q1).display();
		System.out.println("q2 contains: \t1 3 7 6 3 1");
		System.out.print("\t\t");
		((ArrayQueue<Integer>)q2).display();

		System.out.println("\n\n*****************************************************TESTING ARRAYQUEUE SPLICE");
		ArrayQueue<String> wordQueue1 = new ArrayQueue<String>(2);
		ArrayQueue<String> wordQueue2 = new ArrayQueue<String>(2);
		
		// splicing empty to empty
		wordQueue1.splice(wordQueue2);
		System.out.println("wordQueue1 empty: \ttrue:" + wordQueue1.isEmpty());
		
		System.out.println("wordQueue2 empty: \ttrue:" + wordQueue2.isEmpty());
		
		// splicing empty to a queue with contents
		wordQueue1.enqueue("a");
		wordQueue1.enqueue("b");
		wordQueue1.enqueue("c");
		wordQueue1.enqueue("a");
		wordQueue1.splice(wordQueue2);
		System.out.println("\nwordQueue1 contains: \ta b c a");
		System.out.print("\t\t\t");
		wordQueue1.display();
		System.out.println("wordQueue2 empty: \ttrue:" + wordQueue2.isEmpty());
		System.out.println(wordQueue1.getSecond());
		
		// splicing two queues with contents
		wordQueue2.enqueue("d");
		wordQueue2.enqueue("e");
		wordQueue2.enqueue("f");
		wordQueue2.enqueue("e");
		wordQueue1.splice(wordQueue2);
		System.out.println("\nwordQueue1 contains: \ta b c a d e f e");
		System.out.print("\t\t\t");
		wordQueue1.display();
		System.out.println(wordQueue1.getSecond());
		System.out.println("wordQueue2 contains: \td e f e");
		System.out.print("\t\t\t");
		wordQueue2.display();
		
		// splice queue with contents to an empty queue
		wordQueue1.clear();
		wordQueue2.clear();
		wordQueue2.enqueue("d");
		wordQueue2.enqueue("e");
		wordQueue2.enqueue("f");
		wordQueue2.enqueue("e");
		wordQueue1.splice(wordQueue2);
		System.out.println("\nwordQueue1 contains: \td e f e");
		System.out.print("\t\t\t");
		wordQueue1.display();
		System.out.println(wordQueue1.getSecond());
		System.out.println("wordQueue2 contains: \td e f e");
		System.out.print("\t\t\t");
		wordQueue2.display();
	
		// testing the "wrap around" nature of ArrayQueue
		ArrayQueue<Integer> aq1 = new ArrayQueue<Integer>(4);
		aq1.enqueue(99);
		aq1.enqueue(99);
		aq1.enqueue(99);
		aq1.enqueue(4);		
		aq1.dequeue(); // forcing the contents to wrap around the array
		aq1.dequeue();
		aq1.dequeue();
		aq1.enqueue(8);
		aq1.enqueue(9);
		aq1.enqueue(2);
		
		ArrayQueue<Integer> aq2 = new ArrayQueue<Integer>(4);
		aq2.enqueue(99);
		aq2.enqueue(99);
		aq2.enqueue(99);
		aq2.enqueue(1);
		aq2.dequeue(); // forcing the contents to wrap around the array
		aq2.dequeue();
		aq2.dequeue();
		aq2.enqueue(3);
		aq2.enqueue(7);
		aq2.enqueue(6);
		
		aq1.splice(aq2);
		System.out.println("\nq1 contains: \t4 8 9 2 1 3 7 6");
		System.out.print("\t\t");
		aq1.display();
		System.out.println("q2 contains: \t1 3 7 6");
		System.out.print("\t\t");
		aq2.display();
		
		System.out.println("\n\n*****************************************************TESTING LINKEDQUEUE SPLICE");
		LinkedQueue<Integer> lq1 = new LinkedQueue<Integer>();
		LinkedQueue<Integer> lq2 = new LinkedQueue<Integer>();
		
		
		// splicing empty to empty
		splice(lq1, lq2);
		System.out.println("lq1 empty: \ttrue:" + lq1.isEmpty());
		System.out.println("lq2 empty: \ttrue:" + lq2.isEmpty());
		
		// splicing empty to a queue with contents
		lq1.enqueue(4);
		lq1.enqueue(8);
		lq1.enqueue(9);
		lq1.enqueue(2);
		lq1.splice(lq2);
		System.out.println("\nlq1 contains: \t4 8 9 2");
		System.out.print("\t\t");
		lq1.display();
		System.out.println("lq2 still empty (and no exception thrown): true:" + lq2.isEmpty());
		System.out.println("queue1 firstNode 4:" + lq1.firstNode.data + " lastNode 2:" + lq1.lastNode.data);
		
		// splicing two queues with contents
		lq2.enqueue(1);
		lq2.enqueue(3);
		lq2.enqueue(7);
		lq2.enqueue(6);
		lq1.splice(lq2);
		System.out.println("\nq1 contains: \t4 8 9 2 1 3 7 6");
		System.out.print("\t\t");
		lq1.display();
		System.out.println("q2 contains: \t1 3 7 6");
		System.out.print("\t\t");
		lq2.display();
		System.out.println("queue1 firstNode 4:" + lq1.firstNode.data + " lastNode 6:" + lq1.lastNode.data + "   queue2 firstNode 1:" + lq2.firstNode.data + " lastNode 6:" + lq2.lastNode.data);
		
		// splice queue with contents to an empty queue
		lq1.clear();
		lq2.clear();
		lq2.enqueue(1);
		lq2.enqueue(3);
		lq2.enqueue(7);
		lq2.enqueue(6);
		lq1.splice(lq2);
		System.out.println("\nq1 contains: \t1 3 7 6");
		System.out.print("\t\t");
		lq1.display();
		System.out.println("q2 contains: \t1 3 7 6");
		System.out.print("\t\t");
		lq2.display();
		System.out.println("queue1 firstNode 1:" + lq1.firstNode.data + " lastNode 6:" + lq1.lastNode.data + "   queue2 firstNode 1:" + lq2.firstNode.data + " lastNode 6:" + lq2.lastNode.data);
		
		// changes to lq2 should not affect the spliced version of lq1
		lq2.dequeue();
		lq2.enqueue(12);
		System.out.println("\nq1 contains: \t1 3 7 6");
		System.out.print("\t\t");
		lq1.display();
		System.out.println("q2 contains: \t3 7 6 12");
		System.out.print("\t\t");
		lq2.display();
		System.out.println("queue1 firstNode 1:" + lq1.firstNode.data + " lastNode 6:" + lq1.lastNode.data + "   queue2 firstNode 3:" + lq2.firstNode.data + " lastNode 12:" + lq2.lastNode.data);

	}		

	// note: don't worry about generics here; i've omitted them and suppressed the
	// warnings so you can focus on the queue logic
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void splice(QueueInterface firstQueue, QueueInterface secondQueue) {
     	// make a copy the secondQueue
		QueueInterface copyQueue = new LinkedQueue<>();
		QueueInterface tempQueue = new LinkedQueue<>();
		while (!secondQueue.isEmpty()) {
			Object e = secondQueue.dequeue();
			copyQueue.enqueue(e);
			tempQueue.enqueue(e);
		}
		
		// traverse the secondQueue, and push each element to the back of the first queue
		while (!tempQueue.isEmpty()) {
			Object e = tempQueue.dequeue();
			firstQueue.enqueue(e);
		}
		
		// rebuild second queue
		while (!copyQueue.isEmpty()) {
			Object e = copyQueue.dequeue();
			secondQueue.enqueue(e);
		}
 	}


}