package twoSum;

public class bsearchtest {
	public static void main(String args[]){
		System.out.println("This is a test program for binary search");
		int[] numbers={0,1,1,0,3};
		int target=0;
		twoSumFunc t=new twoSumFunc();
		
		//int[] result=t.twoSum(numbers, target);
		int[] result2=t.twoSum2(numbers,target);
		
		
		System.out.println(result2[0]);
		System.out.println(result2[1]);
	}
	
	
}



