package twoSum;
import java.util.*;


public class twoSumFunc{
	public int[] twoSum2(int[] numbers, int target){
		Map<Integer,Integer> map=new HashMap<Integer, Integer>();
		for(int i=0;i<numbers.length;i++){
			int x=numbers[i];
			if(map.containsKey(target-x)){
				return new int[]{map.get(target-x)+1,i+1};
			}
			map.put(x, i);
		}
		
		throw new IllegalArgumentException("No two sum exist 2");
	}
	public int[] twoSum(int[] numbers, int target){
		quicksort(numbers,0,numbers.length-1);
		for(int i=0;i<numbers.length;i++){
			//System.out.println(numbers[i]);
		}
		for(int i=0;i<numbers.length;i++){
			int position=bsearch(numbers,target-numbers[i],i+1,numbers.length-1);
			if(position!=-1){
				int[] positions={i+1,position+1};
				return positions;
			}
		}
		
		throw new IllegalArgumentException("No such sum exist");
	}
	
	private void quicksort(int[] A,int p, int r){
		if(p<r){
			int q=partition(A,p,r);
			quicksort(A,p,q-1);
			quicksort(A,q+1,r);
		}
		//throw new IllegalArgumentException("The quicksort has encountered an error");	
	}
	
	private int partition(int[] A,int p,int r){
		int x=A[r];
		int i=p-1;
		for(int j=p;j<=r-1;j++){
			if(A[j]<=x){
				i=i+1;
				exchange(A,i,j);
			}
		}
		exchange(A,i+1,r);
		return i+1;
	}
	
	private void exchange(int[] A,int i,int j){
		int temp=A[i];
		A[i]=A[j];
		A[j]=temp;
	}
	
	private int bsearch(int[] A, int key, int start, int end){
		int L=start;
		int R=end;
		if(L<R){
			int M=(L+R)/2;
			if(A[M]==key){
				return M;
			}
			if(A[M]<key){
				return bsearch(A,key,M+1,R);
			}
			else{
				return bsearch(A,key,L,M-1);
			}
		}
		
		if(L==R){
			if(A[L]==key){
				return L;
			}
		}
		return -1;
	}
	
	
	
}


