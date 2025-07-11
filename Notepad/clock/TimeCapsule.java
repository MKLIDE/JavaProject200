package clock;
import java.time.*;
import java.time.format.DateTimeFormatter;   // For formatting

class TimeCapsule{
	private String title;
	private String message;
	private LocalDate date;
	private LocalTime time;
	private ZoneId zone;
	private boolean reminderSet;

        public TimeCapsule(String title, String message, LocalDate date, LocalTime time, ZoneId zone, Boolean reminderSet){
		this.title = title;
		this.message = message;
		this.date = date;
		this.time = time;
		this.zone = zone;
		this.reminderSet = reminderSet;
	}

	public String getTitle(){
		return this.title;
	}
	public void setTitle(String title){
		this.title = title;
	}
	public String getMessage(){
		return this.message;
	}
	public void setMessage(String message){
		this.message = message;
	}
	public LocalDate getDate(){
		return this.date;
	}
	public void setDate(LocalDate date){
		this.date = date;
	}
	public LocalTime getTime(){
		return this.time;
	}
	public void setTime(LocalTime time){
		this.time = time;
	}
	public ZoneId getZone(){
		return this.zone;
	}
	public void setZone(ZoneId zone){
		this.zone = zone;
	}
	public boolean getReminder(){
		return this.reminderSet;
	}

	public void setReminder(boolean reminderSet){
	     	this.reminderSet = reminderSet;
	}

	public String toFormattedString(){
		LocalDateTime localDateTime = LocalDateTime.of(date, time);
        	ZonedDateTime zonedDateTime = localDateTime.atZone(zone);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm z");
         	return "Title: " + title +
               		"\nMessage: " + message +
               		"\nDate & Time: " + formatter.format(zonedDateTime) +
               		"\nReminder?: " + reminderSet;
	}
        

}