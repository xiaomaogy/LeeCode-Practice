package enumTest;

public class Burrito {
	Spiciness degree;
	public Burrito(Spiciness degree){
		this.degree=degree;
	}
	
	public void describe(){
		System.out.println("This Burrito is:");
		
		switch(degree){
			case NOT: System.out.println("not spicy at all");
					  	break;
			case MILD:System.out.println("a little hot");
						break;
			case MEDIUM:
			case HOT:
			case FLAMING:
			default:	System.out.println("maybe too hot");
		}
	}
	
	public static void main(String[] args){
		Burrito plain=new Burrito(Spiciness.NOT),
				greenChile=new Burrito(Spiciness.MEDIUM),
				jalapeno=new Burrito(Spiciness.FLAMING);
		
		plain.describe();
		greenChile.describe();
		jalapeno.describe();
		
	}
}
