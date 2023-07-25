/**
* This class is used to write a useful queue with a array
* Known Bugs: <Explanation of Queue is full and no such file>
*
* @author Zhijian Chen
* <chen5340@brandeis.edu>
* <Mar 2th 2022>
* COSI 21A PA1
*/


package main;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class Queue<T> {

	public T[] q;
	public int head;
	public int tail;
	public int numEntries;
	
	
	
	/**
	 * This method is used to create a empty queue with given capacity.
	 * @param capacity the capacaity that the quene can have.
	 * Running time: constant
	 */
	@SuppressWarnings("unchecked")
	public Queue(int capacity) {
		this.q = (T[]) new Object[capacity];
		head = 0;
		tail = 0;
		numEntries = 0;
		/*
		int i = 0;
		while (i < q.length) {
			if(q[i] != null) {
				i++;
			}
		}
		numEntries = i;
		*/
		
	}
	
	
	/**
	 * This method is used to add the element in the last position of queue
	 * @param element element that need to be added
	 * @throws Exception throw exception if the last position is full.
	 * Running time: O of n
	 */
	public void enqueue(T element) {
		if(q[q.length-1] != null) {
			System.out.println("current queue is full");
			//throw new QueueIsFullException();
			
		}//else if(head == tail & tail == 0){
			
		else if(tail == q.length - 1) {
			tail = 0;
			q[tail] = element;
			tail++;
			numEntries++;
		}else {
			q[tail] = element;
			tail++;
			numEntries++;
		}
		
	}
	
	
	/**
	 * This method is used to delete the first element in the queue
	 * @throws Exception throw exception if the first element is null
	 * Running time:O of n
	 */
	public void dequeue() throws Exception {
		//System.out.println("98");
		if(q[head] == null) {
			throw new NoSuchElementException();
		}else if(head == q.length - 1){
			//System.out.println("hello");
			head = 0; 
			q[head] = null;
			head++;
			numEntries--;
		}else {
			//System.out.println("108");
			q[head] = null;
			head++;
			numEntries = numEntries - 1;
		}	
	}
	
	
	/**
	 * This method is used to access the first element in the queue
	 * @return the first element
	 * Running time: O of n
	 */
	public T front() throws Exception {
		if(q[head] == null) {
			throw new NoSuchElementException();
		}else {
			return q[head];
		}
	}
	
	/**
	 * This method is used to count the number of element in the queue
	 * @return the number of element in the queue
	 * Running time: constant
	 */
	public int size() {
		return numEntries;
	}
	
	
	/**
	 * This method is used to change the array to string and can be print out.
	 * Running time: O of n
	 */
	@Override
	public String toString() {
		return Arrays.toString(q);
	}
}
