package mergeKSortedLists;

import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;


public class SolutionTest {
	public static void main(String args[]){
		ListNode l1=new ListNode(6);
		l1.add(11);
		l1.add(21);
		l1.add(31);
		
		ListNode l2=new ListNode(4);
		l2.add(22);
		l2.add(32);
		l2.add(42);
		
		ListNode l3=new ListNode(3);
		l3.add(21);
		l3.add(37);
		l3.add(48);
		
		
		
		
		l1.printList();
		l2.printList();
		l3.printList();
		
		List<ListNode> lists=new ArrayList<ListNode>();
		lists.add(l1);
		lists.add(l2);
		lists.add(l3);
		
		SolutionDivAndConquer s=new SolutionDivAndConquer();
		SolutionHeap s2=new SolutionHeap();
		
		//ListNode l4=s.mergeKLists(lists);
		ListNode l5=s2.mergeKLists(lists);
		
		//l4.printList();
		l5.printList();
	}
}
/*
class Solution {
    public ListNode mergeKLists(List<ListNode> lists) {
        int len=lists.size();
        
        int[] orderOfIndex=new int[len];
        
        ListNode p[]=new ListNode[len];
        
        for(int i=0;i<len;i++){
        	orderOfIndex[i]=i;
        	p[i]=(ListNode) lists.get(i);
        }
        
        
        
        
        return new ListNode(1);
    }
    
    
    
    public void mergeSort(int[] unsorted){
    	int p=0;
    	int r=unsorted.length-1;
    	doMergeSort(p,r,unsorted);
    	
    }
    
    public void doMergeSort(int p,int r,int[] unsorted){
    	
    	if(p<r){
    		int q=(p+r)/2;
    		doMergeSort(p,q,unsorted);
    		doMergeSort(q+1,r,unsorted);
    		doMerge(p,q,r,unsorted);
    	}
    }
    
    public void doMerge(int p,int q,int r,int[] unsorted){
    	int n1=q-p+1;
    	int n2=r-q;
    	int n=r-p+1;
    	int i,j,k;
    	
    	int[] l1=new int[n1+1];
    	for(i=0;i<n1;i++){
    		l1[i]=unsorted[p+i];
    	}
    	l1[n1]=Integer.MAX_VALUE;
    	
    	int[] l2=new int[n2+1];
    	for(j=0;j<n2;j++){
    		l2[j]=unsorted[q+1+j];
    	}
    	l2[n2]=Integer.MAX_VALUE;
    	
    	
    	
    	for(i=0,j=0,k=p;k<p+n;k++){
    		if(l1[i]<l2[j]){
    			unsorted[k]=l1[i++];
    		}else{
    			unsorted[k]=l2[j++];
    		}
    	}
    	
    	
    }
}
*/

class SolutionHeap{
	private static final Comparator<ListNode> listComparator=new Comparator<ListNode>(){
		@Override
		public int compare(ListNode x, ListNode y){
			return x.val-y.val;
		}
	};
	
	
	public ListNode mergeKLists(List<ListNode> lists){
		if(lists.isEmpty()){
			return null;
		}
		
		PriorityQueue<ListNode> queue=new PriorityQueue<ListNode>(lists.size(),listComparator);
		
		for(ListNode node:lists){
			if(node!=null){
				queue.add(node);
			}
		}
		
		ListNode dummyHead=new ListNode(0);
		
		ListNode p=dummyHead;
		
		while(!queue.isEmpty()){
			ListNode node=queue.poll();
			p.next=node;
			p=p.next;
			if(p.next!=null){
				queue.add(p.next);
			}
		}
		
		return dummyHead.next;
	}
	
	
	
	
}

class SolutionDivAndConquer{
	public ListNode mergeKLists(List<ListNode> lists){
		if(lists.isEmpty()){
			return null;
		}
		
		int begin=0;
		int end=lists.size()-1;
		
		while(end>0){
			begin=0;
			while(begin<end){
				lists.set(begin, merge2Lists(lists.get(begin),lists.get(end)));
				begin++;
				end--;
			}
		}
		
		return lists.get(0);
		
	}
	
	public ListNode merge2Lists(ListNode l1,ListNode l2){
		ListNode dummyHead=new ListNode(0);
		ListNode p=dummyHead;
		
		while(l1!=null && l2!=null){
			if(l1.val<l2.val){
				ListNode current=new ListNode(l1.val);
				p.next=current;
				p=p.next;
				l1=l1.next;
			}else{
				ListNode current=new ListNode(l2.val);
				p.next=current;
				p=p.next;
				l2=l2.next;
			}
		}
		
		while(l1!=null){
			ListNode current=new ListNode(l1.val);
			p.next=current;
			p=p.next;
			l1=l1.next;
		}
		
		while(l2!=null){
			ListNode current=new ListNode(l2.val);
			p.next=current;
			p=p.next;
			l2=l2.next;
		}
		
		return dummyHead.next;
	}
	
	
	
}



class ListNode{
	ListNode next;
	int val;
	public ListNode(int val){
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