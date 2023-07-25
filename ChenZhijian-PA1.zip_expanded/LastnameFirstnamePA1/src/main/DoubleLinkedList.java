/**
* This class is used to write a useful DoubleLinkedList 
* Known Bugs: <Explanation of Queue is full and no such file>
*
* @author Zhijian Chen
* <chen5340@brandeis.edu>
* <Mar 2th 2022>
* COSI 21A PA1
*/


package main;

public class DoubleLinkedList<T> {
	//public T lists;
	public Node<T> head;
	//public Node<T> tail;
	public Node<T> newNode;
	public Node<T> currentNode;
	public int size;
	
	
	/**
	 * This methods is to construct a empty double linked list.
	 * running time: constant
	 */
	public DoubleLinkedList() {
		head = null;
	}
	
	
	/**
	 * This method is to access the first node in the double linked list.
	 * @return return the first node.
	 * Running time: O of(n)
	 */
	public Node<T> getFirst() {
		if(head == null) {
			return null;
		}else {
			return head;
		}
		
	}
	
	
	/**
	 * This method is to add new node into the end of double linked list.
	 * @param element the element that need to be added.
	 * Running time: O of n
	 */
	public void insert(T element) {
		//tail.setNext(element);
		newNode = new Node<T>(element);
		//newNode.setData(element);
		if(head == null) {
			head = newNode;
			size++;
		}else{
			currentNode = head;
			while(currentNode.getNext() != null) {
				currentNode = currentNode.getNext();
			}
			currentNode.setNext(newNode);
			newNode.setPrev(currentNode);
			size++;
			//currentNode = tail;
			//tail.setNext(newNode);
			//tail = newNode;
		}
		
		
	}
	
	
	/**
	 * This method is used to delete a node in double linked list.
	 * @param key the key that used to find the node
	 * @return return the node or null if node not found.
	 * Running time: O of n
	 */
	public T delete(T key) {
		currentNode = head;
		boolean flag = false;
		if(size == 1) {
			if((currentNode.getData()).equals(key)) {
				head = null;
				flag = true;
				size--;
			}else {
				flag = false;
			}
		}else if(size == 2) {
			if((currentNode.getData()).equals(key)) {
				head = head.getNext();
				flag = true;
				size--;
			}else {
				currentNode = currentNode.getNext();
				if((currentNode.getData()).equals(key)) {
					head = currentNode;
					flag = true;
					size--;
				}else {
					flag = false;
				}
				
			}
		}else {
			if((currentNode.getData()).equals(key)) {
				head = head.getNext();
				flag = true;
				size--;
			}else {
				currentNode = currentNode.getNext();
				while(currentNode != null && flag == false) {
					if((currentNode.getData()).equals(key)) {
						Node<T> tmp1 = currentNode.getPrev();
						tmp1.setNext(currentNode.getNext());
				
						Node<T> tmp2 = currentNode.getNext();
						tmp2.setPrev(currentNode.getPrev());
						flag = true;
						size--;
					}else {
						currentNode = currentNode.getNext();
					}
				}
			}
			
			
		}
		
		if(flag == false) {
			return null;
		}else {
			return currentNode.getData();
		}
		
	}
	
	
	/**
	 * This method is used to find a node in the double linked list.
	 * @param key the key input is used to find the node
	 * @return return the founded node or null if not found
	 * Running time: O of n.
	 */
	public T get(T key) {
		currentNode = head;
		boolean flag = false;
		while(currentNode != null && flag == false) {
			System.out.println("148");
			if((currentNode.getData()).equals(key)) {
				
				return currentNode.getData();
			}else {
				currentNode = currentNode.getNext();
			}
		}
		return null;
	}
	
	
	/**
	 * This method is used to count the size of the double linked list.
	 * @return return the size of the list.
	 * Running time: constant
	 */
	public int size() {
		return size;
	}
	
	
	/**
	 * This method is used to convert the double linked list into a printable string.
	 * Running time: O of n
	 */
	@Override
	public String toString() {
		String s = "";
		currentNode = head;
		while(currentNode != null) {
			s += currentNode.toString();
		}
		return s;
	}
}
