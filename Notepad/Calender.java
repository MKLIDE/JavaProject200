import java.time.*;   // Main package for date/time classes

import java.time.format.*;   // For formatting
//import java.time.ZonedDateTime;          // Main package for date/time classes
//import java.time.ZonedId;   // For formatting

public class Calender{
   
   public static void main(String[] args){

	//ZonedDateTime zdt = ZonedDateTime.now();
	//System.out.println("SA zone: "+zdt);
	//ZonedId zoneSA = ZonedId.of(Africa/Johannesburg);
	//System.out.println("SAId zone: "+zoneSA);

        //Note! no new key word and index starts at one.
        // Use static .of() method
	// Current date
	LocalDate date = LocalDate.now(); //date format -> .of(year,month,day)
        System.out.println("date:"+date);

        // Specific date
        LocalDate date1 = LocalDate.of(2019,Month.MAY,25); //date format -> .of(year,month,day)
        System.out.println("Before: date:"+date1);
        date1 = date1.plusDays(10).plusWeeks(1); //like string, you must aSSIGN to see a change.
        System.out.println("After:  date:"+date1);

	//Current time
	LocalTime time = LocalTime.now(); //time format -> .of(hours, min)
        System.out.println("time:"+time);
   
        // Specific time
        LocalTime time1 = LocalTime.of(10,00); //time format -> .of(hours, min)
        System.out.println("Before: time:"+time1);
        time1 = time1.plusHours(2).plusMinutes(30); //like string, you must aSSIGN to see a change.
        System.out.println("After:  time:"+time1);

     
        //current date and time
	LocalDateTime currentDateTime = LocalDateTime.now(); //date & time foenat -> .of(date,time)
	System.out.println("(Auto-format) date & time:"+currentDateTime);

      	// Formatting
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM dd yyyy HH:mm");
	//String formatted = time.format(formatter);

	// Parsing
	LocalDateTime parsedDateTime = LocalDateTime.parse("05-07-2025 14:30", formatter);
	System.out.println("(formatted) date & time:"+parsedDateTime);	


	/*LocalDate styleDate = LocalDate.of(2025,Month.MAY,25);
	DateTimeFormatter formatter1 = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
	String formatted1 = styleDate.format(formatter1);
	System.out.println("(style-formatted) date & time:"+formatted1);



        //specific date and time
	LocalDateTime specificDateTime = LocalDateTime.of(date1,time1); //date & time foenat -> .of(date,time)
	System.out.println("Before: date & time:"+specificDateTime);
        
	//Period (works only with dates) to determine the gap between two times
	Period dateGap = Period.between(date1,date);
        System.out.println("Gap in month: "+dateGap.getMonths());

        //Duration (works only with time) to determine the gap between two times
	//Duration timeGap = Duration.between(time,time2);
        //System.out.println("minutes in between: "+timeGap.getMinutes());*/

  

   }
}