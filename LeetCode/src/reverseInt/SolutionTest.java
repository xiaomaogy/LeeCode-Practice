package reverseInt;

public class SolutionTest {
	public static void main(String args[]){
		int input=-321310;
		
		//int output=new Solution().reverse(input);
		//System.out.println(output);
		int output2=new Solution2().reverse(input);
		System.out.println(output2);
	}
}

class Solution {
    public int reverse(int x) {
    	String intString=Integer.toString(x);
    	int neg=1;
    	if(intString.charAt(0)=='-'){
    		neg=-1;
    	}
    	StringBuilder revIntStringBuilder=new StringBuilder(intString);
    	if(neg==-1){
    		revIntStringBuilder.delete(0, 1);
    	}
    	String revIntString=revIntStringBuilder.reverse().toString();
    	if(revIntString.length()>1){
    		String revIntStringD=revIntString.substring(0,revIntString.length()-1);
        	int ret=Integer.parseInt(revIntStringD);
        	if(ret>214748364 || ret<-214748364){
        		return 0;
        	}
    	}
    	
    	int revInt=Integer.parseInt(revIntString);
    	return neg*revInt;
    }
}

class Solution2{
	public int reverse(int x){
		int ret=0;
		while(x!=0){
			if(ret>214748364 || ret<-214748364){
				return 0;
			}
			ret=ret*10+x%10;
			x=x/10;
		}
		
		return ret;
	}
		
}
