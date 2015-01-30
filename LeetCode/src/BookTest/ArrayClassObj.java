package BookTest;
import java.util.*;

public class ArrayClassObj {
    public static void main(String[] args){
    	Random rand=new Random(47);
    	int[] a=new int[rand.nextInt(20)];
    	System.out.println("length of a= "+a.length);
    	System.out.println(Arrays.toString(a));
    	
    }
}
