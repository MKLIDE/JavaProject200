package bmicalculator;
import java.util.Scanner;
import java.util.Locale;

public class BmiCalculator {
    //main
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc.useLocale(Locale.US);
		
		char repeat = 0;
		do {
			//All the code
			String name = getUserInfo(sc,"Enter your name: ");
			String gender = getUserInfo(sc,"Enter your gender: F for Female / M for Male ");
			//String email = getUserInfo(sc,"Enter your email: ");
			int unitChoice = getUnitChoice(sc);
			double weight = (unitChoice == 1)? getValidInput(sc,"Enter your weight in kg(s): ", 10, 600) : getValidInput(sc,"Enter your weight in pounds: ",22,1300 );
			double height = (unitChoice == 1)? getValidInput(sc,"Enter your height in meters   : ", 0.5, 2.5) : getValidInput(sc,"Enter your height in inches: ",20,100);
			double waist = (unitChoice == 1)? getValidInput(sc,"Enter your weist in meters   : ", 0.5, 2.5) : getValidInput(sc,"Enter your weist in inches: ",20,100);
			double bmi = calculateBMI(unitChoice, weight, height);
			String feed = DetermineWeist(unitChoice,gender,waist,bmi);
			giveFeedback(name,bmi,weight,feed);
			//System.out.println("Your BMI is "+bmi);
			//System.out.println("final: "feed);
			//repeat = askToRepeat(sc);
			System.out.println();
			
		}while(repeat == 'Y' || repeat == 'y');
    }
	//user's choice function
	public static int getUnitChoice(Scanner sc) {
		int choice;
	
		while(true) {
			System.out.println("Select a preferred unit:\n"
					           + "1. Metric (kg, m)\n"
					           + "2. Imperial (lbs, ln)\n"
					           + "Please select either option 1 or option 2");
			if(sc.hasNextInt()) {
				choice = sc.nextInt();
				if(choice == 1 || choice == 2) {
					break;
				}else {
					System.out.println("Invalid choice. please enter either 1 or 2");
				}
			}else {
				System.out.println("Invalid input. Please enter a number(1 or 2)");
				sc.next();
			}
		}
		return choice;
	    
	}
	//get user's information
	public static String getUserInfo(Scanner sc, String prompt) {
		String info;
		while(true) {
			System.out.println(prompt);
			
			if(sc.hasNextLine()) {
				info = sc.nextLine();
				break;
			}else {
				System.out.println("Invalid input. Please enter a value");
				sc.next();
			}
		}
		return info;
	}
	//get values
	public static double getValidInput(Scanner sc, String prompt, double min, double max) {
		double value;
		while(true) {
			System.out.println(prompt);
			
			if(sc.hasNextDouble()) {
				value = sc.nextDouble();
				if(value >= min && value <= max) {
					break;
				}else {
					System.out.printf("Please enter a value between %.1f and %.1f. \n", min, max);
				}
			}else {
				System.out.println("Invalid input. Please enter a value");
				sc.next();
			}
		}
		return value;
	}
	public static String DetermineWeist(int unitChoice,String gender, double waist, double BMI) {
		String cat = getBMICategory(BMI);
		String value = "";
		if(gender.equals("F")) {	
			if(unitChoice == 1) {
				double convertedWaist = converterToInches(unitChoice,waist);	
				value = mFeedBack(value,cat,BMI,convertedWaist);	
			}else {
				value = mFeedBack(value,cat,BMI,waist);	
			}	
		}else if(gender.equals("M")) {
			if(unitChoice == 1) {
				double convertedWaist = converterToInches(unitChoice,waist);	
				value = mFeedBack(value,cat,BMI,convertedWaist);	
			}else {
				value = mFeedBack(value,cat,BMI,waist);	
			}
		}

		return value;
	}
	
	
	public static double calculateBMI(int unitChoice, double weight, double height) {
		double totalBMI;
		if(unitChoice == 1) {
			totalBMI = weight / (height * height);
		}else {
			totalBMI = (703*weight) / (height/height);
		}
		return totalBMI;
	}
	//converts inches to 
	public static double converterToInches(int unitChoice, double value) {
		double convertedValue;
		if(unitChoice == 1) {
			convertedValue = value * 39.3701;
		}else {
			convertedValue = value;
		}
		return convertedValue;
	}
	public static String getBMICategory(double bmi) {
		String result;
		if(bmi < 18.5) {
			result = "under-weight";
		}else if(bmi >= 18.5 && bmi <= 24.9){
			result = "normal-weight";
		}else if(bmi >= 25.0 && bmi <= 29.9) {
			result = "over-weight";
		}else if(bmi >= 30.0) {
			result = "obese";
		}else {
			result = "Something is wrong";
		}
		return result;
	}
	
	public static String mFeedBack(String value, String cat, double BMI, double waist) {
		if(waist > 40) {
			if(cat.equals("normal")) {
				//risk is high
				value = "Because your weist is "+waist+" and BMI is "+BMI+"("+cat+"), consider a doctor visit.";
			}else if(cat.equals("under")) {
				value = "Check nutrient intake. Low weight + small waist may need dietary support.";
			}else if(cat.equals("over")) {
				value = "Moderate risk. Reduce sugary foods and increase activity.";
			}else {
				value = "High BMI but fat may be distributed safer. Still benefit from weight loss.";
			}
		}else{
			if(cat.equals("normal")) {
				//risk is high
				value = "‘Skinny-fat’ alert! Belly fat raises risks despite normal BMI. Build muscle + cardio.";
			}else if(cat.equals("under")) {
				value = "Uncommon. Rule out muscle loss or illness.";
			}else if(cat.equals("over")) {
				value = "High visceral fat. Urgent lifestyle changes needed.";
			}else {
				value = "Critical risk. Doctor visit recommended for heart/diabetes screening.";
			}
		}
		return value;
	}
	
	public String fFeedBack(String value, String cat, double BMI, double waist) {
		if(waist > 35) {
			if(cat.equals("over")) {
				//risk is lower
				value = "Because your weist is "+waist+", Risk may be lower even if your BMI of "+BMI+" is "+cat;
			}else if(cat.equals("under")) {
				value = "Monitor nutrition. Low weight + small waist may indicate low muscle mass.";
			}else if(cat.equals("normal")) {
				value = "Healthy range! Maintain balanced diet and exercise.";
			}else {
				value = "High BMI("+BMI+") but lower-risk fat distribution. Still aim for gradual weight loss.";
			}	
		}else{
			
			//value = "Because your weist is "+waist+" and BMI is "+BMI+"("+cat+"), consider a doctor visit.";
			if(cat.equals("over")) {
				//risk is lower
				value = "High belly fat. Prioritize fat loss to reduce diabetes/heart risks.";
			}else if(cat.equals("under")) {
				value = "Rare but possible. Consult a doctor to rule out underlying conditions.";
			}else if(cat.equals("normal")) {
				value = "Normal BMI but excess belly fat. Focus on core strength and cardio.";
			}else {
				value = "High BMI + high belly fat. Seek medical guidance for metabolic health.";
			}
		}
		return value;
	}
	
	public static void giveFeedback(String name, double bmi, double weight, String feed) {
		System.out.println(name.toUpperCase()+"'S BMI RECORD:");
		System.out.println("Your BMI is "+bmi+", meaning you're "+getBMICategory(bmi)+".");
		System.out.println("Note: "+feed);
		
	}
	

}
