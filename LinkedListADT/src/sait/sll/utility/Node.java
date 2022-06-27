package sait.sll.utility;

public class Node{
    private Object data;
    private Node next;
    
    public Node(Object input) {
        this.data = input;
        this.next = null;
    }

    public String toString(){
        return String.valueOf(this.data);
    }

	/**
	 * @return the data
	 */
	public Object getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(Object data) {
		this.data = data;
	}

	/**
	 * @return the next
	 */
	public Node getNext() {
		return next;
	}

	/**
	 * @param next the next to set
	 */
	public void setNext(Node next) {
		this.next = next;
	}
}