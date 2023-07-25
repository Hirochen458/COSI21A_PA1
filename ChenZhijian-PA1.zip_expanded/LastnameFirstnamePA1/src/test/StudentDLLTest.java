package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.DoubleLinkedList;

import main.Node;
//import main.Queue;

class StudentDLLTest {
	DoubleLinkedList<Integer> d;
	Node<Integer> n;
	Node<Integer> nk;
	Node<Integer> ns;
	Node<Integer> nl;
	

	@Test
	void initTest() {
		d = new DoubleLinkedList<Integer>();
		
		assertEquals(null, d.getFirst());
		assertEquals(0, d.size());
		
	}
	
	@Test
	void getFirstInsert() {
		d = new DoubleLinkedList<Integer>();
		Integer i = 10;
		n = new Node<Integer>(i);
		
		d.insert(i);
		
		//Integer x = 10;
		
		System.out.println(d.getFirst().getData());
		
		assertEquals(10,  d.getFirst().getData());
		assertEquals(10, n.getData());
		assertEquals(1, d.size());
		
	
	}
	
	@Test 
	void getFirstDelete() {
		d = new DoubleLinkedList<Integer>();
		Integer i = 10;
		Integer j = 20;
		Integer k = 30;
		
		//String i = "i";
		//String j = "j";
		//String k = "k";
		
		n = new Node<Integer>(i);
		d.insert(i);
		
		ns = new Node<Integer>(j);
		d.insert(j);
		
		nk = new Node<Integer>(k);
		d.insert(k);
		
		
		
		assertEquals(i, d.getFirst().getData());
		assertEquals(3, d.size());
		
		d.delete(i);
		
		assertEquals(j, d.getFirst().getData());
		//assertEquals(3, d.size());
	}
	
	@Test
	void getFirst() {
		d = new DoubleLinkedList<Integer>();
		Integer i = 10;
		
		Integer k = 30;
	
		Integer j = 20;
		
		Integer l = 40;
		
		
		n = new Node<Integer>(i);
		d.insert(i);
		
		ns = new Node<Integer>(j);
		d.insert(j);
		
		nk = new Node<Integer>(k);
		d.insert(k);
		
		nl = new Node<Integer>(l);
		d.insert(l);
		
		//n = new Node(k);
		//d.insert(n);
		
		
		
		assertEquals(i, d.getFirst().getData());
		assertEquals(4, d.size());
		
		d.delete(i);
		
		assertEquals(j, d.getFirst().getData());
		assertEquals(3, d.size());
		
		d.delete(k);
		assertEquals(j, d.getFirst().getData());
		assertEquals(2, d.size());
		assertEquals(l, d.get(l));
	}

}
