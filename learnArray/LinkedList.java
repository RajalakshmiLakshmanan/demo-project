package learnArray;

public class LinkedList {
	private Node head;
	private Node tail;
	private int length;
	
	class Node{
		int value;
		Node next;
		
		public Node(int value) {
			this.value = value;
			
		}
		
	}
	
	public LinkedList (int value) {
		Node newNode = new Node(value);
		head = newNode;
		tail = newNode;
		length = 1;
		
	}
	
	public void getHead() {
		if(head == null) {
			System.out.println("head is empty");
			
		}else {
		System.out.println("head: "+head.value);
		}
		
	}
	public void getTail() {
		if(tail == null) {
			System.out.println("tail is empty");
			
		}else {
		System.out.println("tail: "+tail.value);
		}
		
	}
	
	
	public void getLength() {
		
		System.out.println("length of the linked list: "+length);
		
	}
	
	public void printList() {
		Node temp = head;
		while(temp!=null){
		  System.out.println("List: "+temp.value);
		  temp = temp.next;	
		  
		}
		
	}
	
	public void append(int value) {
		Node newNode = new Node(value);
		if(length == 0) {
			head = newNode;
			tail = newNode;
			
		}else {
		   tail.next= newNode;
		   tail = newNode;
		
		}
		length++;
	}
	
	public Node removeLast() {
		Node temp = head;
		Node pre = head;
		if(length == 0) {
			return null;
		}
		
		while(temp.next!=null) {
			pre = temp;
			temp= temp.next;
			
		}
		 tail = pre;
		 tail.next = null;
		length--;
		if(length ==0) {
			head = null;
			tail = null;
			
		}
		return temp;
	}
	
	public void prepand(int value) {
		Node newNode = new Node(value);
		if(length ==0) {
			head=newNode;
			tail = newNode;
			
		}else {
		newNode.next = head;
		head = newNode;
		}
		length++;
	}
	
	public Node removeFirst() {
		
		if(length == 0) {
			return null;
		}
		Node temp =head;
		head =head.next;
		length--;
		if(length ==0) {
			tail=null;
		}
		return temp;
		
	}
	
	public Node get(int index)
	{
		if(index < 0 || index >=length) {
			return null;
		}
		Node temp = head;
		for(int i = 0; i< index; i++) {
			temp = temp.next;
			
		}
		return temp;
		
	}
	
	public boolean set(int index, int value) {
	       Node temp = get(index);
	   //    System.out.println("check: "+temp.value);
	       if(temp!=null) {
	    	   temp.value = value;
	    	   return true;
	       }
	       return false;
	}
	
	public boolean insert(int index, int value) {
		if(index <0 || index > length) {
			return false;
		}
		if(index == 0) {
			prepand(value);
			return true;
		}
		if(index == length) {
			append(value);
			return true;
		}
		Node newNode = new Node(value);
		Node temp = get(index-1);
		newNode.next= temp.next;
		temp.next= newNode;
		length++;
		return true;
	}
	
	public Node remove(int index) {
		if(index <0 || index >= length) {
			return null;
			
		}
		if(index ==0) {
			return removeFirst();
			
		}
		if(index == length-1) {
			return removeLast();
		}
		Node prev = get(index-1);
		Node temp = prev.next;
		prev.next = temp.next;
		temp.next = null;
		return temp;
		
	}
}
