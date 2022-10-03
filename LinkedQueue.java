/**
 * LinkedQueue represents a linked implementation of a queue.
 * 
 * @author Edwin Or
 */

public class LinkedQueue<T> implements QueueADT<T>
{
	private int count;
	private LinearNode<T> front, rear;

	/**
	 * Creates an empty queue.
	 */
	public LinkedQueue() {
		count = 0;
		front = rear = null;
	}

	/**
	 * Adds the specified element to the rear of this queue.
	 *
	 * @param element  the element to be added to the rear of this queue
	 */
	public void enqueue (T element) {
		LinearNode<T> newNode = new LinearNode<T>(element);
		if (front != null) {
			rear.setNext(newNode);
		} else {
			front = newNode;
		}
		
		rear = newNode;
		count += 1;
	}

	/**
	 * Removes the element at the front of this queue and returns a
	 * reference to it. Throws an EmptyCollectionException if the
	 * queue is empty.
	 *
	 * @return                           the element at the front of this queue
	 * @throws EmptyCollectionException  if an empty collection exception occurs
	 */
	public T dequeue() throws EmptyCollectionException {
		T temp;
		
		if (front == null) {
			throw new EmptyCollectionException("Queue is empty.");
		}
		
		temp = front.getElement();
		if (count == 1) {
			front = rear = null;
		} else {
			front = front.getNext();
		}
		
		count -= 1;
		return temp;
	}

	/**
	 * Returns a reference to the element at the front of this queue.
	 * The element is not removed from the queue.  Throws an
	 * EmptyCollectionException if the queue is empty.  
	 *
	 * @return                            a reference to the first element in
	 *                                    this queue
	 * @throws EmptyCollectionsException  if an empty collection exception occurs
	 */
	public T first() throws EmptyCollectionException {
		if (front == null) {
			throw new EmptyCollectionException("Queue is empty.");
		}
		
		T temp = front.getElement();
		return temp;
	}

	/**
	 * Returns true if this queue is empty and false otherwise. 
	 *
	 * @return  true if this queue is empty and false if otherwise
	 */
	public boolean isEmpty() {
		if (count == 0) {
			return true;
		}
		return false;
	}

	/**
	 * Returns the number of elements currently in this queue.
	 *
	 * @return  the integer representation of the size of this queue
	 */
	public int size() {
		return count;
	}


}
