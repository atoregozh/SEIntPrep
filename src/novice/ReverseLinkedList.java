package novice;

class Node {
	Node next;
	int data;
	
	public Node(int d,Node n) {
		data = d;
		next =n;
	}
	
	public String toString() {
		StringBuffer s = new StringBuffer();
		Node temp = this; //why use temp? because don't want to lose reference for head
		while (temp!=null) {
			s.append(temp.data);
			s.append("->");
			temp = temp.next;
		}
		return s.toString();
	}
}

public class ReverseLinkedList {
	
	public Node reverseLLrecursive(Node head) {
		//What is the reverse of null (the empty list)? null.
		if(head==null) {
			return null;
		}
		//What is the reverse of a one element list? the element.
		if(head.next==null) {
			return head;
		}
		
		Node nextElem = head.next;
		
		 // bug fix - need to unlink list from the rest or you will get a cycle
		head.next =null;
		
		// then we reverse everything from the second element on
		Node tail = reverseLLrecursive(nextElem);
		
		// then we join the two lists
		nextElem.next = head;
		
		return tail;
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
	
	public void insert(int data, Node head) {
		Node newNode = new Node(data,null);
		newNode.next=head;
		head = newNode;
	}
	
	
	
	public static void main(String[] args) {
		Node n3 = new Node(3, null);
		Node n2 = new Node(2, n3);
		Node n1 = new Node(1, n2);
		Node n0 = new Node(0, n1);
		System.out.println(n0);
		Node reversed = new ReverseLinkedList().reverseLLrecursive(n0);

		
	}

}
