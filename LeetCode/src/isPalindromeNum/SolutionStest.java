package isPalindromeNum;

public class SolutionStest {
	public static void main(String args[]){
		int input=121;
		boolean output=new Solution().isPalindrome(input);
		System.out.println(output);
	}
}

class Solution {
    public boolean isPalindrome(int x) {
    	if(x<0){
    		return false;
    	}
    	int begin=0;
    	int end=0;
    	int div=1;
    	
    	while(x/div>9){
    		div=div*10;
    	}
    	
        while(x!=0){
        	begin=x%10;
        	end=x/div;
        	
        	if(begin!=end){
        		return false;
        	}else{
        		x=x-end*div;
        		x=x/10;
        		div=div/100;
        	}
        }
        return true;
        
    }
}

class Solution2{
	public boolean isPalindrome(int x) {
		if (x < 0) return false;
		  int div = 1;
		  while (x / div >= 10) {
		div *= 10; }
		  while (x != 0) {
		    int l = x / div;
		    int r = x % 10;
		    if (l != r) return false;
		    x = (x % div) / 10;
		div /= 100; }
		  return true;
	}
}
