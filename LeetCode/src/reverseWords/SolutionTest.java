package reverseWords;

import java.util.*;

public class SolutionTest {
	public static void main(String[] args){
		String s="afea   bfe";
		Solution2 sol=new Solution2();
		String output=sol.reverseWords(s);
		System.out.println(output);
	}
}

class Solution{
	public String reverseWords(String s){
		if(s.isEmpty()){
			return "";
		}
		ArrayList<String> words=new ArrayList<String>();
		int wordIni=0;
		int wordEnd=0;
		while(wordEnd<s.length()){
			
			
			while(wordEnd<s.length() && s.charAt(wordEnd)==' '){
				wordEnd++;
				wordIni++;
			}
			
			if(wordEnd==s.length()){
				break;
			}
			
			while(wordEnd<s.length() && s.charAt(wordEnd)!=' '){
				wordEnd++;
			}
			
			String word=s.substring(wordIni, wordEnd);
			words.add(word);
			wordIni=wordEnd;
		}
		
		if(words.size()==0){
			return "";
		}
		
		String[] stockArr=new String[words.size()];
				
		stockArr=words.toArray(stockArr);
		
		String result=stockArr[stockArr.length-1];
		
		for(int i=stockArr.length-2;i>=0;i--){
			result=result+" "+stockArr[i];
		}
		
		return result;
	}
}

class Solution2{
	public String reverseWords(String s){
		if(s==null || s.length()==0){
			return "";
		}
		
		String[] words=s.split(" ");
		StringBuilder sb=new StringBuilder();
		
		for(int i=words.length-1;i>=0;i--){
			if(!words[i].equals("")){
				sb.append(words[i]).append(" ");
			}
		}
		
		return sb.length()==0 ? "" : sb.substring(0,sb.length()-1);
		
		
	}
}