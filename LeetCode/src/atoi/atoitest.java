package atoi;



public class atoitest {
	public static void main(String[] args){
		String num1="-1010023630o4";
		char[] numArrayTemp=num1.toCharArray();
		int output=new AtoiMy().atoiMy(num1);
		//System.out.println(Character.isDigit(numArrayTemp[3]));
		System.out.println(output);
		
		int output2=1000000000;
		//output2=output2*10;
		//System.out.println(output2);
		
	}
}


class AtoiMy{
	private static final int maxDiv10=Integer.MAX_VALUE/10;
	int atoiMy(String num){
		int len=num.length();
		char[] numArray=num.toCharArray();
		int i=0;
		
		while(i<len && Character.isWhitespace(numArray[i])){
			i++;
		}
		
		if(i==len){
			return 0;
		}
		
		int sign=1;
		if(numArray[i]=='+'){
			i++;
		}else if(numArray[i]=='-'){
			sign=-1;
			i++;
		}
		
		int result=0;
		while(i<len && Character.isDigit(numArray[i])){
			result=result*10+Character.getNumericValue(numArray[i++]);
			if(result>=maxDiv10){
				if(result==maxDiv10){
					if(Character.isDigit(numArray[i])){
						if(sign==1 && Character.getNumericValue(numArray[i])>7 || sign==(-1) && Character.getNumericValue(numArray[i])>8){
							return sign==1?Integer.MAX_VALUE:Integer.MIN_VALUE;
						}else{
							result=result*10+Character.getNumericValue(numArray[i]);
							return result*sign;
						}
						
						
					}else{
						return sign*result;
					}
				}
				if(Character.isDigit(numArray[i])){
					return sign==1?Integer.MAX_VALUE:Integer.MIN_VALUE;
				}else{
					return sign*result;
				}
			}
			
			
		}
		return sign*result;
	}
	
}
