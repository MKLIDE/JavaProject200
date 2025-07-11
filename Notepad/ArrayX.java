import java.util.*;
public class ArrayX{
        public static void main(String[] args){
	int[] intArray = {0,3,5,6};
	
	int[] intArray1 = new int[5];
	int intArray2[] = {0,3,5,6};

	//intArray1[0] = 123;
	//intArray1[1] = 1234;
	//intArray1[2] = 12345;

	
	System.out.println(intArray[1]);
	System.out.println(intArray1[3]);
	System.out.println(intArray2[1]);
	int counter = 0;
	for(int i = 0; i < intArray1.length; i++){
		counter += 2;
		intArray1[i] = counter;     
	}
	System.out.println(intArray1[2]);
	System.out.println("--------- normal string sorting ---------------");
	String[] colors = {"Blue","Black","Orange"};
	Arrays.sort(colors); // sorting in alpha
	for(String c: colors){
	  System.out.println(c);	
	}
	System.out.println("--------- string sorting of type numbers ---------------");
	String[] strNumbers = {"100","40","25"};
	Arrays.sort(strNumbers); // sort depending on the first appearing least number.
	for(String sn: strNumbers){
	  System.out.println(sn);	
	}
	System.out.println("--------- int sorting ---------------");
	int[] numbers = {1,2,4,5,0,10,100,34};
	Arrays.sort(numbers); // sort depending on the least number (Math).
	for(int n: numbers){
	  System.out.println(n);	
	}
	System.out.println("--------- searching ---------------");
	//Note! You must always sort before searching.
        //syntax: Arrays.binarySearch(array_name,valueToSearchFor) returns the index of the value.
	//formula none-existened-values = (-IndexOfValue) - 1.
        int[] searchingNum = {0,3,3,6,6,8,3,10,45};
        Arrays.sort(searchingNum);
        System.out.println(Arrays.binarySearch(searchingNum,1));
	System.out.println(Arrays.binarySearch(searchingNum,3));
	System.out.println("--------- multi-arrays ---------------");
        //Can't leave both box empty (new int[][]) and you can't leave the first box empty (new int[][4]).
        int[][] multArray = new int[2][3];
	int[][] multArray1 = {{1,2,3},{4,5,6}};
        int multCounter = 0;
        for(int i = 0; i < multArray.length;i++){ // sub arrays
	   for(int j = 0; j < multArray[i].length;j++){ // arrays in sub arrays
		multCounter++;
		multArray[i][j] = multCounter;
	   }
	}
	System.out.println("--------- multi-arrays[2][3] ---------------");
        System.out.println("OB1: "+multArray[0][0]);
	System.out.println("OB1: "+multArray[0][1]);
	System.out.println("OB1: "+multArray[0][2]);
        System.out.println("OB2: "+multArray[1][0]);
	System.out.println("OB2: "+multArray[1][1]);
	System.out.println("OB2: "+multArray[1][2]);
	System.out.println("--------- multi-arrays{{}} ---------------");
        System.out.println("OB1: "+multArray1[0][0]);
	System.out.println("OB1: "+multArray1[0][1]);
	System.out.println("OB1: "+multArray1[0][2]);
        System.out.println("OB2: "+multArray1[1][0]);
	System.out.println("OB2: "+multArray1[1][1]);
	System.out.println("OB2: "+multArray1[1][2]);


	//Enhanced for loop
	System.out.println("--------- multi-arrays{{}} using enhanced for loop ---------------");
	int c = 0;
        for(int[] sub: multArray){
	  c++;
	  for(int subOfsub: sub){
		System.out.println("OB"+c+": "+subOfsub);
	  }
	}
	System.out.println("--------- variable args (flexible) ---------------");
	System.out.println("--------- check the notes for args ---------------");
        int[] aNumbers = {1,2,3};
        System.out.println("Array: "+returnVarargs(aNumbers));
	System.out.println("intnum: "+returnVarargs(30));
         //void printNum(int... numbers){}
         //printNum(1,2,3);
  	 //printNum(new int[]{1,2,3});
	 //printNum(); // numbers = []
         //Avoid overloading to avoid confusion.
         //--> void process(String... item){} This can take String[]/normal String
	 //--> void process(String item){}  This can only take normal String
	 //--> So now imagine if you to call the 'process' method with normal String, which process would java call? The .../item?


	}
        
    	public static <T> T[] returnVarargs(T... items) {
        	return items; // Returns the input varargs as T[]
    	}

      
}