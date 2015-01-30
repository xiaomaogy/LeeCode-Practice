package mergeTwoLists;


class ListNode{
	ListNode next;
	int val;
	ListNode(int val){
		this.val=val;
		this.next=null;
	}
	
	void add(int val){
		ListNode end=new ListNode(val);
		ListNode current=this;
		while(current.next!=null){
			current=current.next;
		}
		current.next=end;
	}
	
	void printList(){
		ListNode current=this;
		String output="";
		while(current!=null){
			output+="["+current.val+"]";
			current=current.next;
		}
		System.out.println(output);
	}
	
	
}

/*
class LinkedList{
	ListNode head;
	int listCount;
	
	
	LinkedList(){
		head=new ListNode(null);
		listCount=0;
	}
	
	void add(int data){
		ListNode end=new ListNode(data);
		ListNode current=head;
		while(current.next!=null){
			current=current.next;
		}
		
		current.next=end;
	}
	
	public String toString(){
		ListNode current=head.next;
		String output="";
		while(current!=null){
			output+="["+current.data.toString()+"]";
			current=current.next;
		}
		return output;
	}
}

*/


