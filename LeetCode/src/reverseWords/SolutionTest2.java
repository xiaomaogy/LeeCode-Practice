package reverseWords;

import java.util.*;

public class SolutionTest2 {
	public static void main(String[] args){
		String s1="abcd efg";
		char[] s=s1.toCharArray();
		Solution3 sol=new Solution3();
		sol.reverseWords(s);
		System.out.println(s);
	}
}

class Solution3{
	public void reverseWords(char[] tempArray){
		reverse(tempArray,0,tempArray.length);
		for(int i=0,j=0;j<=tempArray.length;j++){
			if(j==tempArray.length || tempArray[j]==' '){
				reverse(tempArray,i,j);
				i=j+1;
			}
			
		}
		//reverse(tempArray,4,7);
	}
	
	private void reverse(char[] s, int begin, int end){
		for(int i=0;i<(Math.ceil(end-begin))/2;i++){
			char temp=s[begin+i];
			s[begin+i]=s[end-i-1];
			s[end-i-1]=temp;
		}
	}
}