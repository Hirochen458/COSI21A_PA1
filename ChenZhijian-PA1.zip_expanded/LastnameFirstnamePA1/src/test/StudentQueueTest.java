package test;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

import main.Queue;

class StudentQueueTest {
	Queue q;

	@Test
	void initTest() throws Exception{
		q = new Queue(10);
		//assertEquals(null, q.front());
		assertEquals(0, q.size());
	}
	
	@Test
	void enqueue() throws Exception{
		q = new Queue(20);
		q.enqueue(10);
		assertEquals(10, q.front());
		assertEquals(1, q.size());
	}
	
	@Test
	void dequeue() throws Exception{
		q = new Queue(20);
		q.enqueue(10);
		q.enqueue(20);
		q.enqueue(30);
		assertEquals(10, q.front());
		assertEquals(3, q.size());
		
		q.dequeue();
		
		assertEquals(20, q.front());
		assertEquals(2, q.size());
		
		q.dequeue();
		
		assertEquals(30, q.front());
		assertEquals(1, q.size());
	}
	

}
