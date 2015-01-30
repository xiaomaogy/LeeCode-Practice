package BookTest;

public class NewVarArgs {
	static void printArray(Object[] args){
		for(Object obj:args){
			System.out.print(obj+" ");
		}
		System.out.println();
	}
	
	public static void main(String[] args){
		//printArray(1,2,3,4);
		printArray(new Object[]{new Integer(1),new Double(2.0),new Float(1.21)});
		
	}
}
