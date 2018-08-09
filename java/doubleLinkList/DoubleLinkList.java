package dblLinkList;

import java.util.ArrayList;

public class DoubleLinkList<E> {//implements Comparator{
	private Node head;
	private Node tail;
	private int size = 0;
	
	private class Node{
		E element;
		Node next;
		Node prev;
		
		public Node(E e, Node n, Node p){
			element = e;
			next = n;
			prev = p;
		}
	}
	
	public void add(E e){
		if(size == 0){ //first element in the list
			//create a new node with prev and next set to null
			Node n = new Node(e, null, null);
			//set the head and tail to this new node 
			head = n;
			tail = n;
			//increase size by 1
			size++;
		} else {
			//create a new node with the next pointing to the existing head and prev to null
			Node n = new Node(e, null, tail);
			//update the tail's prev to point to the new node
			tail.next = n;
			//update the lists head to point to this new node
			tail = n;
			//increase size by 1
			size++;
		}
		System.out.println("Added '" + e.toString() + "' to the list");
		
	}
	
	public void addFirst(E e){
		if(size == 0){ //first element in the list
			//create a new node with prev and next set to null
			Node n = new Node(e, null, null);
			//set the head and tail to this new node 
			head = n;
			tail = n;
			//increase size by 1
			size++;
		} else {
			//create a new node with the next pointing to the existing head and prev to null
			Node n = new Node(e, head, null);
			//update the lists head to point to this new node
			head = n;
			//update the tail's prev to point to the new node
			tail.prev = n;
			//increase size by 1
			size++;
		}
		System.out.println("Added '" + e.toString() + "' to the front of the list");
	}
	
	public void addLast(E e){
		if(size == 0){
			//create a new node with prev and next set to null
			Node n = new Node(e, null, null);
			//set the head and tail to this new node 
			head = n;
			tail = n;
			//increase size by 1
			size++;			
		} else {
			//create a new node with the prev pointing to the existing tail and next to null
			Node n = new Node(e, null, tail);
			//update the tail's prev to point to the new node
			tail.next = n;
			//update the lists head to point to this new node
			tail = n;
			//increase size by 1
			size++;
		}
		System.out.println("Added '" + e.toString() + "' to the end of the list");
	}
	
	public boolean findNode(E e){
		if(size>0){
			Node n = head;
			while (n != null){
				if(n.element.toString().equals(e.toString())) return true;
				n = n.next;
			}
		}
		return false;
	}
	
	public Node getNode(E e){
		if(size>0){
			Node n = head;
			while (n != null){
				if(n.element.toString().equals(e.toString())) return n;
				n = n.next;
			}
		}
		return null;		
	}
	
	/**
	 * 
	 * @param e1 Add this element
	 * @param e2 After this element
	 */
	public void addAfter(E e1, E e2){
		Node tgt = getNode(e2);
		if(tgt != null){
			//create the new node passing in the element to add, the next from the node found in getNode as the next, the node found from getNode as the prev
			Node n = new Node(e1, tgt.next, tgt);
			tgt.next.prev = n;
			tgt.next = n;
			System.out.println("Added '" + e1.toString() + "' to the list after '" + e2.toString() + "'");
		} else {
			System.out.println("Did not add '" + e1.toString() + "' to the list. Could not find '" + e1.toString()+ "'");
		}
	}
	
	public void addBefore(E e1, E e2){
		Node tgt = getNode(e2);
		if(tgt != null){
			//create the new node passing in the element to add, the next from the node found in getNode as the next, the node found from getNode as the prev
			Node n = new Node(e1, tgt.next, tgt);
			tgt.prev.prev = n;
			tgt.prev = n;
			System.out.println("Added '" + e1.toString() + "' to the list after '" + e2.toString() + "'");
		} else {
			System.out.println("Did not add '" + e1.toString() + "' to the list. Could not find '" + e1.toString()+ "'");
		}
	}
	
	public void iterateForward(){
		if(size>0){
			Node n = head;
			while(n != null){
				System.out.println(n.element.toString());
				n = n.next;
			}
		}
	}
	
	public boolean remove(E e){
		Node tgt = getNode(e);
		if(tgt != null){
			tgt.prev.next = tgt.next;
			tgt.next.prev = tgt.prev;
			return true;
		} else {
			System.out.println("Node does not exist");
		}
		return false;
	}
	
	private ArrayList<E> getAsArray(){
		ArrayList<E> result = new ArrayList<>();
		Node n = head;
		while (n != null){
			result.add(n.element);
			n = n.next;
		}
		return result;
	}
	
	public void sortAsc(){
		ArrayList<E> temp = getAsArray();
		//clear the list
		head = null;
		tail = null;
		size = 0;
		Node current = null;
		E working = null;
		//iterate through the list
		for(E e : temp){
			//if size is 0 or 1, add the node
			if(size <=1 ){
				add(e);
			}
			//else (size is greater than 1) starting at the head (current) compare the working node's value against current and current next
			else {
				working = e;
				//check if working is less than head
				if(working.toString().compareTo(head.element.toString()) < 0){
					//if working is less than head, addFirst
					addFirst(working);
				}
				//check if working is greater than tail
				else if (working.toString().compareTo(tail.element.toString())>0){
					//if working is greater than tail, addLast
					addLast(working);
				} else {
				//else, while current is not null, iterate through the list
					current = head;
					while (current != null){
						//if working is greater than current and less than current next, add working after current
						if(working.toString().compareTo(current.element.toString())>0 && working.toString().compareTo(current.next.element.toString()) < 0){
							addAfter(working, current.element);
						}
						//if working is greater than current and current next, set current equal to current next and try again
						current = current.next;
					}
				}
			}
		}
	}
	
	/*
	 * This one needs some work
	 */
	public void sortDesc(){
		ArrayList<E> temp = getAsArray();
		//clear the list
		head = null;
		tail = null;
		size = 0;
		Node current = null;
		E working = null;
		//iterate through the list
		for(E e : temp){
			//if size is 0 add the node
			if(size == 0 ){
				add(e);
			}
			//else (size is greater than 1) starting at the head (current) compare the working node's value against current and current next
			else {
				working = e;
				//check if working is greater than head
				if(working.toString().compareTo(head.element.toString()) > 0){
					//if working is greater than head, addFirst
					addFirst(working);
				}
				//check if working is less than tail
				else if (working.toString().compareTo(tail.element.toString()) < 0){
					//if working is less than tail, addLast
					addLast(working);
				} else {
				//else, while current is not null, iterate through the list
					current = head;
					while (current != null){
						//if working is greater than current and less than current next, add working after current
						if(working.toString().compareTo(current.element.toString())<0 && working.toString().compareTo(current.next.element.toString()) > 0){
							addAfter(working, current.element);
						}
						//if working is greater than current and current next, set current equal to current next and try again
						current = current.next;
					}
				}
			}
		}		
	}
}
