package copyListWithRandomPointer;

import java.util.HashMap;
import java.util.Map;


public class SolutionTest {
	public static void main(String args[]){
		RandomListNode l1=new RandomListNode(1);
		l1.add(2);
		l1.add(3);
		l1.add(4);
		
		l1.printList();
	}
}


class Solution{
	public RandomListNode copyRandomList(RandomListNode head){
		
		RandomListNode dummyHead=new RandomListNode(0);
		RandomListNode newList=dummyHead;
		RandomListNode oldList=head;
		
		Map<RandomListNode,RandomListNode> map=new HashMap<>();
		
		
		
		while(oldList!=null){
			
			RandomListNode current=new RandomListNode(oldList.label);
			newList.next=current;
			map.put(oldList, newList.next);
			
			newList=newList.next;
			oldList=oldList.next;
		}
		
		newList=dummyHead.next;
		oldList=head;
		
		
		while(newList!=null){
			newList.random=map.get(oldList.random);
			newList=newList.next;
			oldList=oldList.next;
		}
		
		return dummyHead.next;
	}
}

class RandomListNode{
	int label;
	RandomListNode next;
	RandomListNode random;
	RandomListNode(int x){
		this.label=x;
	}
	
	void add(int label){
		RandomListNode end=new RandomListNode(label);
		RandomListNode current=this;
		while(current.next!=null){
			current=current.next;
		}
		current.next=end;
	}
	
	void printList(){
		RandomListNode current=this;
		String output="";
		while(current!=null){
			output+="["+current.label+"]";
			current=current.next;
		}
		System.out.println(output);
	}
}
