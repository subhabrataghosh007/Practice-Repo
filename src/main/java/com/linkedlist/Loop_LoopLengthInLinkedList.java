package com.linkedlist;

public class Loop_LoopLengthInLinkedList {

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

		System.out.println("Loop length :" + findLoop(one));

	}

	static int findLoop(Node head) {
		Node faster = head, slower = head;

		while (null != slower && null != faster && faster.next != null) {
			slower = slower.next;
			faster = faster.next.next;

			if (slower == faster) {
				return findLength(slower);
			}
		}
		return 0;
	}

	static int findLength(Node node) {

		int count = 1;
		Node temp = node;

		while (temp.next != node) {
			count++;
			temp = temp.next;
		}
		return count;
	}

	static class Node {

		Node next;
		int data;

		Node(int data) {
			this.data = data;
			next = null;
		}
		
		public String toString() {
			return data+"";
		}
	}
}
