package StrStrSolution;

public class StrStrSolutionTest {
	public static void main(String[] args){
		String haystack="aaa";
		String needle="aa";
		StrStrSolution s=new StrStrSolution();
		
		int ans=s.strStr(haystack, needle);
		System.out.println("The returned pos is:"+ans);
	}	
}

class StrStrSolution{
	public int strStr(String haystack, String needle){
		if(needle!=null && needle.isEmpty()){
			return 0;
		}
		
		int lenH=haystack.length();
		int lenN=needle.length();
		
		if(lenH<lenN){
			return -1;
		}
		
		for(int i=0;i<lenH-lenN+1;i++){
			int j=0;
			int k=i;
			while(needle.charAt(j)==haystack.charAt(k)){
				if(j==lenN-1){
					return i;
				}
				j++;
				k++;
			}
		}
		
		return -1;		
	}
}
