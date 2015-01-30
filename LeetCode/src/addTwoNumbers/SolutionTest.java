package addTwoNumbers;


public class SolutionTest {
	public static void main(String args[]){
ListNode l1=new ListNode(2);
		
		l1.add(4);
		l1.add(5);
		
		ListNode l2=new ListNode(5);
		l2.add(6);
		l2.add(4);
		l2.add(9);
		
		l1.printList();
		l2.printList();
		ListNode l3=new Solution().addTwoNumbers(l1, l2);
		l3.printList();
	}
}

class Solution{
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead=new ListNode(0);
        ListNode p=dummyHead;
        
        int add1=0;
        int sum=0;
        
        while(l1!=null && l2!=null){
        	if(l1.val+l2.val+add1<10){
        		sum=l1.val+l2.val+add1;
        		add1=0;
        	}else{
        		sum=l1.val+l2.val+add1-10;
        		add1=1;
        	}
        	ListNode current=new ListNode(sum);
        	
        	l1=l1.next;
        	l2=l2.next;
        	p.next=current;
        	p=p.next;
        	
        }
        
        if(add1==1 && l1==null && l2==null){
        	ListNode current=new ListNode(1);
        	p.next=current;
        }
        
        if(l1!=null){
        	p.next=l1;
        	l1.val=l1.val+add1;
        	while(l1.val>9){
        		l1.val=l1.val-10;
        		if(l1.next==null){
        			ListNode current=new ListNode(1);
        			l1.next=current;
        		}else{
        			l1=l1.next;
        			l1.val++;
        		}
        	}
        	
        }
        
        if(l2!=null){
        	p.next=l2;
        	l2.val=l2.val+add1;
        	while(l2.val>9){
        		l2.val=l2.val-10;
        		if(l2.next==null){
        			ListNode current=new ListNode(1);
        			l2.next=current;
        		}else{
        			l2=l2.next;
        			l2.val++;
        		}
        	}
        }
        
        return dummyHead.next;
    }
}

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
