package sait.sll.utility;

import java.util.LinkedList;

import javax.security.auth.kerberos.KerberosCredMessage;

import org.junit.internal.InexactComparisonCriteria;

public class SLL implements LinkedListADT {
	Node head;
	// Node tail;
	int size = 0;

	public SLL() {
		head = null;
		// tail = null;
	}

	public static void main(String[] args) {
		// LinkedList numbers = new LinkedList();

	}

	@Override
	public boolean isEmpty() {
		if (size == 0) {

			return true;
		}

		return false;
	}

	@Override
	public void clear() {
		head = null;
		size = 0;
	}

	// last Node
	@Override
	public void append(Object data) {

		if (size == 0) { // had.getNext == null (but had some errors)
			prepend(data);
		} else {
			Node curNode = head;

			while (curNode.getNext() != null) {
				curNode = curNode.getNext();
			}

			curNode.setNext(new Node(data));
			size++;

		}
	}

	// first Node
	@Override
	public void prepend(Object data) {

		Node node = new Node(data);
		if (size == 0) {
			head = node;
		} else {
			node.setNext(head);
			head = node;
		}
		size++;
	}

	// middle
	@Override
	public void insert(Object data, int index) throws IndexOutOfBoundsException {

		if (index < 0 || index > size)
			throw new IndexOutOfBoundsException();

		if (index == 0)
			prepend(data);
		else if (index == size)
			append(data);
		else {
			Node curNode = head;
			for (int i = 0; i < index - 1; i++) {
				curNode = curNode.getNext();

				Node newNode = new Node(data);
				newNode.setNext(curNode.getNext());
				curNode.setNext(newNode);
				size++;
			}

		}
	}

	@Override
	public void replace(Object data, int index) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		Node curNode = head;

		for (int i = 0; i < index - 1; i++) {
			curNode = curNode.getNext();
		}
		Node newNode = new Node(data);
		newNode.setNext(curNode.getNext().getNext());
		curNode.setNext(newNode);

	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public void delete(int index) throws IndexOutOfBoundsException {
		if (size == 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		Node curNode;
		// First node delete
		if (index == 0) {
			curNode = head; // head = 1st element
			head = curNode.getNext();
			curNode.setNext(null);
		}
		// Middle or Last node delete
		else {
			Node preNode = head;
			for (int i = 1; i < index; i++) {
				preNode = preNode.getNext();
			}
			curNode = preNode.getNext();
			// Last node delete
			if (index == size - 1) {
				preNode.setNext(null);
			}
			// Middle node delete
			else {
				preNode.setNext(curNode.getNext());
				curNode.setNext(null);
			}
		}

		size--;
	}

	// index -> search object read return
	@Override
	public Object retrieve(int index) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		Node curNode = head;

		for (int i = 0; i < index; i++) {
			curNode = curNode.getNext();
		}

		// System.out.println("index : " + index + "data : " + curNode.getData());
		return curNode.getData();
	}

	// same data -> index return
	@Override
	public int indexOf(Object data) {
		Node temp = head;
		int index = 0;

		while (temp.getData() != data) {
			temp = temp.getNext();
			index++;

			if (temp == null)
				return -1;
		}
		return index;

	}

	// data exist -> true / false
	@Override
	public boolean contains(Object data) {
		Node curNode = head;

		while (curNode.getNext() != null) {
			if (curNode.getData() == data) {
				return true;
			}
			curNode = curNode.getNext();
		}
		return false;
	}
}
