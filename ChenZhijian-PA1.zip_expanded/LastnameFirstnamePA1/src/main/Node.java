/**
* This class is used to write a useful node
* Known Bugs: <none>
*
* @author Zhijian Chen
* <chen5340@brandeis.edu>
* <Mar 2th 2022>
* COSI 21A PA1
*/


package main;

public class Node<T> {
	public T node;
	public Node<T> nextNote;
	public Node<T> prevNote;
	public T data;
	
	
	/**
	 * This method is used to create a new node with given data.
	 * @param data data the need to be stored in node.
	 * Running time: constant
	 */
	public Node(T data) {
		this.node = data;
		this.data = data;
	}
	
	
	/**
	 * This method used to put data into the node
	 * @param data the data that need to be stored
	 * Running tiime: constant
	 */
	public void setData(T data) {
		node = data;
	}
	
	
	/**
	 * This method used to link the next node with current node
	 * @param next next note
	 * Running time: constant
	 */
	public void setNext(Node<T> next) {
		this.nextNote = next;
	}
	
	
	/**
	 * This method is used to link the previous node with current node
	 * @param prev previous node
	 * Running time: constant
	 */
	public void setPrev(Node<T> prev) {
		this.prevNote = prev;
	}
	
	
	/**
	 * This method is used to get the data that stored in next node
	 * @return the data stored in next node
	 * Runing time: constant
	 */
	public Node<T> getNext() {
		return nextNote;
	}
	
	
	/**
	 * This method is used to get the data that stored in the previous node
	 * @return the data stored in previous node
	 * Running time: constant
	 */
	public Node<T> getPrev() {
		return prevNote;
	}
	
	
	/**
	 * This method is used to get the data that stored in current node
	 * @return
	 * Running time: constant
	 */
	public T getData() {
		return data;
	}
	
	
	/**
	 * This method is used to convert the node in to printable String.
	 * Running time: constant
	 */
	@Override
	public String toString() {
		return node.toString();
	}
}
