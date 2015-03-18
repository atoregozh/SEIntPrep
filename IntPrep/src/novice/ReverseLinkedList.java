package novice;

public class ReverseLinkedList {
	
	class Node {
		Node next;
		int data;
		
		public Node(int d,Node n) {
			data = d;
			next =n;
		}
	}
	
	public Node reverseLLrecursive(Node head) {
		//https://www.youtube.com/watch?v=KYH83T4q6Vs&index=11&list=PL2_aWCzGMAwI3W_JlcBbtYTwiQSsOTa6P
		if(head.next==null) {
			return head;
		}
		Node remainingReverse = reverseLLrecursive(head.next);
		// gets called after base cases' if statement
		Node current = remainingReverse;
		Node last = current.next;  //current here is node before the last
		last.next = current; //make last node point to node before the last
		current.next = null;
	}
	
	public Node reverseLLiterative(Node head) {
		//https://www.youtube.com/watch?v=sYcOK51hl-A&list=PL2_aWCzGMAwI3W_JlcBbtYTwiQSsOTa6P&index=9
		Node prev = null;
		Node current = head;
		Node next =null;
		
		while(current!=null) {
			next = current.next; //save the next node
			current.next = prev; //the link of current is now pointing to previous
			prev=current; //update previous to be this node,i.e move by one
			current=next; //update current to be next node,i.e. move by one
		}
		head = prev; //because both current and next are pointing to null after while loop ends
		return head;
	}
	
	Node head;
	public void insert(int data) {
		Node newNode = new Node(data,null);
		newNode.next=head;
		head = newNode;
	}
	
	public void printLL() {
		Node temp = head; //why use head? because don't want to lose reference for head
		while (temp!=null) {
			System.out.print(temp.data);
			temp = temp.next;
		}
		System.out.println("");
	}
	
	public static void main(String[] args) {
		
	}

}
