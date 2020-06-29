package com.linkedlist;

public class ReverseSinglyLinkedList {

	Node head;

	public static void main(String[] args) {

		ReverseSinglyLinkedList rList = new ReverseSinglyLinkedList();
		rList.push(10);
		rList.push(20);
		rList.push(30);
		rList.push(40);
		rList.push(50);

		rList.print(rList.head);

		System.out.println("\n...........\n");

		rList.reverse(rList.head);

		rList.print(rList.head);
	}

	public void reverse(Node head) {
		Node current = head;
		Node prev = null;
		Node next = null;
		
		while (null != current) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		
		this.head = prev;
	}

	private void push(int data) {
		Node n = new Node(data);
		n.next = head;
		head = n;
	}

	private void print(Node node) {
		while (node != null) {
			System.out.print(node.data);
			node = node.next;

			if (null != node) {
				System.out.print(", ");
			}
		}
	}

	static class Node {
		Node next;
		int data;

		Node(int data) {
			next = null;
			this.data = data;
		}
	}
}
