package com.linkedlist;

public class Loop_FindLoopInLinkedList {

	public static void main(String[] args) {

		Node one = new Node(10);
		Node two = new Node(20);
		Node three = new Node(30);
		Node four = new Node(40);
		Node five = new Node(50);

		one.next = two;
		two.next = three;
		three.next = four;
		four.next = five;
		five.next = three;

		if (findLoop(one))
			System.out.println("Loop found");
		else
			System.out.println("No loop found");

	}

	static boolean findLoop(Node head) {
		Node faster = head, slower = head;

		while (null != slower && null != faster && faster.next != null) {
			slower = slower.next;
			faster = faster.next.next;

			if (slower == faster) {
				return true;
			}
		}
		return false;
	}

	static class Node {

		Node next;
		int data;

		Node(int data) {
			this.data = data;
			next = null;
		}
	}
}
