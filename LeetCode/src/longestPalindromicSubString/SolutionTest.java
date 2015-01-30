package longestPalindromicSubString;

public class SolutionTest {
	public static void main(String[] args){
		String input="afedefawfewa";
		String output=new Solution().longestPalindrome(input);
		System.out.println(output);
	}
}

class Solution {
    public String longestPalindrome(String s) {
        int n=s.length();
        int maxLen=1;
        int beginIdx=0;
        int endIdx=0;
        
        boolean table[][]=new boolean[n][n];
        
        for(int i=0;i<n;i++){
        	for(int j=0;j<n;j++){
        		table[i][j]=false;
        	}
        }
        
        for(int i=0;i<n;i++){
        	table[i][i]=true;
        }
        
        for(int i=0;i<n-1;i++){
        	if(s.charAt(i)==s.charAt(i+1)){
        		table[i][i+1]=true;
        		if(maxLen<2){
					beginIdx=i;
					endIdx=i+1;
				}
        	}
        }
        
        for(int l=2;l<=n;l++){
        	for(int i=0;i<=n-l-1;i++){
        		if(table[i+1][i+l-1]==true){
        			if(s.charAt(i)==s.charAt(i+l)){
        				table[i][i+l]=true;
        				if(maxLen<l+1){
        					beginIdx=i;
        					endIdx=i+l;
        				}
        			}
        		}
        	}
        }
        
        return s.substring(beginIdx,endIdx+1);
        
        
        		
        
    }
}
