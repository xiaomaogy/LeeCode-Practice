package swapNodeInPairs;

public class SolutionTest {
	public static void main(String args[]){
		ListNode l1=new ListNode(1);
		l1.add(2);
		l1.add(3);
		l1.add(4);
		
		l1.printList();
		ListNode l2=new Solution().swapPairs(l1);
		l2.printList();
		
	}
}

class Solution {
    public ListNode swapPairs(ListNode head) {
        
        ListNode p=head;
        ListNode l1=null;
        ListNode l2=null;
        
        
        if(p==null){
        	return null;
        }
        if(p.next==null){
        	return p;
        }
        
        ListNode dummyHead=new ListNode(0);
        dummyHead.next=p;
        ListNode previous=dummyHead;
        
        while(p!=null && p.next!=null){
        	l1=p;
        	l2=p.next;
        	
        	previous.next=l1.next;
        	l1.next=l2.next;
        	l2.next=l1;
        	p=p.next;
        	
        	previous=l1;
        	
        }
        
        if(p!=null){
        	previous.next=p;
        }
        
        return dummyHead.next;
    }
}


class ListNode{
	public ListNode next;
	public int val;
	public ListNode(int val){
		this.val=val;
		this.next=null;
	}
	
	void add(int val){
		ListNode newNode=new ListNode(val);
		ListNode current=this;
		while(current.next!=null){
			current=current.next;
		}
		current.next=newNode;
	}
	
	void printList(){
		String output="";
		ListNode current=this;
		while(current!=null){
			output=output+"["+current.val+"]";
			current=current.next;
		}
		System.out.println(output);
	}
}