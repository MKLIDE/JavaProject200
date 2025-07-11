package clock;
import java.util.*;
import java.time.*;
import java.time.format.*;
import clock.TimeCapsule;

public class Main{
   	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.println("How many capsules do want to create? ");
   		int numCapsules = Integer.parseInt(sc.nextLine());
		List<TimeCapsule> timeCapsules = new ArrayList<>(numCapsules);
                		
		System.out.println("Welcome to world clock capsule Adventure");
		System.out.println("You have "+numCapsules+" to set up...");

		for(int c = 1; c <= numCapsules; c++){
			System.out.println("Capsule #" + (c));
             		System.out.println("Enter time-capsule("+c+") title: ");
			String title = sc.nextLine();
			System.out.println("Enter time-capsule("+c+") message: ");
			String message = sc.nextLine();
			System.out.println("Enter time-capsule("+c+") date (yyyy-MM-dd): ");
			LocalDate date = LocalDate.parse(sc.nextLine());
			System.out.println("Enter time-capsule("+c+") time (HH:mm) ("+c+"): ");
			LocalTime time = LocalTime.parse(sc.nextLine());
			System.out.println("Enter time-capsule("+c+") zone (eg., Europe/Paris):  ");
			ZoneId zone = ZoneId.of(sc.nextLine());
			System.out.println("Enter time-capsule("+c+") reminder: ");
			boolean reminder = Boolean.parseBoolean(sc.nextLine());
			TimeCapsule capsule = new TimeCapsule(title,message,date,time,zone,reminder);
			timeCapsules.add(capsule);
		}
		int counter = 0;
		DateTimeFormatter dateTimeF = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		DateTimeFormatter zoneDateTimeF = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm z");
		
		for(TimeCapsule cap: timeCapsules){
			counter++;
			LocalDateTime dateTime = LocalDateTime.of(cap.getDate(),cap.getTime());
			System.out.println("Time-capsule ("+counter+") Local DateTime is "+dateTimeF.format(dateTime));
			System.out.println("Time-capsule ("+counter+") Local DateTimeZone is "+zoneDateTimeF.format(convToZonedDateTime(dateTime,cap.getZone())));
		}
		int menuOption = 0;
                do{
                	System.out.println("Choose the zones below:\n"+
				   	"(1) For Locale.France.\n"+
				   	"(2) For Local.Japan");
			menuOption = sc.nextInt();
			int countCaps = 0;
			TimeCapsule firstCap = timeCapsules.get(0);
			LocalDateTime firstDateTime = LocalDateTime.of(firstCap.getDate(),firstCap.getTime());
			if(menuOption == 1){
				Locale fLocale = Locale.FRANCE;
		   		DateTimeFormatter franceFormatter = DateTimeFormatter.ofPattern("EEEE, d MMMM yyyy",fLocale);	
				String firstFormatDateTime = firstDateTime.format(franceFormatter);
				System.out.println("First Capsule Date in: France:" +firstFormatDateTime);
				break;	
			}else if(menuOption == 2){
				Locale jLocale = Locale.JAPAN;
		   		DateTimeFormatter japanFormatter = DateTimeFormatter.ofPattern("EEEE, d MMMM yyyy",jLocale);
				String firstFormatDateTime = firstDateTime.format(japanFormatter);
				System.out.println("First Capsule Date in: Japan:" +firstFormatDateTime);
				break;
                	}else{
				System.out.println("Invalid option. Type either (1/2)");
			}

                }while(menuOption != 1 || menuOption != 2);

	 	//Using Period and Duration to calculate time left
    		System.out.println("\n--- Time Remaining for Each Capsule ---");
    		LocalDateTime now = LocalDateTime.now();

    		for (TimeCapsule capsule : timeCapsules) {
       			LocalDateTime capsuleDateTime = LocalDateTime.of(capsule.getDate(), capsule.getTime());
        		if (capsuleDateTime.isAfter(now)) {
            		Period period = Period.between(now.toLocalDate(), capsuleDateTime.toLocalDate());
            		Duration duration = Duration.between(now, capsuleDateTime);
            		long minutes = duration.toMinutes();

            		System.out.println("Capsule \"" + capsule.getTitle() + "\":");
            		System.out.println("Days remaining: " + period.getDays());
            		System.out.println("Minutes remaining: " + minutes);
        		} else {
            			System.out.println("Capsule \"" + capsule.getTitle() + "\" has already passed.");
        		}
    		}
		//Print all capsules
		System.out.println("\nAll Capsules displayed here!!!!!!!!!!");
    		Iterator<TimeCapsule> iterator = timeCapsules.iterator();
    		while (iterator.hasNext()) {
        		System.out.println(iterator.next().toFormattedString());
        		System.out.println("****************************************");
    		}
    
    
    		System.out.print("Would you like to filter by 'zone' or 'date'? ");
    		String filterChoice = sc.nextLine().toLowerCase();

    		if (filterChoice.equals("zone")) {
        		System.out.print("Enter the zone to filter by (e.g., Europe/Paris): ");
        		String zoneInput = sc.nextLine();

        		System.out.println("\n--- Capsules in Zone: " + zoneInput + " ---");
        		for (TimeCapsule capsule : timeCapsules) {
            			if (capsule.getZone().toString().equalsIgnoreCase(zoneInput)) {
                			System.out.println(capsule.toFormattedString());
                			System.out.println("---------------------------");
            			}
        		}

   	 	} else if (filterChoice.equals("date")) {
        		System.out.print("Enter the date to filter by (yyyy-MM-dd): ");
        		String dateInput = sc.nextLine();
        		LocalDate filterDate = LocalDate.parse(dateInput);

        		System.out.println("\n--- Capsules on Date: " + filterDate + " ---");
        		for (TimeCapsule capsule : timeCapsules) {
           			if (capsule.getDate().equals(filterDate)) {
                			System.out.println(capsule.toFormattedString());
               				System.out.println("---------------------------");
            			}
        		}

   		} else {
        		System.out.println("Invalid filter type. Please enter 'zone' or 'date'.");
    		}
    		sc.close();                

                		 
   	}
        public static LocalDateTime convToDateTime(LocalDate date, LocalTime time){
		LocalDateTime dateTime = LocalDateTime.of(date,time);
                return dateTime;
        }

        public static ZonedDateTime convToZonedDateTime(LocalDateTime dateTime, ZoneId zone){
		ZonedDateTime zoned = dateTime.atZone(zone);
                return zoned;
        }



}