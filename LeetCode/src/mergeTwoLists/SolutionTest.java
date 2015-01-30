package mergeTwoLists;

public class SolutionTest {
	public static void main(String[] args){
		ListNode l1=new ListNode(1);
		
		l1.add(2);
		l1.add(3);
		l1.add(7);
		
		ListNode l2=new ListNode(2);
		l2.add(3);
		l2.add(5);
		l2.add(7);
		l2.add(9);
		
		l1.printList();
		l2.printList();
		ListNode l3=new Solution().mergeTwoLists(l1, l2);
		l3.printList();
	}
		
}

class Solution{
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode l3;
		if(l1==null || l2==null){
			if(l1==null && l2==null){
				return l3=null;
			}
			if(l1==null){
				return l2;
			}
			if(l2==null){
				return l1;
			}
		}
        if(l1.val<l2.val){
        	l3=new ListNode(l1.val);
        	l1=l1.next;
        }else{
        	l3=new ListNode(l2.val);
        	l2=l2.next;
        }
        ListNode l3Dup=l3;
        
        while(l1!=null && l2!=null){
        	
        	if(l1.val<l2.val){
        		ListNode current=new ListNode(l1.val);
        		l1=l1.next;
        		l3Dup.next=current;
        		l3Dup=l3Dup.next;
        	}else{
        		ListNode current=new ListNode(l2.val);
        		l2=l2.next;
        		l3Dup.next=current;
        		l3Dup=l3Dup.next;
        	}
        }
        
        if(l1==null){
        	while(l2!=null){
        		ListNode current=new ListNode(l2.val);
        		l2=l2.next;
        		l3Dup.next=current;
        		l3Dup=l3Dup.next;
        		l3.printList();
        	}
        }else{
        	while(l1!=null){
        		ListNode current=new ListNode(l1.val);
        		l1=l1.next;
        		l3Dup.next=current;
        		l3Dup=l3Dup.next;
        		l3.printList();
        	}
        }
        
        return l3;
    }
}
