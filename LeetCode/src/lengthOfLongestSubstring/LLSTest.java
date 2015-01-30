package lengthOfLongestSubstring;

public class LLSTest {
	public static void main(String[] args){
		String input="wlrbbmqbhcdarzowkkyhiddqscdxrjmowfrxsjybldbefsarcbynecdyggxxpklorellnmpapqfwkhopkmco";
		int output=new Solution().lengthOfLongestSubstring(input);
		
		System.out.println(output);
	}
}

class Solution {
    public int lengthOfLongestSubstring(String s) {
    	boolean[] exist=new boolean[256];
        int maxLen=0;
        for(int i=0,j=0;j<s.length();j++){
        	while(exist[s.charAt(j)]==true){
        		exist[s.charAt(i)]=false;
        		i++;
        	}
        	
        	exist[s.charAt(j)]=true;
        	maxLen=Math.max(maxLen, j-i+1);
        	
        	
        }
        
        return maxLen;
    }
}
