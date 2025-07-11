public class Looping{
	public static void main(String[] args){
		final float initValue = 2.34F;
		final float step = 0.11F;
                final float limit = 4.69F;
                float var = initValue;
                //while loop
		int wCounter = 0;
                 while(var < limit){
                    var += initValue;
                    wCounter++;
		    System.out.println("While loop counter: "+wcounter);
                 }
                //do while loop
		int docounter = 0;
		do{
                   var += initValue;
                   doCounter++;
                   System.out.println("do-While loop counter: "+docounter);
		}while(var <= limit);
                //Ex 2 infinity loop
                //for(;;) System.out.println("aaa"); 
                //Ex 2 compilation error two/more statements = blocks {}.
                //for(int i = 0; i < 10; i++)
                //  System.out.println("aaa");
                //  System.out.println(i);
                //Ex 3
                //for(int i = 0,j = 0;i = 10; j < 10; i++, j--){
                   //System.out.println(i+ "  "+ j);
                //}
                 
	}
}