public class StrWord{
	public static void main(String[] args){

		String word = "Java";
		System.out.println(word.charAt(1));

		String name = "Alice";
		System.out.println(name.length());

		String result = String.format("My score is %d",90);
		System.out.println(result);

		String empty = "";
		System.out.println(empty.isEmpty());

		String word2 = "programming";
		System.out.println(word2.substring(0,6));

		String sentance = "I love you";
		System.out.println(sentance.contains("love"));

		String joined = String.join(":::","red","blue","green");
		System.out.println(joined);

		String conc1 = "Motlwang";
		String conc2 = "Makotoko";
		System.out.println(con1.concat(conc2));
		//-------------------------
                String sentence = "Java is fun";
                String[] words = sentense.split(" ");
                System.out.println(words[0]);
                
 		String a = new String("cat");
		String b = "cat";
		System.out.println(a.intern() == b)//true
        	
		String text = "Elephant";
		System.out.println(text.indexOf("p"));

		//toUpperCase(), toLowerCase() and trim()
		String z = " Elephant zone ";
		z = z.trim(); // assign to apply the trim method. Note! trim only trim outer spaces.
		System.out.println(z);

                //--------------- strbuilder-----------
                StringBuilder sb = new StringBuilder("Hello");
		sb.append("World");
		System.out.println(sb) // hello world

		sb.insert(5, "java");
		System.out.println(sb) // hello world
  
		sb.delete(5, 10);
		System.out.println(sb) // hello

		sb.deleteCharAt(l);
		System.out.println(sb) // hillo

		sb.reverse();
		System.out.println(sb) // olleh



	}

}