package plusOne;

public class SolutionTest {
	public static void main(String args[]){
		int[] digits={9};
		int[] output=new int[digits.length];
		output=new Solution().plusOne(digits);
		for(int i=0;i<output.length;i++){
			System.out.println(output[i]);
		}
	}
}

class Solution {
    public int[] plusOne(int[] digits) {
    	int[] newdigits=new int[digits.length];
    	int up=0;
    	digits[digits.length-1]++;
    	for(int i=(digits.length-1);i>=0;i--){
    		if(digits[i]+up>9){
    			newdigits[i]=digits[i]+up-10;
    			up=1;
    		}
    		else{
    			newdigits[i]=digits[i]+up;
    			up=0;
    		}
    	}
    	
    	if(up==0){
    		return newdigits;
    	}else{
    		int[] newdigitsMore=new int[digits.length+1];
    		newdigitsMore[0]=1;
    		for(int i=0;i<newdigits.length;i++){
    			newdigitsMore[i+1]=newdigits[i];
    		}
    		return newdigitsMore;
    	}
    	
        	
        
    }
}
