package palindrome;


public class PalindromeTest {
	public static void main(String[] args){
		System.out.println();
		String s="abcbaa";
		Palindrome p=new Palindrome();
		boolean result=p.isPalindrome(s);
		System.out.println(result);
		
	}
}
