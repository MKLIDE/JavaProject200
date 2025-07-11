public class PredicateX{

   public static void main(String[] args){
        list<Animal> animals = Arrays.asList(new Animal("fish","false",true"),new Animal("Kangaroo","false",true")));
	
	animals.forEach(a -> System.out.println(a + " can hop? " + ((Predicate<Animal>) animal -> animal.canHop()).test(a)));
   }
}

public class Animal{
	private String type;
	private boolean hop;
	private boolean dance;
        Animal( String type, boolean hop, boolean dance){
		this.type = type;
		this.hop = hop;
		this.dance = dance;
	}
	public String getType(){ return this.type;}
	public String getHop(){ return this.hop;}
	public String getDance(){ return this.dance;}
    	
	public String toString(){
		return this.type;
	}

}
