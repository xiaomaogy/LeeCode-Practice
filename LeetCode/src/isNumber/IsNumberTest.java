package isNumber;

public class IsNumberTest {
	public static void main(String[] args){
		String a="1 ";
		String b="122.2132";
		String c="  32fea312";
		Solution s=new Solution();
		System.out.println("a:"+s.isNumber(a));
		System.out.println("b:"+s.isNumber(b));
		System.out.println("c:"+s.isNumber(c));
	}
	
}

class Solution{
	public boolean isNumber(String s){
		char[] temp=s.toCharArray();
		int i=0;
		int len=s.length();
		while(i<len && Character.isWhitespace(temp[i])){
			i++;
		}
		
		if(i==len){
			return false;
		}
		
		if(temp[i]=='+' || temp[i]=='-'){
			i++;
		}
		
		boolean dot=false;
		
		while(i<len && (Character.isDigit(temp[i]) || temp[i]=='.' && dot==false)){
			if(temp[i]=='.'){
				dot=true;
				if((i+1)==len || !Character.isDigit(temp[i+1])){
					if(i-1<0){
						return false;
					}
					if(!Character.isDigit(temp[i-1])){
						return false;
					}
					
				}
			}
			i++;
		}
		
		while(i<len && Character.isWhitespace(temp[i])){
			i++;
		}
		
		if(i==len){
			return true;
		}else{
			return false;
		}
	}
}
